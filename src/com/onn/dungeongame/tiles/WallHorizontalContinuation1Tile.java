package com.onn.dungeongame.tiles;

import com.onn.dungeongame.gfx.*;

public class WallHorizontalContinuation1Tile extends Tile {

	public WallHorizontalContinuation1Tile(int id) {
		super(id);
		texture = Assets.wall_horizontal_continuation_1;
	}

	@Override
	public boolean isSolid() {
		return true;
	}

}
