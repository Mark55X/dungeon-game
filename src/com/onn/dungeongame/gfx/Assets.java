package com.onn.dungeongame.gfx;

import com.onn.dungeongame.util.Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {

    private static BufferedImage sheet;
	private static BufferedImage player_sheet;
	private static BufferedImage sheet2;
    private static BufferedImage tiles_sheet;

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
	public static BufferedImage plank_floor_1;

	public static Font font28;
	public static Font font14;

	public static BufferedImage[] player_blue_up;
	public static BufferedImage[] player_blue_down;
	public static BufferedImage[] player_blue_right;
	public static BufferedImage[] player_blue_left;
	public static BufferedImage[] attacking;

    private static final int TILEWIDTH = 32;
    private static final int TILEHEIGHT = 32;

	private static final int PLAYER_SPRITES_ROWS = 8;
	private static final int PLAYER_SPRITES_COLS = 12;

    public static void init() {
        sheet        = load("/drawable/sheet.png");
        player_sheet = load("/drawable/player_sheet.png");
		sheet2       = load("/drawable/sheet2.png");
        tiles_sheet  = load("/drawable/tiles-spritesheet.png");

        rock_1                         = crop(sheet, 60, 4);
        grass_1                        = crop(sheet, 15, 9);
        sand_1                         = crop(sheet, 3, 4);
        dirt_1                         = crop(sheet, 10, 7);
        cobblestone_mossy_1            = crop(sheet, 22, 4);
        cobblestone_floor_1            = crop(sheet, 22, 14);
        drop_log_1                     = crop(sheet, 39, 43);
		wall_left_1                    = crop(sheet2, 2, 5);
		wall_top_1                     = crop(sheet2, 4, 6);
		wall_bottom_1                  = crop(sheet2, 6, 6);
		wall_vertical_continuation_1   = crop(sheet2, 5, 6);
		wall_horizontal_continuation_1 = crop(sheet2, 7, 5);
		plank_floor_1                  = crop(tiles_sheet, 1, 0);
		blank                          = crop(sheet2, 28, 9);
		log_1                          = crop(sheet2, 1, 8);
		vases_1                        = crop(sheet2, 3, 9);
		wall_right_1                   = Utils.rotateCw(Utils.rotateCw(wall_left_1));

		player_blue_up = new BufferedImage[3];
		player_blue_up[0] = crop(player_sheet, 0, 3);
		player_blue_up[1] = crop(player_sheet, 1, 3);
		player_blue_up[2] = crop(player_sheet, 2, 3);

		player_blue_down = new BufferedImage[3];
		player_blue_down[0] = crop(player_sheet, 0, 0);
		player_blue_down[1] = crop(player_sheet, 1, 0);
		player_blue_down[2] = crop(player_sheet, 2, 0);

		player_blue_left = new BufferedImage[3];
		player_blue_left[0] = crop(player_sheet, 0, 1);
		player_blue_left[1] = crop(player_sheet, 1, 1);
		player_blue_left[2] = crop(player_sheet, 2, 1);

		player_blue_right = new BufferedImage[3];
		player_blue_right[0] = crop(player_sheet, 0, 2);
		player_blue_right[1] = crop(player_sheet, 1, 2);
		player_blue_right[2] = crop(player_sheet, 2, 2);

		attacking = new BufferedImage[8];
		attacking[0] = crop(sheet, 47, 25);
		attacking[1] = crop(sheet, 48, 25);
		attacking[2] = crop(sheet, 49, 25);
		attacking[3] = crop(sheet, 50, 25);
		attacking[4] = crop(sheet, 51, 25);
		attacking[5] = crop(sheet, 52, 25);
		attacking[6] = crop(sheet, 53, 25);
		attacking[7] = crop(sheet, 54, 25);

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

    private static BufferedImage crop(BufferedImage image, int x, int y) {
        return image.getSubimage(x * TILEWIDTH, y * TILEHEIGHT, TILEWIDTH, TILEHEIGHT);
    }

}
