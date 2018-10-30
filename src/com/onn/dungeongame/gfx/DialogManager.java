package com.onn.dungeongame.gfx;

import com.onn.dungeongame.Handler;
import com.onn.dungeongame.input.KeyInput;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class DialogManager {

	private LinkedList<Dialog> dialogs;
	private int currentDialog;
	private Font font;
	private int fontHeight;
	private Rectangle bounds;
	private int marginTop;

	public DialogManager() {
		dialogs = new LinkedList<>();
		currentDialog = -2;
	}

	public void init(String text, Font font, int fontHeight, Rectangle bounds, int marginTop) {
		this.font = font;
		this.fontHeight = fontHeight;
		this.bounds = bounds;
		this.marginTop = marginTop;

		int availableRows = (int) (bounds.getHeight() / (fontHeight + marginTop));

		String tmp = "";
		String[] splitLines = text.split(" ");
		int availableSpace = (int) bounds.getWidth();
		int currentSpace = 0;
		int rows = 0;

		for(int i = 0; i < splitLines.length; i++) {
			int stringWidth = 0;
			for(int b = 0; b < splitLines[i].length(); b++) {
				stringWidth += Toolkit.getDefaultToolkit().getFontMetrics(font).charWidth(splitLines[i].charAt(b));
			}

			if(stringWidth + Dialog.DEFAULT_LINE_MARGIN_RIGHT + currentSpace > availableSpace) {
				rows++;

				if(rows == availableRows) {
					Dialog dialog = new Dialog(font, bounds);
					dialog.setString(tmp);
					dialog.setLineMarginTop(marginTop);
					dialogs.add(dialog);

					rows = 0;
					tmp = "";
					currentSpace = 0;
				}

				tmp += splitLines[i];
				if(i < splitLines.length - 1) {
					tmp += " ";
					currentSpace += Toolkit.getDefaultToolkit().getFontMetrics(font).charWidth(' ');
				} else {
					Dialog dialog = new Dialog(font, bounds);
					dialog.setString(tmp);
					dialog.setLineMarginTop(marginTop);
					dialogs.add(dialog);

					rows = 0;
					tmp = "";
					currentSpace = 0;
				}
				currentSpace += stringWidth;
			} else {
				tmp += splitLines[i];
				if(i < splitLines.length - 1) {
					tmp += " ";
				} else {
					Dialog dialog = new Dialog(font, bounds);
					dialog.setString(tmp);
					dialog.setLineMarginTop(marginTop);
					dialogs.add(dialog);

					rows = 0;
					tmp = "";
					currentSpace = 0;
				}
				currentSpace += stringWidth;
			}

			if(rows == availableRows) {
				Dialog dialog = new Dialog(font, bounds);
				dialog.setString(tmp);
				dialog.setLineMarginTop(marginTop);
				dialogs.add(dialog);
				tmp = "";
				currentSpace = 0;
				rows = 0;
			}
		}

		currentDialog = 0;
	}

	public void addDialog(Dialog dialog) {
		dialogs.add(dialog);
	}

	public void removeDialog(Dialog dialog) {
		dialogs.remove(dialog);
	}

	public void tick() {
		KeyInput keyInput = Handler.getKeyInput();

		if(currentDialog == -2)
			return;

		if(keyInput.keyJustPressed(KeyEvent.VK_E)) {
			currentDialog++;
		}

		if(currentDialog >= dialogs.size()) {
			currentDialog = -2;
		}
	}

	public void render(Graphics g) {
		if(currentDialog == -2)
			return;

		if(currentDialog < 0) {
			currentDialog = dialogs.size();
		} else if(currentDialog >= dialogs.size()) {
			currentDialog = -1;
		}

		dialogs.get(currentDialog).render(g);
	}

	public LinkedList<Dialog> getDialogs() {
		return dialogs;
	}

	public void setFont(Font font) {
		for(Dialog d : dialogs) {
			d.setFont(font);
		}
	}

	public void setString(String string) {
		init(string, font, fontHeight, bounds, marginTop);
	}

	public void setArcWidth(int arcWidth) {
		for(Dialog d : dialogs) {
			d.setArcWidth(arcWidth);
		}
	}

	public void setArcHeight(int arcHeight) {
		for(Dialog d : dialogs) {
			d.setArcHeight(arcHeight);
		}
	}

	public void setBackgroundColor(Color backgroundColor) {
		for(Dialog d : dialogs) {
			d.setBackgroundColor(backgroundColor);
		}
	}

	public void setForegroundColor(Color foregroundColor) {
		for(Dialog d : dialogs) {
			d.setForegroundColor(foregroundColor);
		}
	}

	public void setFontColor(Color fontColor) {
		for(Dialog d : dialogs) {
			d.setFontColor(fontColor);
		}
	}

}
