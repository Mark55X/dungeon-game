package com.onn.dungeongame.states;

import java.awt.*;

public abstract State {

	public static State state;

	public static void setState(State state) {
		this.state = state;
	}

	public static State getState() {
		return state;
	}

	public abstract void tick();
	public abstract void render(Graphics g);

}
