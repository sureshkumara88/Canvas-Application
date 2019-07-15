package org.canvas.main;

import org.canvas.controller.CanvasController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CanvasAppTest {
	
	@Test
	public void createCanvasTest1() {
		CanvasController controller = new CanvasController();
		controller.draw("C 20 4");			
	}
	
	@Test(expected = org.canvas.exception.CanvasException.class)
	public void createCanvasTest2() {
		CanvasController controller = new CanvasController();
		controller.draw("A 20 4");			
	}
	
	@Test(expected = org.canvas.exception.CanvasException.class)
	public void createCanvasTest3() {
		CanvasController controller = new CanvasController();
		controller.draw("C 20 4 5");			
	}
	
	@Test(expected = org.canvas.exception.CanvasException.class)
	public void createCanvasTest4() {
		CanvasController controller = new CanvasController();
		controller.draw("C 20 -1");			
	}
		
	@Test
	public void createCanvasTest5() {
		CanvasController controller = new CanvasController();
		controller.draw("c 20 4");			
	}
	
	@Test(expected = org.canvas.exception.CanvasException.class)
	public void createCanvasTest7() {
		CanvasController controller = new CanvasController();
		controller.draw("C A 4");			
	}
	
	@Test
	public void drawLineTest1() {
		CanvasController controller = new CanvasController();
		controller.draw("C 20 4");	
		controller.draw("L 1 2 6 2");
	}
		
	@Test(expected = org.canvas.exception.CanvasException.class)
	public void drawLineTest2() {
		CanvasController controller = new CanvasController();
		controller.draw("C 20 4");	
		controller.draw("L 1 2 6");
	}
	
	@Test
	public void drawLineTest3() {
		CanvasController controller = new CanvasController();
		controller.draw("C 20 4");	
		controller.draw("l 1 2 6 2");
	}
	
	@Test(expected = org.canvas.exception.CanvasException.class)
	public void drawLineTest4() {
		CanvasController controller = new CanvasController();
		controller.draw("C 20 4");	
		controller.draw("L 10 20 30 40");
	}
	
	@Test(expected = org.canvas.exception.CanvasException.class)
	public void drawLineTest5() {
		CanvasController controller = new CanvasController();
		controller.draw("L 1 2 6 2");
	}
	
	@Test
	public void drawRectangleTest1() {
		CanvasController controller = new CanvasController();
		controller.draw("C 20 4");
		controller.draw("R 14 1 18 3");			
	}	
	
	@Test(expected = org.canvas.exception.CanvasException.class)
	public void drawRectangleTest2() {
		CanvasController controller = new CanvasController();
		controller.draw("C 20 4");
		controller.draw("R 14 1 18");			
	}
	
	@Test
	public void drawRectangleTest3() {
		CanvasController controller = new CanvasController();
		controller.draw("c 20 4");
		controller.draw("r 14 1 18 3");			
	}
	
	@Test(expected = org.canvas.exception.CanvasException.class)
	public void drawRectangleTest4() {
		CanvasController controller = new CanvasController();
		controller.draw("R 14 1 18 3");			
	}
	
	@Test
	public void bucketFillTest1() {
		CanvasController controller = new CanvasController();
		controller.draw("C 20 4");			
		controller.draw("B 10 3 o");	
	}
	
	@Test(expected = org.canvas.exception.CanvasException.class)
	public void bucketFillTest2() {
		CanvasController controller = new CanvasController();
		controller.draw("C 20 4");			
		controller.draw("a 10 3 o d");	
	}
		
	@Test
	public void bucketFillTest3() {
		CanvasController controller = new CanvasController();
		controller.draw("C 20 4");			
		controller.draw("b 10 3 o");	
	}
		
	@Test(expected = org.canvas.exception.CanvasException.class)
	public void bucketFillTest4() {
		CanvasController controller = new CanvasController();
		controller.draw("C 20 4");			
		controller.draw("B 1 2 o c");	
	}
	
}
