package com.onn.dungeongame.tiles;

import com.onn.dungeongame.gfx.*;

public class WallTop1Tile extends Tile {

	public WallTop1Tile(int id) {
		super(id);
		texture = Assets.wall_top_1;
	}

	@Override
	public boolean isSolid() {
		return true;
	}

}
