package org.canvas.main;

import static org.canvas.util.Constants.QUIT;

import java.util.Scanner;

import org.canvas.controller.CanvasController;
import org.canvas.exception.CanvasException;

/**
 * This class act as a main
 * @author suresh kumar
 *
 */
public class CanvasApp {

	public static void main(String[] args) {
		String command = new String();
		Scanner scan = new Scanner(System.in);
		CanvasController controller = new CanvasController();

		System.out.print("Enter command:");

		while(scan.hasNextLine()) {
			command = scan.nextLine();
			if (command.equalsIgnoreCase(QUIT)) {
				break;
			}
			try {
				controller.draw(command);
			} catch (CanvasException ex) {
				System.out.println(ex.getMessage());
			}
			System.out.print("Enter command:");		            
		}			


		scan.close();

	}

}
