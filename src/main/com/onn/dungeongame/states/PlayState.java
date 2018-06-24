package com.onn.dungeongame.states;

import java.awt.*;

public class PlayState extends State {

	private World world;

	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

}
