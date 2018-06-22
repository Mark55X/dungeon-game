package com.onn.dungeongame.tiles;

import java.awt.*;
import java.awt.image.*;

public class Tile {

    public static Tile[] tiles = new Tile[4];
    public static Tile grassTile = new GrassTile(0);
    public static Tile dirtTile = new DirtTile(1);
    public static Tile sandTile = new SandTile(2);
    public static Tile rockTile = new RockTile(3);

    protected BufferedImage texture;

    public Tile(int id) {
        tiles[id] = this;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void tick() {

    }

}