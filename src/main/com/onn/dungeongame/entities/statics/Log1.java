package com.onn.dungeongame.entities.statics;

import java.awt.*;
import com.onn.dungeongame.*;
import com.onn.dungeongame.gfx.*;
import com.onn.dungeongame.item.*;

public class Log1 extends StaticEntity {

	public Log1(int x, int y) {
		super(x, y);
		setBounds(0, 16, 32, 10);
		setDimension(32, 32);
	}

	@Override
	public void die() {
		Handler.getWorld().getItemManager().addItem(Item.wood1Item.createNew(x, y));
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.log_1, (int) (x - Handler.getCamera().getX()),
		(int) (y - Handler.getCamera().getY()), size.width, size.height, null);
	}

}
