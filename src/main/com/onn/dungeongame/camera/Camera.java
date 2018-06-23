package com.onn.dungeongame.camera;

import com.onn.dungeongame.*;
import com.onn.dungeongame.entities.*;

public class Camera {

	private float x;
	private float y;

	public Camera() {
		x = 0;
		y = 0;
	}

	public void move(float x, float y) {
		this.x += x;
		this.y += y;
	}

	public void change(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public void center(Entity e) {
		x = e.getX() - Handler.getWidth() / 2 - e.getWidth() / 2;
		y = e.getY() - Handler.getHeight() / 2 - e.getHeight() / 2;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

}
