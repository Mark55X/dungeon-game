package com.onn.dungeongame.world;

import java.io.*;
import java.awt.*;
import java.net.*;
import com.onn.dungeongame.tiles.*;
import com.onn.dungeongame.*;
import com.onn.dungeongame.gfx.*;
import com.onn.dungeongame.camera.*;

public class World {
    private int width;
    private int height;
    private int playerX;
    private int playerY;
    private Tile[][] tiles;

    public void loadWorld(URL path) {
        try {
            // Load the world

            /*
             * The world format must be as following
             *
             * w h px py tiles...
             *
             * where:
             *      w is the world width
             *      h is the world height
             *      px is the player x spawn position
             *      py is the player y spawn position
             *      tiles... from now on there must be w * h tiles
             *
             * Every tile is defined by an ID number (see com.onn.dungeongame.tiles.Tile)
             */

            BufferedReader br = new BufferedReader(new InputStreamReader(path.openStream()));
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

            // From now on get the tiles
            for(int i = 4; i < tokens.length; i++) {
                tiles[x][y] = Tile.tiles[Integer.parseInt(tokens[i])];
                x++;

                if(x == width) {
                    x = 0;
                    y++;
                }
            }

            System.out.println("There are " + (tokens.length - 4) + " tiles");
        } catch(IOException ex) {
            System.out.println("Failed to load world: " + ex.getMessage());
            System.exit(1);
        } catch(NumberFormatException|ArrayIndexOutOfBoundsException ex) {
            System.out.println("Invalid world format");
            System.exit(1);
        }
    }

    public void tick() {
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                tiles[x][y].tick();
            }
        }
    }

    public void render(Graphics g) {
        // Render stuff here
        g.drawImage(Assets.world_background, 0, 0, Handler.getWidth(), Handler.getHeight(), null);

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                g.drawImage(tiles[x][y].getTexture(), (int) (x * Tile.TILEWIDTH - Handler.getCamera().getX()), (int) (y * Tile.TILEHEIGHT - Handler.getCamera().getY()), Tile.TILEWIDTH, Tile.TILEHEIGHT, null);
            }
        }
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
}
