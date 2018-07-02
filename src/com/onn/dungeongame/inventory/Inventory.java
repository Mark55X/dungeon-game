package com.onn.dungeongame.inventory;

import java.awt.*;
import java.awt.event.*;
import com.onn.dungeongame.*;
import java.util.*;
import com.onn.dungeongame.item.*;
import com.onn.dungeongame.gfx.*;

public class Inventory {

	private boolean active;
	private ArrayList<Item> items;

	private int displayInvSpacing = 30;
	private int displayItemImageRightMargin = 70;
	private int displayItemImageTopMargin = 30;

	private int displayItemImageX = Handler.getWidth() - Item.ITEMWIDTH - displayItemImageRightMargin;
	private int displayItemImageY = displayItemImageTopMargin;
	private int displayItemImageWidth = Item.ITEMWIDTH + 32;
	private int displayItemImageHeight = Item.ITEMHEIGHT + 32;
	private int selectedItem = 0;

	private int countX = displayItemImageX + displayItemImageWidth / 2;
	private int countY = displayItemImageY + 30 + displayItemImageHeight;

	private int invListXMargin = 10;
	//private int invListCenterY = (Handler.getHeight() - 28) / 2; // 28 is the font height
	private int invListCenterX = invListXMargin;

	public Inventory() {
		active = false;
		items = new ArrayList<>();
	}

	public void tick() {
		if(Handler.getKeyInput().keyJustPressed(KeyEvent.VK_I)) {
			active = !active;
		}

		if(!active) {
			return;
		}

		if(Handler.getKeyInput().keyJustPressed(KeyEvent.VK_UP)) {
			selectedItem--;
		}

		if(Handler.getKeyInput().keyJustPressed(KeyEvent.VK_DOWN)) {
			selectedItem++;
		}

		if(selectedItem < 0) {
			selectedItem = items.size() - 1;
		} else if(selectedItem >= items.size()) {
			selectedItem = 0;
		}
	}

	public void render(Graphics g) {
		if(!active) {
			return;
		}

		//g.drawImage(Assets.inventory_background, x, y, width, height, null);
		int len = items.size();
		if(len == 0) {
			return;
		}

		for(int i = 0; i < 6; i++) {
			if(selectedItem + i < 0 || selectedItem + i >= len) {
				continue;
			}

			if(i == 0) {
				Text.draw(g, "> " + items.get(selectedItem + i).getName() + " x" + String.valueOf(items.get(selectedItem + i).getCount()), invListCenterX, i * displayInvSpacing + 28, false, Color.ORANGE, Assets.font28); // 28 is font height
			} else {
				Text.draw(g, items.get(selectedItem + i).getName() + " x" + String.valueOf(items.get(selectedItem + i).getCount()), invListCenterX, i * displayInvSpacing + 28, false, Color.WHITE, Assets.font28); // 28 is font height
			}
		}

		Item i = items.get(selectedItem);
		g.drawImage(i.getTexture(), displayItemImageX, displayItemImageY, displayItemImageWidth, displayItemImageHeight, null);
	}

	public void add(Item a) {
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).getId() == a.getId()) {
				items.get(i).setCount(items.get(i).getCount() + a.getCount());
				return;
			}
		}
		items.add(a);
	}

	public void remove(Item a) {

	}

}
