package com.onn.dungeongame;

import com.onn.dungeongame.game.*;
import com.onn.dungeongame.input.*;
import com.onn.dungeongame.camera.*;
import com.onn.dungeongame.world.*;
import com.onn.dungeongame.entities.creature.*;
import com.onn.dungeongame.states.*;

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
		return PlayState.world;
	}

	public static Player getPlayer() {
		return PlayState.player;
	}

	public static MouseInput getMouseInput() {
		return game.getMouseInput();
	}

	public static Game getGame() {
		return game;
	}

}
