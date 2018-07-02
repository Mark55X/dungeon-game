package com.onn.dungeongame.animation;

import java.awt.image.*;

public class Animation {

	private int speed;
	private BufferedImage[] images;
	private int currentIndex;
	private long timer;
	private boolean reverse;
	private int direction = 0;
	/*
	 * direction will specify wether the animation is being reversed or not
	 */

	public Animation(BufferedImage[] images, int speed, boolean reverse) {
		this.images = images;
		this.speed = speed;
		currentIndex = 0;
		timer = System.currentTimeMillis();
		this.reverse = reverse;
	}

	public void reset() {
		currentIndex = 0;
	}

	public void tick() {
		if(System.currentTimeMillis() - timer >= speed) {
			timer = System.currentTimeMillis();

			if(reverse) {
				if(direction == 0) {
					currentIndex--;

					if(currentIndex < 0) {
						currentIndex = 0;
						direction = 1;
					}
				} else {
					currentIndex++;

					if(currentIndex >= images.length) {
						currentIndex = images.length - 1;
						direction = 0;
					}
				}
			} else {
				currentIndex++;

				if(currentIndex >= images.length) {
					currentIndex = 0;
				}
			}
		}
	}

	public BufferedImage getImage() {
		return images[currentIndex];
	}

	public void changeSpeed(int speed) {
		this.speed = speed;
	}

}
