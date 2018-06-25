package com.onn.dungeongame.input;

import java.awt.event.*;

public class KeyInput implements KeyListener {

	private boolean[] keys;
	private boolean[] justPressed;
	private boolean[] cantPress;

	public boolean up;
	public boolean down;
	public boolean left;
	public boolean right;
	public boolean attack;

	public KeyInput() {
		keys = new boolean[300];
		justPressed = new boolean[keys.length];
		cantPress = new boolean[keys.length];
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length) {
			return;
		}
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length) {
			return;
		}
		keys[e.getKeyCode()] = false;
	}

	public boolean keyJustPressed(int keyCode) {
		if(keyCode < 0 || keyCode >= keys.length) {
			return false;
		}
		return justPressed[keyCode];
	}

	public void tick() {
		for(int i = 0; i < keys.length; i++) {
			if(cantPress[i] && !keys[i]) {
				cantPress[i] = false;
			} else if(justPressed[i]) {
				cantPress[i] = true;
				justPressed[i] = false;
			}

			if(!cantPress[i] && keys[i]) {
				justPressed[i] = true;
			}
		}

		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		attack = keys[KeyEvent.VK_ENTER];
	}

}
