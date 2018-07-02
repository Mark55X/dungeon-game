package com.onn.dungeongame.tiles;

import com.onn.dungeongame.gfx.*;

public class RockTile extends Tile {

    public RockTile(int id) {
        super(id);
        texture = Assets.rock_1;
    }

	@Override
	public boolean isSolid() {
		return true;
	}

}
