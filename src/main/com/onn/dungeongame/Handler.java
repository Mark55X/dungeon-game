package com.onn.dungeongame;

import com.onn.dungeongame.game.*;
import com.onn.dungeongame.input.*;
import com.onn.dungeongame.camera.*;
import com.onn.dungeongame.world.*;
import com.onn.dungeongame.entities.creature.*;

public class Handler {

    private static Game game;

    public static void init(Game arg0) {
        game = arg0;
    }

    public static int getWidth() {
        return game.getWidth();
    }

    public static int getHeight() {
        return game.getHeight();
    }

	public static KeyInput getKeyInput() {
		return game.getKeyInput();
	}

	public static Camera getCamera() {
		return game.getCamera();
	}

	public static World getWorld() {
		return game.getWorld();
	}

	public static Player getPlayer() {
		return game.getPlayer();
	}

}
