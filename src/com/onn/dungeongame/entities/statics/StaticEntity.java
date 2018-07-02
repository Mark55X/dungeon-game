package com.onn.dungeongame.entities.statics;

import com.onn.dungeongame.entities.*;
import java.awt.*;

public abstract class StaticEntity extends Entity {

	public StaticEntity(int x, int y) {
		super(x, y);
		bounds = new Rectangle(0, 0, 32, 32);
	}

}
