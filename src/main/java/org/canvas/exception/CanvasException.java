package org.canvas.exception;

/**
 * This class act as a exception
 * @author suresh kumar
 *
 */
public class CanvasException extends RuntimeException {

	private static final long serialVersionUID = 8668512178060102845L;
	
	public CanvasException(String message) {
		super(message);
	}
}
