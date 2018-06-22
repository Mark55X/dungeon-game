package com.onn.dungeongame.gfx;

import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class Assets {

    private static BufferedImage sheet;
	private static BufferedImage player_sheet;

    public static BufferedImage rock_1;
    public static BufferedImage grass_1;
    public static BufferedImage sand_1;
	public static BufferedImage dirt_1;
	public static BufferedImage world_background;

	public static BufferedImage[] player_blue_up;
	public static BufferedImage[] player_blue_down;
	public static BufferedImage[] player_blue_right;
	public static BufferedImage[] player_blue_left;

    private static final int TILEWIDTH = 32;
    private static final int TILEHEIGHT = 32;
	private static final int PLAYERWIDTH = 32;
	private static final int PLAYERHEIGHT = 32;

	private static final int PLAYER_SPRITES_ROWS = 8;
	private static final int PLAYER_SPRITES_COLS = 12;

    public static void init() {
        sheet = load("/drawable/sheet.png");
        player_sheet = load("/drawable/player_sheet.png");
        world_background = load("/drawable/world_background.png");

        rock_1 = crop(60, 4);
        grass_1 = crop(15, 9);
        sand_1 = crop(3, 4);
        dirt_1 = crop(10, 7);

		player_blue_up = new BufferedImage[3];
		player_blue_up[0] = cropPlayer(0, 3);
		player_blue_up[1] = cropPlayer(1, 3);
		player_blue_up[2] = cropPlayer(2, 3);

		player_blue_down = new BufferedImage[3];
		player_blue_down[0] = cropPlayer(0, 0);
		player_blue_down[1] = cropPlayer(1, 0);
		player_blue_down[2] = cropPlayer(2, 0);

		player_blue_left = new BufferedImage[3];
		player_blue_left[0] = cropPlayer(0, 1);
		player_blue_left[1] = cropPlayer(1, 1);
		player_blue_left[2] = cropPlayer(2, 1);

		player_blue_right = new BufferedImage[3];
		player_blue_right[0] = cropPlayer(0, 2);
		player_blue_right[1] = cropPlayer(1, 2);
		player_blue_right[2] = cropPlayer(2, 2);
    }

    private static BufferedImage load(String path) {
        try {
            return ImageIO.read(Assets.class.getResource(path));
        } catch(Exception ex) {
            System.out.println("Failed to load \'" + path + "\': " + ex.getMessage());
            System.exit(1);
        }

        return null;
    }

    private static BufferedImage crop(int x, int y) {
        return sheet.getSubimage(x * TILEWIDTH, y * TILEHEIGHT, TILEWIDTH, TILEHEIGHT);
    }

	private static BufferedImage cropPlayer(int x, int y) {
		return player_sheet.getSubimage(x * PLAYERWIDTH, y * PLAYERHEIGHT, PLAYERWIDTH, PLAYERHEIGHT);
	}

}
