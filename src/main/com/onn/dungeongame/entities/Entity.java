package com.onn.dungeongame.entities;

import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.util.*;
import com.onn.dungeongame.*;

public abstract class Entity {

	protected int health;
	protected int deffense;
	protected int attack;

	protected int attackCooldown;
	protected long lastAttackTimer;

	protected static final int DEFAULT_HEALTH = 100;
	protected static final int DEFAULT_DEFFENSE = 3;
	protected static final int DEFAULT_ATTACK = 20;
	protected static final int DEFAULT_ATTACK_COOLDOWN = 300;

	protected int x;
	protected int y;
	protected BufferedImage texture;
	protected Dimension size;
	protected boolean active = true;
	protected Rectangle bounds; // Collision bounds

	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
		size = new Dimension(0, 0);
		bounds = new Rectangle(0, 0, size.width, size.height);
		health = DEFAULT_HEALTH;
		deffense = DEFAULT_DEFFENSE;
		attack = DEFAULT_ATTACK;

		attackCooldown = DEFAULT_ATTACK_COOLDOWN;
		lastAttackTimer = DEFAULT_ATTACK_COOLDOWN;
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

	public int getHealth() {
		return health;
	}

	public int getAttack() {
		return attack;
	}

	public int getDeffense() {
		return deffense;
	}

	public void setHealth(int a) {
		health = a;
	}

	public void setAttack(int a) {
		attack = a;
	}

	public void setDeffense(int a) {
		attack = a;
	}

	public abstract void die();

	public void hurt(int a) {
		health -= new Random().nextInt(a);

		if(health <= 0) {
			active = false;
			die();
		}
	}

	public boolean isActive() {
		return active;
	}

}
