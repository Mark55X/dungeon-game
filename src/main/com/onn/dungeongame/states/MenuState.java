package com.onn.dungeongame.states;

import java.awt.*;
import com.onn.dungeongame.*;

public class MenuState extends State {

	@Override
	public void tick() {
		if(Handler.getMouseInput().left()) {
			State.setState(Handler.getGame().playState);
		}
	}

	@Override
	public void render(Graphics g) {

	}

}
