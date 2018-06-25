package com.onn.dungeongame.item;

import com.onn.dungeongame.*;
import java.awt.image.*;
import java.awt.*;
import com.onn.dungeongame.gfx.*;

public class Item {
	public static Item[] items = new Item[1];
	public static Item wood1Item = new Item(Assets.drop_log_1, "Wood", 0);

	public static final int ITEMWIDTH = 32;
	public static final int ITEMHEIGHT = 32;
	public static final int PICKED_UP = -1;

	protected BufferedImage texture;
	protected String name;
	protected final int id;

	protected int x;
	protected int y;
	protected int count;

	public Item(BufferedImage texture, String name, int id) {
		this.texture = texture;
		this.name = name;
		this.id = id;
		count = 1;
		items[id] = this;
	}

	public void tick() {

	}

	public void render(Graphics g) {
		render(g, (int) (x - Handler.getCamera().getX()), (int) (y - Handler.getCamera().getY()));
	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, ITEMWIDTH, ITEMHEIGHT, null);
	}

	public void setX(int a) {
		x = a;
	}

	public void setY(int a) {
		y = a;
	}

	public void setName(String a) {
		name = a;
	}

	public void setTexture(BufferedImage a) {
		texture = a;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public int getCount() {
		return count;
	}

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Item createNew(int x, int y) {
		Item i = new Item(texture, name, id);
		i.setPosition(x, y);
		return i;
	}
}
