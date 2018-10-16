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
		/*FontRenderContext frc = ((Graphics2D) Handler.getGraphics()).getFontRenderContext();
		GlyphVector gv = Handler.getGraphics().getFont().createGlyphVector(frc, text);
		int fontHeight = (int) gv.getPixelBounds(null, 0, 0).getHeight();*/

		int availableRows = (int) (bounds.getHeight() / (fontHeight + marginTop));
		System.out.println("Available rows: " + availableRows);
		System.out.println("Bounds height: " + bounds.getHeight());
		System.out.println("Margin top: " + marginTop);

		String tmp = "";
		int availableSpace = (int) bounds.getWidth();
		int currentSpace = 0;
		int rows = 0;
		for(int i = 0; i < text.length(); i++) {
			if(text.charAt(i) == '\n' || text.charAt(i) == '\t') {
				if(i == text.length() - 1) {
					rows++;
				}

				if(rows == availableRows) {
					Dialog dialog = new Dialog(font, bounds);
					dialog.setString(tmp);
					dialog.setLineMarginTop(marginTop);
					dialogs.add(dialog);
					tmp = "";
					rows = 0;
				}
			}

			int charWidth = Toolkit.getDefaultToolkit().getFontMetrics(font).charWidth(text.charAt(i));
			if(currentSpace + charWidth + Dialog.DEFAULT_LINE_MARGIN_RIGHT > availableSpace) { // The DEFAULT_LINE_MARGIN_RIGHT is just to make sure that no character goes out of bounds since the space is not counted in the currentSpace
				rows++;

				if(rows == availableRows) {
					Dialog dialog = new Dialog(font, bounds);
					dialog.setString(tmp);
					dialog.setLineMarginTop(marginTop);
					dialogs.add(dialog);
					tmp = "";
					rows = 0;
				}

				tmp += text.charAt(i);
				currentSpace = charWidth;

				if(i == text.length() - 1) {
					tmp += text.charAt(i);
					rows++;
				}
			} else {
				currentSpace += charWidth;
				tmp += text.charAt(i);

				if(i == text.length() - 1) {
					rows++;
				}
			}

			if(rows == availableRows || i == text.length() - 1) {
				Dialog dialog = new Dialog(font, bounds);
				dialog.setString(tmp);
				dialog.setLineMarginTop(marginTop);
				dialogs.add(dialog);
				tmp = "";
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
