package com.onn.dungeongame.entities.creature;

import java.awt.*;
import com.onn.dungeongame.gfx.*;

public class Player extends Creature {

	public Player(int x, int y) {
		super(x, y);
		bounds.x = 13;
		bounds.y = 15;
		bounds.width = 8;
		bounds.height = 18;
		texture = Assets.player;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(texture, x, y, size.width, size.height, null);

		g.setColor(Color.red);
		g.fillRect(x + bounds.x, y + bounds.y, bounds.width, bounds.height);
	}

}
