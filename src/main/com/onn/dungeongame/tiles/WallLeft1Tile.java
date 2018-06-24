package com.onn.dungeongame.tiles;

import com.onn.dungeongame.gfx.*;

public class WallLeft1Tile extends Tile {

	public WallLeft1Tile(int id) {
		super(id);
		texture = Assets.wall_left_1;
	}

	@Override
	public boolean isSolid() {
		return true;
	}

}
