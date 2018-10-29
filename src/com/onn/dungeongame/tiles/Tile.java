package com.onn.dungeongame.tiles;

import java.awt.image.BufferedImage;

public class Tile {

    public static Tile[] tiles = new Tile[17];
    public static Tile grassTile = new GrassTile(0);
    public static Tile dirtTile = new DirtTile(1);
    public static Tile sandTile = new SandTile(2);
    public static Tile rockTile = new RockTile(3);
	public static Tile wallLeft1Tile = new WallLeft1Tile(4);
	public static Tile wallRight1Tile = new WallRight1Tile(5);
	public static Tile wallTop1Tile = new WallTop1Tile(6);
	public static Tile wallBottom1Tile = new WallBottom1Tile(7);
	public static Tile wallVerticalContinuation1Tile = new WallVerticalContinuation1Tile(8);
	public static Tile wallHorizontalContinuation1Tile = new WallHorizontalContinuation1Tile(9);
	public static Tile cobbleStoneMossy1Tile = new CobbleStoneMossy1Tile(10);
	public static Tile cobbleStoneFloor1Tile = new CobbleStoneFloor1Tile(11);
	public static Tile blankTile = new BlankTile(12);
	public static Tile tiledFloor1Tile = new PlankFloor1Tile(13);

    public static final int TILEWIDTH = 32;
    public static final int TILEHEIGHT = 32;

    private int id;

    protected BufferedImage texture;

    public Tile(int id) {
        tiles[id] = this;
        this.id = id;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void tick() {

    }

	public boolean isSolid() {
		return false;
	}

    public int getID() {
        return id;
    }

}
