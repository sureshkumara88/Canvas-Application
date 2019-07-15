package org.canvas.controller;

import static org.canvas.service.CanvasServiceImpl.getServiceInstance;
import static org.canvas.util.Constants.BUCKET_FILL;
import static org.canvas.util.Constants.CREATE_CANVAS;
import static org.canvas.util.Constants.DRAW_LINE;
import static org.canvas.util.Constants.DRAW_RECTANGLE;
import static org.canvas.util.Constants.DRAW_SYMBOL;

import org.canvas.beans.Canvas;
import org.canvas.exception.CanvasException;
import org.springframework.stereotype.Controller;

/**
 * This class act as a controller
 * @author suresh kumar
 *
 */
@Controller
public class CanvasController {

	private Canvas canvas;
	
	public void draw(String command) throws CanvasException {
		String[] args = command.split(" ");

		String request = args[0];		

		try {
			if (request.equalsIgnoreCase(CREATE_CANVAS)) {
				if (args.length != 3) {
					throw new CanvasException("Create canvas must have width and height arguments");
				}
				int width = Integer.parseInt(args[1]);
				int height = Integer.parseInt(args[2]);
				setCanvas(getServiceInstance().createCanvas(width, height));
				getServiceInstance().print(getCanvas());
			} else if (request.equalsIgnoreCase(DRAW_LINE)) {
				isCanvasCreated();
				if (args.length != 5) {
					throw new CanvasException("Draw line must have x1, y1, x2 and y2 arguments");
				}
				int x1 = Integer.parseInt(args[1]);
				int y1 = Integer.parseInt(args[2]);
				int x2 = Integer.parseInt(args[3]);
				int y2 = Integer.parseInt(args[4]);
				getServiceInstance().drawLine(x1, y1, x2, y2, DRAW_SYMBOL, getCanvas());
				getServiceInstance().print(getCanvas());			
			} else if (request.equalsIgnoreCase(DRAW_RECTANGLE)) {
				isCanvasCreated();
				if (args.length != 5) {
					throw new CanvasException("Draw rectangle must have x1, y1, x2 and y2 arguments");
				}
				int x1 = Integer.parseInt(args[1]);
				int y1 = Integer.parseInt(args[2]);
				int x2 = Integer.parseInt(args[3]);
				int y2 = Integer.parseInt(args[4]);
				getServiceInstance().drawRectangle(x1, y1, x2, y2, DRAW_SYMBOL, getCanvas());
				getServiceInstance().print(getCanvas());
			} else if (request.equalsIgnoreCase(BUCKET_FILL)) {
				isCanvasCreated();
				if (args.length != 4) {
					throw new CanvasException("Bucket fill must have x, y and color arguments");
				}
				int x = Integer.parseInt(args[1]);
				int y = Integer.parseInt(args[2]);
				char color = args[3].charAt(0);
				getServiceInstance().bucketFill(x, y, color, getCanvas());
				getServiceInstance().print(getCanvas());
			} else {
				throw new CanvasException("Invalid Command, please try again");
			}	
		} catch (ArrayIndexOutOfBoundsException ex) {
			throw new CanvasException("Invalid Command, please try again");
		} catch (Exception ex) {
			throw new CanvasException("Invalid Command, please try again");
		}

	}

	private void isCanvasCreated() throws CanvasException {
		if (canvas == null) {
			throw new CanvasException("Canvas is not yet created!");
		}
	}
	
	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

}
