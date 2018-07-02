package com.onn.dungeongame.gfx;

import java.awt.*;
import java.io.*;
import java.net.*;

public class FontLoader {

	public static Font loadFont(String path, float size) {
		try {
			return Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(Font.PLAIN, size);
		} catch(FontFormatException|IOException ex) {
			ex.printStackTrace();
			System.exit(1);
		}
		return null;
	}

	public static Font loadFont(URL path, float size) {
		try {
			return Font.createFont(Font.TRUETYPE_FONT, path.openStream()).deriveFont(Font.PLAIN, size);
		} catch(FontFormatException|IOException ex) {
			ex.printStackTrace();
			System.exit(1);
		}
		return null;
	}

}
