package com.onn.dungeongame.game;

import java.awt.*;
import java.awt.image.*;

import com.onn.dungeongame.*;
import com.onn.dungeongame.gfx.*;
import com.onn.dungeongame.world.*;
import com.onn.dungeongame.entities.creature.*;
import com.onn.dungeongame.input.*;
import com.onn.dungeongame.camera.*;
import com.onn.dungeongame.states.*;

public class Game implements Runnable {
	private String title;
	private int width;
	private int height;
	private Thread thread;
	private boolean isRunning;

	private Display display;
	private KeyInput keyInput;
	private MouseInput mouseInput;
	private Camera camera;

	public State playState;
	public State menuState;

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

		keyInput = new KeyInput();
		mouseInput = new MouseInput();
		camera = new Camera();

		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyInput);
		display.getFrame().addMouseListener(mouseInput);
		display.getFrame().addMouseMotionListener(mouseInput);
		display.getCanvas().addMouseListener(mouseInput);
		display.getCanvas().addMouseMotionListener(mouseInput);

		playState = new PlayState();
		menuState = new MenuState();
		State.setState(menuState);
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

		if(State.getState() != null) {
			State.getState().tick();
		}
	}

	private void render() {
		// Render all objects here
		BufferStrategy bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		if(State.getState() != null) {
			State.getState().render(g);
		}

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

	public MouseInput getMouseInput() {
		return mouseInput;
	}
}
