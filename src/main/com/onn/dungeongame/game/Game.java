package com.onn.dungeongame.game;

import java.awt.*;
import java.awt.image.*;

import com.onn.dungeongame.*;
import com.onn.dungeongame.gfx.*;
import com.onn.dungeongame.world.*;
import com.onn.dungeongame.entities.creature.*;
import com.onn.dungeongame.input.*;
import com.onn.dungeongame.camera.*;

public class Game implements Runnable {
	private String title;
	private int width;
	private int height;
	private Thread thread;
	private boolean isRunning;

	private World world;
	private Player player;
	private Display display;
	private KeyInput keyInput;
	private Camera camera;

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
			isRunning = true;
			thread.start();
		}
	}

	private void init() {
		Assets.init();
		Handler.init(this);
		world = new World();
		player = new Player(0, 0);
		world.loadWorld(getClass().getResource("/worlds/level_1"));
		display = new Display(title, width, height);
		keyInput = new KeyInput();
		camera = new Camera();
		display.getFrame().addKeyListener(keyInput);
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
		int lastFPS = -1;

		while(isRunning) {
			now = System.nanoTime();
			delta += (now - initTime) / time; // Get the time passed from now and initTime in nanoseconds and divide it by time to see if it is the right time to tick and render
			initTime = now; // Reset initTime

			if(delta >= 1) {
				tick();
				render();
				frames++;
				delta--;
			}

			if(System.currentTimeMillis() - timer >= 1000) {
				if(lastFPS != frames) {
					// Prints out the FPS only if it is a new one
					// For instance, if the previous second the fps was 30 and in this second it is 30 too, it will not print
					System.out.println(frames + " fps");
					lastFPS = frames;
				}
				frames = 0;
				timer = System.currentTimeMillis(); // Reset timer
			}
		}
	}

	private void tick() {
		// Tick all objects here
		keyInput.tick();
		world.tick();
		player.tick();
	}

	private void render() {
		// Render all objects here
		BufferStrategy bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		world.render(g);
		player.render(g);

		bs.show();
		g.dispose();
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public KeyInput getKeyInput() {
		return keyInput;
	}

	public Camera getCamera() {
		return camera;
	}

	public World getWorld() {
		return world;
	}
}
