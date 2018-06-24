package com.onn.dungeongame.states;

import java.awt.*;

public abstract class State {

	public static State state;

	public static void setState(State arg0) {
		state = arg0;
	}

	public static State getState() {
		return state;
	}

	public abstract void tick();
	public abstract void render(Graphics g);

}
