package org.canvas.beans;

import org.springframework.stereotype.Component;

/**
 * This class is act as BO
 * @author suresh kumar
 *
 */
@Component
public class Canvas {

	private int width;
	
	private int height;

	private char[][] canvasArray;
	
	public Canvas(int width, int height) {		
		this.width = width;
		this.height = height;
		this.canvasArray = new char[height][width];
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public char[][] getCanvasArray() {
		return canvasArray;
	}
	
}
