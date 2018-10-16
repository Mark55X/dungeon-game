package com.onn.dungeongame.states;

import com.onn.dungeongame.Handler;
import com.onn.dungeongame.entities.creature.Player;
import com.onn.dungeongame.gfx.Assets;
import com.onn.dungeongame.gfx.DialogManager;
import com.onn.dungeongame.world.World;

import java.awt.*;

public class PlayState extends State {

	public World world;
	public Player player;
	public DialogManager dialogManager;

	public PlayState() {
		init();
	}

	public void init() {
		player = new Player(0, 0);
		Handler.setPlayer(player);

		world = new World();
		world.loadWorld(PlayState.class.getResource("/worlds/level_1"));
		world.getEntityManager().addEntity(player);

		int width = Handler.getGame().getWidth();
		int height = Handler.getGame().getHeight();
		int marginLeft = 32;
		int marginRight = 32;
		int rectWidth = width - marginLeft - marginRight;
		int rectHeight = (height * 20) / 100; // 20% of the height of the screen
		int marginBottom = 32;
		int marginTop = height - rectHeight - marginBottom;
		Rectangle dialogRect = new Rectangle(marginLeft, marginTop, rectWidth, rectHeight);
		dialogManager = new DialogManager();
		dialogManager.init("This is a very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very long line of text.", Assets.font14, 14, dialogRect, 22);
		dialogManager.setBackgroundColor(Color.decode("#44097a"));
		dialogManager.setForegroundColor(Color.decode("#551a8b"));
	}

	@Override
	public void tick() {
		world.tick();
		dialogManager.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		dialogManager.render(g);
	}

}
