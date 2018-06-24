package com.onn.dungeongame.entities.statics;

import java.awt.*;
import com.onn.dungeongame.gfx.*;
import com.onn.dungeongame.*;
import com.onn.dungeongame.tiles.*;
import com.onn.dungeongame.entities.statics.*;

public class WineBottle1 extends StaticEntity {

	public WineBottle1(int x, int y) {
		super(x, y);
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 0;
		bounds.height = 0;
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.wine_bottle_1, (int) (x - Handler.getCamera().getX()), (int) (y - Handler.getCamera().getY()), Tile.TILEWIDTH, Tile.TILEHEIGHT, null);
	}

}
