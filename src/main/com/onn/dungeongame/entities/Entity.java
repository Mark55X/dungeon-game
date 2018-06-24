package com.onn.dungeongame.entities;

import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import com.onn.dungeongame.*;

public abstract class Entity {

	protected int x;
	protected int y;
	protected BufferedImage texture;
	protected Dimension size;
	protected Rectangle bounds; // Collision bounds

	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
		size = new Dimension(0, 0);
		bounds = new Rectangle(0, 0, size.width, size.height);
	}

	protected void setWidth(int a) {
		size.width = a;
	}

	protected void setHeight(int a) {
		size.height = a;
	}

	protected void noBounds() {
		bounds.x = 0;
		bounds.y = 0;
		bounds.height = 0;
		bounds.width = 0;
	}

	protected void setBounds(int x, int y, int width, int height) {
		bounds.x = x;
		bounds.y = y;
		bounds.width = width;
		bounds.height = height;
	}

	protected void setDimension(int width, int height) {
		size.width = width;
		size.height = height;
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

	public boolean collides(float x, float y) {
		for(Entity e : Handler.getWorld().getEntityManager().getEntities()) {
			if(e.equals(this)) {
				continue;
			}

			if(e.getBounds(0, 0).intersects(getBounds(x, y))) {
				return true;
			}
		}
		return false;
	}

	public Rectangle getBounds(float x, float y) {
		return new Rectangle((int) (this.x + bounds.x + x), (int) (this.y + bounds.y + y), bounds.width, bounds.height);
	}

}
