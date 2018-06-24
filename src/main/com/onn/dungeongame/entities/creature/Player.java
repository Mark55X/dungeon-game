package com.onn.dungeongame.entities.creature;

import java.awt.*;
import java.awt.image.*;
import com.onn.dungeongame.gfx.*;
import com.onn.dungeongame.animation.*;
import com.onn.dungeongame.input.*;
import com.onn.dungeongame.tiles.*;
import com.onn.dungeongame.*;

public class Player extends Creature {

	private Animation up_walk_animation;
	private Animation down_walk_animation;
	private Animation left_walk_animation;
	private Animation right_walk_animation;
	private int lastMove = 3;
	/*
	 * lastMove will be used to determine which texture to render
	 * once the player has stopped move and is idle
	 *
	 * 0 -> up
	 * 1 -> down
	 * 2 -> left
	 * 3 -> right
	 */

	private BufferedImage texture;

	public Player(int x, int y) {
		super(x, y);
		bounds.x = 13;
		bounds.y = 15;
		bounds.width = 8;
		bounds.height = 18;
		setSpeed(6);

		up_walk_animation = new Animation(Assets.player_blue_up, 50, true);
		down_walk_animation = new Animation(Assets.player_blue_down, 50, true);
		left_walk_animation = new Animation(Assets.player_blue_left, 50, true);
		right_walk_animation = new Animation(Assets.player_blue_right, 50, true);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(texture, (int) (x - Handler.getCamera().getX()), (int) (y - Handler.getCamera().getY()), size.width, size.height, null);
	}

	@Override
	public void tick() {
		xMove = 0;
		yMove = 0;
		switch(lastMove) {
		case 0:
			texture = Assets.player_blue_up[1];
			break;
		case 1:
			texture = Assets.player_blue_down[1];
			break;
		case 2:
			texture = Assets.player_blue_left[1];
			break;
		case 3:
			texture = Assets.player_blue_right[1];
			break;
		default:
			System.out.println("[E] Invalid use of lastMove in class Player");
			System.exit(1);
		}

		KeyInput input = Handler.getKeyInput();

		if(input.up) {
			up_walk_animation.tick();
			texture = up_walk_animation.getImage();
			lastMove = 0;
			yMove = -speed;
		}

		if(input.down) {
			down_walk_animation.tick();
			texture = down_walk_animation.getImage();
			lastMove = 1;
			yMove = speed;
		}

		if(input.left) {
			left_walk_animation.tick();
			texture = left_walk_animation.getImage();
			lastMove = 2;
			xMove = -speed;
		}

		if(input.right) {
			right_walk_animation.tick();
			texture = right_walk_animation.getImage();
			lastMove = 3;
			xMove = speed;
		}

		if(!collides(xMove, 0f)) {
			moveX();
		}

		if(!collides(0f, yMove)) {
			moveY();
		}

		Handler.getCamera().center(this);
	}

	private void moveX() {
		if(xMove < 0) {
			// Going onto the left, check collision on left

			// Calculate where the player is going
			int tx = (int) ((x + bounds.x + xMove) / Tile.TILEWIDTH);
			int ty = (int) ((y + bounds.y) / Tile.TILEHEIGHT); // Upper left corner
			int ty1 = (int) ((y + bounds.y + bounds.height) / Tile.TILEHEIGHT); // Bottom left corner

			if(tx < 0 || tx >= Handler.getWorld().getWidth() || ty < 0 || ty >= Handler.getWorld().getHeight()) {
				return;
			}

			if(!Handler.getWorld().getTile(tx, ty).isSolid() && !Handler.getWorld().getTile(tx, ty1).isSolid()) {
				x += xMove;
			}

		} else {
			// Going onto the right, check collision on right

			int tx = (int) ((x + bounds.x + bounds.width + xMove) / Tile.TILEWIDTH);
			int ty = (int) ((y + bounds.y) / Tile.TILEWIDTH); // Upper right corner
			int ty1 = (int) ((y + bounds.y + bounds.height) / Tile.TILEHEIGHT); // Bottom right corner

			if(tx < 0 || tx >= Handler.getWorld().getWidth() || ty < 0 || ty >= Handler.getWorld().getHeight()) {
				return;
			}

			if(!Handler.getWorld().getTile(tx, ty).isSolid() && !Handler.getWorld().getTile(tx, ty1).isSolid()) {
				x += xMove;
			}
		}
	}

	private void moveY() {
		if(yMove < 0) {
			// Calculate where the player is going
			int tx = (int) ((x + bounds.x) / Tile.TILEWIDTH);
			int tx1 = (int) ((x + bounds.x + bounds.width) / Tile.TILEWIDTH);
			int ty = (int) ((y + bounds.y + yMove) / Tile.TILEHEIGHT);

			if(tx < 0 || tx >= Handler.getWorld().getWidth() || ty < 0 || ty >= Handler.getWorld().getHeight()) {
				return;
			}

			if(!Handler.getWorld().getTile(tx, ty).isSolid() && !Handler.getWorld().getTile(tx1, ty).isSolid()) {
				y += yMove;
			}

		} else {
			int tx = (int) ((x + bounds.x + bounds.width) / Tile.TILEWIDTH);
			int tx1 = (int) ((x + bounds.x + bounds.width) / Tile.TILEWIDTH);
			int ty = (int) ((y + bounds.y + yMove + bounds.height) / Tile.TILEHEIGHT);

			if(tx < 0 || tx >= Handler.getWorld().getWidth() || ty < 0 || ty >= Handler.getWorld().getHeight()) {
				return;
			}

			if(!Handler.getWorld().getTile(tx, ty).isSolid() && !Handler.getWorld().getTile(tx1, ty).isSolid()) {
				y += yMove;
			}
		}
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

}
