package com.onn.dungeongame.tiles;

import com.onn.dungeongame.gfx.*;

public class WallRight1Tile extends Tile {

	public WallRight1Tile(int id) {
		super(id);
		texture = Assets.wall_right_1;
	}

	@Override
	public boolean isSolid() {
		return true;
	}

}
