package com.onn.dungeongame.game;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Display {
	private String title;
	private int width;
	private int height;
	private JFrame frame;
	private Canvas canvas;

	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;

		init();
	}

	private void init() {
		frame = new JFrame(title);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(width, height));

		canvas = new Canvas();
		canvas.setFocusable(false);
		canvas.setSize(new Dimension(width, height));

		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public JFrame getFrame() {
		return frame;
	}
}
