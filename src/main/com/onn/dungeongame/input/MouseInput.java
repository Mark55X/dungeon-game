package com.onn.dungeongame.input;

import java.awt.event.*;

public class MouseInput implements MouseListener, MouseMotionListener {

	private boolean left;
	private boolean right;

	private int x;
	private int y;

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			left = true;
		}

		if(e.getButton() == MouseEvent.BUTTON3) {
			right = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			left = false;
		}

		if(e.getButton() == MouseEvent.BUTTON3) {
			right = false;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean left() {
		return left;
	}

	public boolean right() {
		return right;
	}

}
