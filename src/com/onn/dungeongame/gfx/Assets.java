package com.onn.dungeongame.gfx;

import com.onn.dungeongame.util.Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {

    private static BufferedImage sheet;
	private static BufferedImage player_sheet;
	private static BufferedImage sheet2;

    public static BufferedImage rock_1;
    public static BufferedImage grass_1;
    public static BufferedImage sand_1;
	public static BufferedImage dirt_1;
	public static BufferedImage wall_left_1;
	public static BufferedImage wall_right_1;
	public static BufferedImage wall_top_1;
	public static BufferedImage wall_bottom_1;
	public static BufferedImage wall_vertical_continuation_1;
	public static BufferedImage wall_horizontal_continuation_1;
	public static BufferedImage cobblestone_mossy_1;
	public static BufferedImage cobblestone_floor_1;
	public static BufferedImage blank;
	public static BufferedImage log_1;
	public static BufferedImage vases_1;
	public static BufferedImage drop_log_1;

	public static Font font28;
	public static Font font14;

	public static BufferedImage world_background;

	public static BufferedImage[] player_blue_up;
	public static BufferedImage[] player_blue_down;
	public static BufferedImage[] player_blue_right;
	public static BufferedImage[] player_blue_left;
	public static BufferedImage[] attacking;

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
		sheet2 = load("/drawable/sheet2.png");

		wall_left_1 = crop2(2, 5);
		wall_right_1 = Utils.rotateCw(Utils.rotateCw(wall_left_1));
		wall_top_1 = crop2(4, 6);
		wall_bottom_1 = crop2(6, 6);
		wall_vertical_continuation_1 = crop2(5, 6);
		wall_horizontal_continuation_1 = crop2(7, 5);
        rock_1 = crop(60, 4);
        grass_1 = crop(15, 9);
        sand_1 = crop(3, 4);
        dirt_1 = crop(10, 7);
		cobblestone_mossy_1 = crop(22, 4);
		cobblestone_floor_1 = crop(22, 14);
		blank = crop2(28, 9);
		log_1 = crop2(1, 8);
		vases_1 = crop2(3, 9);
		drop_log_1 = crop(39, 43);

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

		attacking = new BufferedImage[8];
		attacking[0] = crop(47, 25);
		attacking[1] = crop(48, 25);
		attacking[2] = crop(49, 25);
		attacking[3] = crop(50, 25);
		attacking[4] = crop(51, 25);
		attacking[5] = crop(52, 25);
		attacking[6] = crop(53, 25);
		attacking[7] = crop(54, 25);

		font28 = FontLoader.loadFont(Assets.class.getResource("/font/slkscr.ttf"), 28);
		font14 = FontLoader.loadFont(Assets.class.getResource("/font/slkscr.ttf"), 14);
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

	private static BufferedImage crop2(int x, int y) {
		return sheet2.getSubimage(x * TILEWIDTH, y * TILEHEIGHT, TILEWIDTH, TILEHEIGHT);
	}

}
