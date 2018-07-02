package com.onn.dungeongame;

import com.onn.dungeongame.game.*;

public class Launcher {

	public static final String TITLE = "Dungeon game";
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	public static void main(String[] args) {
		Game game = new Game(TITLE, WIDTH, HEIGHT);
		game.start();
	}
}
