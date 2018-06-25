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
		entities.add(new Log1(64, 294));
		entities.add(new Log1(100, 303));
		entities.add(new Log1(200, 303));
		entities.add(new Log1(300, 303));
		entities.add(new Log1(600, 303));
	}

	public void tick() {
		Iterator<Entity> it = entities.iterator();
		while(it.hasNext()) {
			Entity e = it.next();
			e.tick();
			if(!e.isActive()) {
				it.remove();
			}
		}
		entities.sort(renderSorter);
	}

	public void render(Graphics g) {
		for(int i = 0; i < entities.size(); i++) {
			entities.get(i).render(g);
		}
		Handler.getPlayer().postRender(g);
	}

	public void addEntity(Entity e) {
		entities.add(e);
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

}
