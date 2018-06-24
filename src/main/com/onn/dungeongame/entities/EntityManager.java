package com.onn.dungeongame.entities;

import com.onn.dungeongame.entities.creature.*;
import java.util.*;
import java.awt.geom.*;
import java.awt.*;
import com.onn.dungeongame.*;
import com.onn.dungeongame.entities.statics.*;

public class EntityManager {
	private Player player;
	private ArrayList<Entity> entities;
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {
		@Override
		public int compare(Entity a, Entity b) {
			if(a.getY() < b.getY()) {
				return -1;
			}

			return 1;
		}
	};

	protected Rectangle bounds;

	public EntityManager() {
		this.player = Handler.getPlayer();
		entities = new ArrayList<>();
		entities.add(player);
	}

	public void tick() {
		for(int i = 0; i < entities.size(); i++) {
			entities.get(i).tick();
		}
		entities.sort(renderSorter);
	}

	public void render(Graphics g) {
		for(int i = 0; i < entities.size(); i++) {
			entities.get(i).render(g);
		}
	}

	public void addEntity(Entity e) {
		entities.add(e);
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

}
