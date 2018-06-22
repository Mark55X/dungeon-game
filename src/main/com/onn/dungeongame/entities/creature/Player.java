package com.onn.dungeongame.entities.creature;

import java.awt.*;
import com.onn.dungeongame.gfx.*;
import com.onn.dungeongame.animation.*;

public class Player extends Creature {

	private Animation up_walk_animation;
	private Animation down_walk_animation;
	private Animation left_walk_animation;
	private Animation right_walk_animation;

	public Player(int x, int y) {
		super(x, y);
		bounds.x = 13;
		bounds.y = 15;
		bounds.width = 8;
		bounds.height = 18;

		up_walk_animation = new Animation(Assets.player_blue_up, 150, true);
		down_walk_animation = new Animation(Assets.player_blue_down, 150, true);
		left_walk_animation = new Animation(Assets.player_blue_left, 150, true);
		right_walk_animation = new Animation(Assets.player_blue_right, 150, true);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(up_walk_animation.getImage(), x, y, size.width, size.height, null);
	}

	@Override
	public void tick() {
		up_walk_animation.tick();
	}

}
