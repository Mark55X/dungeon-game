package com.onn.dungeongame.entities;

import java.awt.*;
import java.awt.image.*;

public abstract class Entity {

	protected int x;
	protected int y;
	protected BufferedImage texture;

	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public abstract void tick();
	public abstract void render(Graphics g);

}
