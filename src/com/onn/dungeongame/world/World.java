package com.onn.dungeongame.world;

import com.onn.dungeongame.Handler;
import com.onn.dungeongame.entities.EntityManager;
import com.onn.dungeongame.item.ItemManager;
import com.onn.dungeongame.tiles.Tile;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.net.URL;

public class World {
    private int width;
    private int height;
    private int playerX;
    private int playerY;
    private Tile[][] tiles;
	private EntityManager entityManager;
	private ItemManager itemManager;
    private String path;

    public World() {
        init();
    }

	private void init() {
		Handler.setWorld(this);
		itemManager = new ItemManager();
	}

    public void loadItemWorld(String path) {
        itemManager.loadFromFile(path);
    }

    public void loadWorld(String path) {
        this.path = path;

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            String content, line;
            StringBuilder sb = new StringBuilder();

            while((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();

            content = sb.toString();

            String[] tokens = content.split("\\s+");

            width = Integer.parseInt(tokens[0]);
            height = Integer.parseInt(tokens[1]);
            playerX = Integer.parseInt(tokens[2]);
            playerY = Integer.parseInt(tokens[3]);

            tiles = new Tile[width][height];

            int x = 0;
            int y = 0;

			int i;
            for(i = 4; i < tokens.length; i++) {
                tiles[x][y] = Tile.tiles[Integer.parseInt(tokens[i])];
                x++;

                if(x == width) {
                    x = 0;
                    y++;
                }

				if(y == height) {
					break;
				}
            }

			Handler.getPlayer().setX(playerX);
			Handler.getPlayer().setY(playerY);
        } catch(IOException ex) {
            System.out.println("Failed to load world: " + ex.getMessage());
            System.exit(1);
        } catch(NumberFormatException|ArrayIndexOutOfBoundsException ex) {
            System.out.println("Invalid world format");
            System.exit(1);
        }
		entityManager = new EntityManager();
    }

    public void tick() {
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                tiles[x][y].tick();
            }
        }

		entityManager.tick();
		itemManager.tick();
    }

    public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Handler.getWidth(), Handler.getHeight());

		int xs = Math.max(0, (int) (Handler.getCamera().getX() / Tile.TILEWIDTH));
		int xe = Math.min(width, (int) (Handler.getCamera().getX() + Handler.getWidth()) / Tile.TILEWIDTH + 1); // x end (rendering)
		int ys = Math.max(0, (int) (Handler.getCamera().getY() / Tile.TILEHEIGHT)); // y start (rendering)
		int ye = Math.min(height, (int) (Handler.getCamera().getY() + Handler.getHeight()) / Tile.TILEHEIGHT + 1); // y end (rendering)

        for(int y = ys; y < ye; y++) {
            for(int x = xs; x < xe; x++) {
                g.drawImage(tiles[x][y].getTexture(), (int) (x * Tile.TILEWIDTH - Handler.getCamera().getX()), (int) (y * Tile.TILEHEIGHT - Handler.getCamera().getY()), Tile.TILEWIDTH, Tile.TILEHEIGHT, null);
            }
        }

		itemManager.render(g);

		entityManager.render(g);
    }

	public Tile getTile(int x, int y) {
		return tiles[x][y];
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

    public void save() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path)));

            bw.write(String.valueOf(width) + " " + String.valueOf(height));
            bw.write("\n");
            bw.write(String.valueOf(Handler.getPlayer().getX()) + " " + String.valueOf(Handler.getPlayer().getY()));
            bw.write("\n");

            for(int y = 0; y < height; y++) {
                for(int x = 0; x < width; x++) {
                    bw.write(String.valueOf(tiles[x][y].getID()));
                }
            }

            bw.close();
        } catch(IOException ex) {
            System.out.println("Failed to save \'" + path + "\': " + ex.getMessage());
        }
    }
}
