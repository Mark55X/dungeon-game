package com.onn.dungeongame.states;

import java.awt.*;
import com.onn.dungeongame.world.*;
import com.onn.dungeongame.entities.creature.*;

public class PlayState extends State {

	public static World world;
	public static Player player;

	public PlayState() {
		init();
	}

	public static void init() {
		player = new Player(0, 0);
		world = new World();
		world.loadWorld(PlayState.class.getResource("/worlds/level_1"));
		world.getEntityManager().addEntity(player);
	}

	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

}
