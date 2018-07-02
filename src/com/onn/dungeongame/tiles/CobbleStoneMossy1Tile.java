package com.onn.dungeongame.tiles;

import com.onn.dungeongame.gfx.*;

public class CobbleStoneMossy1Tile extends Tile {

	public CobbleStoneMossy1Tile(int id) {
		super(id);
		texture = Assets.cobblestone_mossy_1;
	}

	@Override
	public boolean isSolid() {
		return true;
	}

}
