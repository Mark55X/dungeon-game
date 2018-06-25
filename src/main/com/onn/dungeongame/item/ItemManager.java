package com.onn.dungeongame.item;

import java.util.*;
import com.onn.dungeongame.*;
import java.awt.*;

public class ItemManager {

	private ArrayList<Item> items;

	public ItemManager() {
		items = new ArrayList<>();
	}

	public void tick() {
		Iterator<Item> it = items.iterator();
		while(it.hasNext()) {
			Item i = it.next();
			i.tick();
			if(i.getCount() == Item.PICKED_UP) {
				it.remove();
			}
		}
	}

	public void render(Graphics g) {
		for(int i = 0; i < items.size(); i++) {
			items.get(i).render(g);
		}
	}

	public void addItem(Item i) {
		items.add(i);
	}

}
