package com.onn.dungeongame.entities;

import java.awt.*;
import java.awt.image.*;

public abstract class Entity {

	protected int x;
	protected int y;
	protected BufferedImage texture;
	protected Dimension size;

	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
		size = new Dimension(0, 0);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return size.width;
	}

	public int getHeight() {
		return size.height;
	}

	public abstract void tick();
	public abstract void render(Graphics g);

}
