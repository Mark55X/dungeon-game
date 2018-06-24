package com.onn.dungeongame.entities;

import com.onn.dungeongame.entities.creature.*;
import java.util.*;
import java.awt.geom.*;
import java.awt.*;
import com.onn.dungeongame.*;
import com.onn.dungeongame.entities.statics.*;

public class EntityManager {
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
		entities = new ArrayList<>();
		entities.add(new Log1(32, 300));
	}

	public void tick() {
		for(int i = 0; i < entities.size(); i++) {
			entities.get(i).tick();
			if(!entities.get(i).isActive()) {
				entities.remove(entities.get(i));
			}
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
