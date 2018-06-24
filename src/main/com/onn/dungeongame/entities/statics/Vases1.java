package com.onn.dungeongame.entities.statics;

import java.awt.*;
import com.onn.dungeongame.*;
import com.onn.dungeongame.gfx.*;

public class Vases1 extends StaticEntity {

	public Vases1(int x, int y) {
		super(x, y);
		setBounds(0, 26, 32, 2);
		setDimension(32, 32);
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.vases_1, (int) (x - Handler.getCamera().getX()),
		(int) (y - Handler.getCamera().getY()), size.width, size.height, null);
	}

}
