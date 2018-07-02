package com.onn.dungeongame.tiles;

import com.onn.dungeongame.gfx.*;

public class WallVerticalContinuation1Tile extends Tile {

	public WallVerticalContinuation1Tile(int id) {
		super(id);
		texture = Assets.wall_vertical_continuation_1;
	}

	@Override
	public boolean isSolid() {
		return true;
	}

}
