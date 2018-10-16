package com.onn.dungeongame;

import com.onn.dungeongame.camera.Camera;
import com.onn.dungeongame.entities.creature.Player;
import com.onn.dungeongame.game.Game;
import com.onn.dungeongame.input.KeyInput;
import com.onn.dungeongame.input.MouseInput;
import com.onn.dungeongame.world.World;

import java.awt.*;

public class Handler {

    private static Game game;
    private static World world;
    private static Player player;
    private static Graphics graphics;

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
		return world;
	}

	public static Player getPlayer() {
		return player;
	}

	public static MouseInput getMouseInput() {
		return game.getMouseInput();
	}

	public static Game getGame() {
		return game;
	}

	public static void setWorld(World world) {
		Handler.world = world;
	}

	public static void setPlayer(Player player) {
		Handler.player = player;
	}

	public static Graphics getGraphics() {
		return graphics;
	}

	public static void setGraphics(Graphics graphics) {
		Handler.graphics = graphics;
	}

}
