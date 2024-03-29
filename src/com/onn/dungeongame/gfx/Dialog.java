package com.onn.dungeongame.gfx;

import java.awt.*;
import java.util.LinkedList;

public class Dialog {

	private Font font;
	private Rectangle bounds;
	private String string;
	private int arcWidth;
	private int arcHeight;
	private int lineMarginLeft;
	private int lineMarginTop;
	private int lineMarginRight;
	private Color backgroundColor;
	private Color foregroundColor;
	private Color fontColor;

	public static final int DEFAULT_LINE_MARGIN_RIGHT = 128;
	public static final int DEFAULT_LINE_MARGIN_LEFT = 16;
	public static final int DEFAULT_LINE_MARGIN_TOP = 24;

	public Dialog(Font font, Rectangle bounds) {
		this.font = font;
		this.bounds = bounds;
		string = "";
		arcWidth = 32;
		arcHeight = 32;
		backgroundColor = Color.darkGray;
		fontColor = Color.white;
		lineMarginLeft = DEFAULT_LINE_MARGIN_LEFT;
		lineMarginTop = DEFAULT_LINE_MARGIN_TOP;
		lineMarginRight = DEFAULT_LINE_MARGIN_RIGHT;
	}

	public void tick() {
		// TODO: implement an animation for this class
	}

	public void render(Graphics g) {
		if(string.equals(""))
			return;

		LinkedList<String> lines = new LinkedList<>();
		String[] splitLines = string.split(" ");
		String tmp = "";

		int availableSpace = (int) bounds.getWidth();
		int currentSpace = 0;

		for(int i = 0; i < splitLines.length; i++) {
			int stringWidth = (int) Toolkit.getDefaultToolkit().getFontMetrics(font).getStringBounds(splitLines[i], g).getWidth();
			if(currentSpace + stringWidth + lineMarginRight > availableSpace) {
				lines.add(tmp);

				tmp = splitLines[i];

				if(i < splitLines.length - 1) {
					tmp += " ";
				} else {
					lines.add(tmp);
				}

				currentSpace = stringWidth + Toolkit.getDefaultToolkit().getFontMetrics(font).charWidth(' ');
			} else {
				tmp += splitLines[i];
				currentSpace += stringWidth;
				if(i < splitLines.length - 1) {
					tmp += " ";
				} else {
					lines.add(tmp);
				}
			}
		}

		g.setColor(backgroundColor);
		g.fillRoundRect((int) bounds.getX(), (int) bounds.getY(), (int) bounds.getWidth(), (int) bounds.getHeight(), arcWidth, arcHeight);
		g.setColor(foregroundColor);
		g.fillRoundRect((int) bounds.getX() + 8, (int) bounds.getY() + 8, (int) bounds.getWidth() - 16, (int) bounds.getHeight() - 16, arcWidth / 2, arcHeight / 2);

		for(int i = 0; i < lines.size(); i++) {
			Text.draw(g, lines.get(i), (int) bounds.getX() + lineMarginLeft, (int) bounds.getY() + (i * lineMarginTop + lineMarginTop), false, fontColor, font);
		}
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public int getArcWidth() {
		return arcWidth;
	}

	public void setArcWidth(int arcWidth) {
		this.arcWidth = arcWidth;
	}

	public int getArcHeight() {
		return arcHeight;
	}

	public void setArcHeight(int arcHeight) {
		this.arcHeight = arcHeight;
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public Color getFontColor() {
		return fontColor;
	}

	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
	}

	public int getLineMarginLeft() {
		return lineMarginLeft;
	}

	public void setLineMarginLeft(int lineMarginLeft) {
		this.lineMarginLeft = lineMarginLeft;
	}

	public int getLineMarginTop() {
		return lineMarginTop;
	}

	public void setLineMarginTop(int lineMarginTop) {
		this.lineMarginTop = lineMarginTop;
	}

	public int getLineMarginRight() {
		return lineMarginRight;
	}

	public void setLineMarginRight(int lineMarginRight) {
		this.lineMarginRight = lineMarginRight;
	}

	public Color getForegroundColor() {
		return foregroundColor;
	}

	public void setForegroundColor(Color foregroundColor) {
		this.foregroundColor = foregroundColor;
	}

}
