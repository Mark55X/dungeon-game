package com.onn.dungeongame.util;

import java.awt.*;
import java.awt.image.*;

public class Utils {

	public static BufferedImage rotateCw(BufferedImage img) {
		// Found this method at https://coderanch.com/t/485958/java/Rotating-buffered-image

		int width = img.getWidth();
		int height = img.getHeight();
		BufferedImage image = new BufferedImage(height, width, img.getType());
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				image.setRGB(height - 1 - j, i, img.getRGB(i, j));
			}
		}
		return image;
	}

}
