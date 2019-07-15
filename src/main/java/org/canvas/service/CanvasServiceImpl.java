package org.canvas.service;

import org.canvas.beans.Canvas;
import org.canvas.exception.CanvasException;
import org.springframework.stereotype.Service;

import static org.canvas.util.Constants.*;

/**
 * This class act as a service
 * @author suresh kumar
 *
 */
@Service
public class CanvasServiceImpl implements CanvasService {
	
	private static CanvasService canvasService = new CanvasServiceImpl();
	
	private CanvasServiceImpl() {
		// do nothing
	}
	
	public static CanvasService getServiceInstance() {
		return canvasService;
	}
	
	@Override
	public Canvas createCanvas(int width, int height) throws CanvasException {
		if(width < 1 || height < 1) {
			throw new CanvasException("Canvas width and height can't be 0");
		}
		width+=2;
		height+=2;
		Canvas canvas = new Canvas(width, height);
		drawLine(0, 0, canvas.getWidth()-1, 0, CANVAS_WIDTH_SYMBOL, canvas);
		drawLine(0, canvas.getHeight()-1, canvas.getWidth()-1, canvas.getHeight()-1, CANVAS_WIDTH_SYMBOL, canvas);
		drawLine(0, 1, 0, canvas.getHeight()-2, CANVAS_HEIGHT_SYMBOL, canvas);
		drawLine(canvas.getWidth()-1, 1, canvas.getWidth()-1, canvas.getHeight()-2, CANVAS_HEIGHT_SYMBOL, canvas);		
		return canvas;
	}

	@Override
	public void drawLine(int x1, int y1, int x2, int y2, char symbol, Canvas canvas) throws CanvasException {		
		for(int i=y1; i<=y2; i++) {
            for(int j=x1; j<=x2; j++) {
            	canvas.getCanvasArray()[i][j] = symbol;
            }
        }				
	}

	@Override
	public void drawRectangle(int x1, int y1, int x2, int y2, char symbol, Canvas canvas) throws CanvasException {		
		drawLine(x1,y1, x2, y1, symbol, canvas);
        drawLine(x1,y1, x1, y2, symbol, canvas);
        drawLine(x2,y1, x2, y2, symbol, canvas);
        drawLine(x1,y2, x2, y2, symbol, canvas);        
	}

	@Override
	public void bucketFill(int x, int y, char color, Canvas canvas) throws CanvasException {
		
		if((int)canvas.getCanvasArray()[y][x] != 0) {
            return;
        } else if(x > 0 || x < canvas.getHeight() || y > 0 || y  < canvas.getWidth()) {
            if((int)canvas.getCanvasArray()[y][x] == 0) {
            	canvas.getCanvasArray()[y][x] = color;
            }	
            bucketFill(x+1,y, color, canvas);
            bucketFill(x-1,y, color, canvas);
            bucketFill(x,y-1, color, canvas);
            bucketFill(x,y+1, color, canvas);
        }		
	}

	@Override
	public void print(Canvas canvas) throws CanvasException {
		StringBuilder strBuilder = new StringBuilder();
        for(int i=0;i<canvas.getHeight();i++) {
            for(int j=0;j<canvas.getWidth();j++) {
                strBuilder.append(canvas.getCanvasArray()[i][j] == '\u0000'?' ':canvas.getCanvasArray()[i][j]);
            }
            strBuilder.append("\n");
        }
        System.out.println(strBuilder.toString().trim());		
	}
	
}
