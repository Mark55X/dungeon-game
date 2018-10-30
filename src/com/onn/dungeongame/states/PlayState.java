package com.onn.dungeongame.states;

import com.onn.dungeongame.Handler;
import com.onn.dungeongame.entities.creature.Player;
import com.onn.dungeongame.gfx.Assets;
import com.onn.dungeongame.gfx.DialogManager;
import com.onn.dungeongame.world.World;

import java.awt.*;

public class PlayState extends State {

	private World world;
	private Player player;

	public PlayState() {
		init();
	}

	public void init() {
		player = new Player(0, 0);
		Handler.setPlayer(player);

		world = new World();
		world.loadWorld("/home/taxy/worlds/w0m0l0");
		world.loadItemWorld("/home/taxy/worlds/w0m0l0t");
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
