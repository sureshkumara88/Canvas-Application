package org.canvas.service;

import org.canvas.beans.Canvas;
import org.springframework.stereotype.Service;

@Service
public interface CanvasService {

	public Canvas createCanvas(int width, int height);
	
	public void drawLine(int x1, int y1, int x2, int y2, char symbol, Canvas canvas);
	
	public void drawRectangle(int x1, int y1, int x2, int y2, char symbol, Canvas canvas);
	
	public void bucketFill(int x, int y, char color, Canvas canvas);

	public void print(Canvas canvas);
}
