package com.onn.dungeongame.entities.creature;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import com.onn.dungeongame.entities.*;

public abstract class Creature extends Entity {

	protected int speed;
	protected int yMove;
	protected int xMove;

	private static final int DEFAULT_SPEED = 3;
	private static final int DEFAULT_WIDTH = 32;
	private static final int DEFAULT_HEIGHT = 32;
	/*
	 * Bounds will be the area of the creature that will be checked for collision
	 * Since the player textures are not perfect, that means that there are white spaces
	 * on the image. Bounds will define the spaces that need to be checked for collision,
	 * for example, the chest and legs
	 */

	public Creature(int x, int y) {
		super(x, y);
		size = new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		speed = DEFAULT_SPEED;

		bounds = new Rectangle();
		// Set default bounds
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = size.width;
		bounds.height = size.height;
	}

	protected void setSpeed(int speed) {
		this.speed = speed;
	}

	public abstract void tick();
	public abstract void render(Graphics g);

}
