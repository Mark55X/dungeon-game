package com.onn.dungeongame.tiles;

import com.onn.dungeongame.gfx.*;

public class BlankTile extends Tile {

	public BlankTile(int id) {
		super(id);
		texture = Assets.blank;
	}

	@Override
	public boolean isSolid() {
		return true;
	}

}
