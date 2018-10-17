package com.onn.dungeongame.states;

import com.onn.dungeongame.Handler;
import com.onn.dungeongame.entities.creature.Player;
import com.onn.dungeongame.world.World;

import java.awt.*;

public class PlayState extends State {

	public World world;
	public Player player;

	public PlayState() {
		init();
	}

	public void init() {
		player = new Player(0, 0);
		Handler.setPlayer(player);

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
