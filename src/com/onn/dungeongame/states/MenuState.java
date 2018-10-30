package com.onn.dungeongame.states;

import com.onn.dungeongame.Handler;
import com.onn.dungeongame.gfx.Assets;
import com.onn.dungeongame.gfx.Text;

import java.awt.*;

public class MenuState extends State {
	@Override
	public void tick() {
		if(Handler.getMouseInput().left()) {
			State.setState(Handler.getGame().playState);
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Handler.getWidth(), Handler.getHeight());
		Text.draw(g, "WASD", 10, 10 + 14, false, Color.WHITE, Assets.font14);
		Text.draw(g, "Move around", 500, 10 + 14, false, Color.WHITE, Assets.font14);
		Text.draw(g, "ENTER", 10, 10 + 14 * 2, false, Color.WHITE, Assets.font14);
		Text.draw(g, "Attack", 500, 10 + 14 * 2, false, Color.WHITE, Assets.font14);
		Text.draw(g, "I", 10, 10 + 14 * 3, false, Color.WHITE, Assets.font14);
		Text.draw(g, "Open inventory", 500, 10 + 14 * 3, false, Color.WHITE, Assets.font14);
		Text.draw(g, "UP ARROW / DOWN ARROW", 10, 10 + 14 * 4, false, Color.WHITE, Assets.font14);
		Text.draw(g, "Select items in inventory", 500, 10 + 14 * 4, false, Color.WHITE, Assets.font14);
	}

}
