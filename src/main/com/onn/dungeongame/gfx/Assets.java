package com.onn.dungeongame.gfx;

import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class Assets {
    
    private static BufferedImage sheet;
    
    public static BufferedImage rock_1;
    public static BufferedImage grass_1;
    public static BufferedImage sand_1;
    public static BufferedImage dirt_1;
    public static BufferedImage player;
    public static BufferedImage world_background;

    private static final int TILEWIDTH = 32;
    private static final int TILEHEIGHT = 32;

    public static void init() {
        sheet = load("/drawable/sheet.png");
        player = load("/drawable/player.png");
        world_background = load("/drawable/world_background.png");

        rock_1 = crop(60, 4);
        grass_1 = crop(15, 9);
        sand_1 = crop(3, 4);
        dirt_1 = crop(10, 7);
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

}