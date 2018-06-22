package com.onn.dungeongame.game;

import com.onn.dungeongame.gfx.*;
import com.onn.dungeongame.world.*;

public class Game implements Runnable {
	private String title;
	private int width;
	private int height;
	private Display display;
	private Thread thread;
	private boolean isRunning;

	private World world;

	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;

		isRunning = false;
	}

	public void start() {
		if(!isRunning) {
			// Start the thread if the game is not running
			thread = new Thread(this, title);
			thread.start();
		}
	}

	private void init() {
		Assets.init();
		world = new World();
		world.loadWorld("/home/taxyd/worlds/level_1.txt");
		display = new Display(title, width, height);
	}

	@Override
	public void run() {
		init();

		// From now on this is the game loop
		long initTime = System.nanoTime(); // Gets the time in nanoseconds when the program started
		long now;
		double delta = 0; // Will be used to check if it is the right time to tick and render
		final int FPS = 30; // Defines FPS
		double time = 1000000000 / FPS; // Defines how many nanoseconds should there be before a tick and render
		long timer = System.currentTimeMillis(); // This will be used to output the fps every second
		int frames = 0; // Defines how many frames have there been in a second

		while(isRunning) {
			now = System.nanoTime();
			delta = (now - initTime) / time; // Get the time passed from now and initTime in nanoseconds and divide it by time to see if it is the right time to tick and render
			initTime = now; // Reset initTime 

			if(delta >= 1) {
				tick();
				render();
				frames++;
			}

			if(System.currentTimeMillis() - timer >= 1000) {
				System.out.println("FPS: " + frames);
				frames = 0;
				timer = System.currentTimeMillis(); // Reset timer
			}
		}
	}

	private void tick() {
		// Tick all objects here
	}

	private void render() {
		// Render all objects here
	}
}
