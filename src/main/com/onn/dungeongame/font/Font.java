package com.onn.dungeongame.font;

import java.awt.image.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;

public class Font {

	private BufferedImage[] characters;
	private BufferedImage sprite;
	private int charCount;
	private int charWidth;
	private int charHeight;

	public Font(String path) {
		charCount = 0;
		charWidth = 0;
		charHeight = 0;
		loadFont(path);
		load();
	}

	public Font(URL path) {
		charCount = 0;
		charWidth = 0;
		charHeight = 0;
		loadFont(path);
		load();
	}

	public Font() {
		charCount = 0;
		charWidth = 0;
		charHeight = 0;
	}

	public void setWidth(int a) {
		charWidth = a;
	}

	public void setHeight(int a) {
		charHeight = a;
	}

	public void loadFont(String path) {
		try {
			sprite = ImageIO.read(Font.class.getResource(path));
		} catch(IOException ex) {
			System.out.println("Failed to load \'" + path + "\': " + ex.getMessage());
			System.exit(1);
		}
	}

	public void loadFont(URL path) {
		try {
			sprite = ImageIO.read(path);
		} catch(IOException ex) {
			System.out.println("Failed to load \'" + path + "\': " + ex.getMessage());
			System.exit(1);
		}
	}

	public void setCharCount(int charCount) {
		this.charCount = charCount;
	}

	public void load() {
		int x = 0;
		int y = 0;
		int cols = sprite.getWidth() / charWidth;
		int rows = sprite.getHeight() / charHeight;
		characters = new BufferedImage[charCount];
		int c = 0;

		for(int i = 0; i < charCount; i++) {
			characters[i] = sprite.getSubimage(x * charWidth, y * charHeight, charWidth, charHeight);
			c++;

			x++;

			if(x == rows) {
				x = 0;
				y++;
			}

			if(y == cols) {
				break;
			}
		}
	}

	public void write(String what, Graphics g, int x, int y, int xo, int yo, int width, int height) {
		for(int i = 0; i < what.length(); i++) {
			char c = what.charAt(i);
			int value = what.charAt(i) - 32;

			if(c != ' ') {
				g.drawImage(characters[value], x, y, width, height, null);
			}
			x += xo;
		}
	}

}
