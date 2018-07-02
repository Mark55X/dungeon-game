package com.onn.dungeongame.tiles;

import com.onn.dungeongame.gfx.*;

public class WallBottom1Tile extends Tile {

	public WallBottom1Tile(int id) {
		super(id);
		texture = Assets.wall_bottom_1;
	}

	@Override
	public boolean isSolid() {
		return true;
	}

}
