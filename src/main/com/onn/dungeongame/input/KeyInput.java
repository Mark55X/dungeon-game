package com.onn.dungeongame.input;

import java.awt.event.*;

public class KeyInput implements KeyListener {

	private boolean[] keys = new boolean[300];

	public boolean up;
	public boolean down;
	public boolean left;
	public boolean right;
	public boolean attack;

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	public void tick() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		attack = keys[KeyEvent.VK_ENTER];
	}

}
