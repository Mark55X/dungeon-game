package com.onn.dungeongame.states;

import java.awt.*;
import com.onn.dungeongame.*;
import com.onn.dungeongame.font.*;

public class MenuState extends State {

	private com.onn.dungeongame.font.Font font;

	public MenuState() {
		font = new com.onn.dungeongame.font.Font();
		font.setWidth(61);
		font.setHeight(65);
		font.setCharCount(95);
		font.loadFont("/font/font.png");
		font.load();
	}

	@Override
	public void tick() {
		if(Handler.getMouseInput().left()) {
			State.setState(Handler.getGame().playState);
		}
	}

	@Override
	public void render(Graphics g) {
		font.write("Click anywhere to start ...", g, 0, Handler.getHeight() - 22, 23, 0, 22, 22);
	}

}
