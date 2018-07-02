package com.onn.dungeongame.gfx;

import java.awt.*;

public class Text {

	public static void draw(Graphics g, String text, int x, int y, boolean center, Color c, Font font) {
		g.setColor(c);
		g.setFont(font);
		int tx = x;
		int ty = y;

		if(center) {
			FontMetrics fm = g.getFontMetrics(font);
			tx = x - fm.stringWidth(text) / 2;
			ty = (y - fm.getHeight() / 2) + fm.getAscent();
		}


		g.drawString(text, x, y);
	}

}
