package eg.edu.alexu.csd.oop.draw.cs53;

import java.awt.Color;
import java.awt.List;
import java.awt.Point;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import eg.edu.alexu.csd.oop.draw.DrawingEngine;
import eg.edu.alexu.csd.oop.draw.Shape;

public class MyDrawingEngine implements DrawingEngine {

	int undoCounter = 0;
	public ArrayList<Shape> shArr = new ArrayList<Shape>();
	Stack<Object> undoS = new Stack<Object>();
	Stack<Object> redoS = new Stack<Object>();
	boolean isUndo = false;
	boolean isRedo = false;

	/* redraw all shapes on the canvas */
	public void refresh(java.awt.Graphics canvas) {
		for (int i = 0; i < shArr.size(); i++) {
			shArr.get(i).draw(canvas);
		}
	}

	public void addShape(Shape shape) {
		
		shArr.add(shape);
		if (!isUndo) {
			if (undoCounter >= 20) {
				undoS.remove(0);
				undoS.remove(0);
				undoS.remove(0);
			} else {
				undoCounter++;
			}
			undoS.push('a');
			undoS.push(shape);
			undoS.push('a');

			if (!isRedo) {
				redoS.clear();
			} else {
				isRedo = false;
			}
		} else {
			isUndo = false;
		}
	}

	public void removeShape(Shape shape) {
		Point x = shape.getPosition();
		for (int i = 0; i < shArr.size(); i++) {
			Point y = shArr.get(i).getPosition();
			// sSystem.out.println(shArr.get(i).getClass());
			if (x == y) {
				shArr.remove(i);
				break;
			}
		}
		if (!isUndo) {
			if (undoCounter >= 20) {
				undoS.remove(0);
				undoS.remove(0);
				undoS.remove(0);
			} else {
				undoCounter++;
			}
			undoS.push('r');
			undoS.push(shape);
			undoS.push('r');
		} else {
			isUndo = false;
		}
	}

	// move resize
	public void updateShape(Shape oldShape, Shape newShape) {
		Point x = oldShape.getPosition();
		for (int i = 0; i < shArr.size(); i++) {
			Point y = shArr.get(i).getPosition();
			if (x == y && oldShape.getClass().getName().equalsIgnoreCase(shArr.get(i).getClass().getName())) {
				shArr.set(i, newShape);
				break;
			}
		}
		if (!isUndo) {
			if (undoCounter >= 20) {
				undoS.remove(0);
				undoS.remove(0);
				undoS.remove(0);
			} else {
				undoCounter++;
			}
			undoS.push(oldShape);
			undoS.push(newShape);
			undoS.push('u');
		} else {
			isUndo = false;
		}
	}

	/* return the created shapes objects */
	public Shape[] getShapes() {
		Shape[] shapes = new Shape[shArr.size()];
		for (int i = 0; i < shArr.size(); i++) {
			shapes[i] = shArr.get(i);
		}
		return shapes;
	}

	/*
	 * return the classes (types) of supported shapes that can be dynamically
	 * loaded at runtime (see Part 3)
	 */
	public java.util.List<Class<? extends Shape>> getSupportedShapes() {
		final LinkedList<Class<? extends Shape>> supported = new LinkedList<Class<? extends Shape>>();
		supported.add(circles.class);
		supported.add(rectangles.class);
		supported.add(Line.class);
		supported.add(Triangle.class);

		return supported;
	}

	/*
	 * limited to 20 steps. You consider these actions in undo & redo: addShape,
	 * removeShape, updateShape
	 */
	public void undo() {
		if (!undoS.isEmpty()) {
			undoCounter--;
			isUndo = true;
			char operation = (Character) undoS.pop();
			Shape g;
			switch (operation) {
			case 'a':
				g = (Shape) undoS.pop();
				undoS.pop();//
				this.removeShape(g);
				redoS.push(g);
				redoS.push('r');
				break;
			case 'r':
				g = (Shape) undoS.pop();
				undoS.pop();//
				this.addShape(g);
				redoS.push(g);
				redoS.push('a');
				break;
			case 'u':
				g = (Shape) undoS.pop();
				Shape g2 = (Shape) undoS.pop();
				this.updateShape(g, g2);
				redoS.push(g);
				redoS.push(g2);
				redoS.push('u');
				break;
			}
		}

	}

	public void redo() {
		if (!redoS.isEmpty()) {
			char operation = (Character) redoS.pop();
			Shape g;
			switch (operation) {
			case 'a':
				g = (Shape) redoS.pop();
				this.removeShape(g);
				// undoS.push(g);
				// undoS.push('r');
				break;
			case 'r':
				g = (Shape) redoS.pop();
				isRedo = true;
				this.addShape(g);
				// undoS.push(g);
				// undoS.push('a');
				break;
			case 'u':
				g = (Shape) redoS.pop();
				Shape g2 = (Shape) redoS.pop();
				this.updateShape(g, g2);
				// undoS.push(g);
				// undoS.push(g2);
				// undoS.push('u');
				break;
			}
		}

	}

	/*
	 * use the file extension to determine the type, or throw runtime exception
	 * when unexpected extension
	 */
	public void save(String path) {

		// String part[]= path.split(".");
		// System.out.println(part[0]);

		if (path.charAt(path.length() - 1) == 'l') {

			try {
				XMLEncoder o = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path)));
				o.writeObject(shArr);
				o.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			json test = new json();
			test.save(shArr, path);
		}
	}

	@SuppressWarnings("unchecked")
	public void load(String path) {
		undoS.clear();
		redoS.clear();
		
		if (path.charAt(path.length() - 1) == 'l') {
			// public void load() {
			// initialized = true;
			XMLDecoder d = null;

			try {
				d = new XMLDecoder(new BufferedInputStream(new FileInputStream(path)));
				shArr = (ArrayList<Shape>) d.readObject();
				d.close();
			} catch (FileNotFoundException ex) {
			}
		} else {
			// this.refresh(canvas);
			// }
			json test = new json();
			shArr = test.read(path);
		}

	}

	public Shape select(int x, int y, int x1, int y1) {
		Shape z = new MyShape();
		boolean found = false;
		for (int i = 0; i < shArr.size() && !found; i++) {
			String RecClass = "eg.edu.alexu.csd.oop.draw.cs53.rectangles";
			String CirClass = "eg.edu.alexu.csd.oop.draw.cs53.circles";
			String TriClass = "eg.edu.alexu.csd.oop.draw.cs53.Triangle";
			String LineClass = "eg.edu.alexu.csd.oop.draw.cs53.Line";
			z = shArr.get(i);
			if (z.getClass().getName().equalsIgnoreCase(RecClass)) {
				boolean t = x < z.getPosition().x;
				boolean t1 = y < z.getPosition().y;
				boolean t2 = z.getPosition().x + z.getProperties().get("width") < x1;
				boolean t3 = z.getPosition().y + z.getProperties().get("hieght") < y1;
				if (t && t1 && t2 && t3) {
					z.setFillColor(Color.RED);
					found = true;
				}
			} else if (z.getClass().getName().equalsIgnoreCase(CirClass)) {
				boolean t = x < z.getPosition().x;
				boolean t1 = y < z.getPosition().y;
				boolean t2 = z.getPosition().x + z.getProperties().get("width") < x1;
				boolean t3 = z.getPosition().y + z.getProperties().get("hieght") < y1;
				if (t && t1 && t2 && t3) {
					z.setFillColor(Color.RED);
					found = true;
				}
			} else if (z.getClass().getName().equalsIgnoreCase(TriClass)) {
				boolean t = x < z.getPosition().x && z.getPosition().x < x1;
				boolean t1 = y < z.getPosition().y && z.getPosition().y < y1;
				boolean t2 = x < z.getProperties().get("pointX2") && z.getProperties().get("pointX2") < x1;
				boolean t3 = y < z.getProperties().get("pointY2") && z.getProperties().get("pointY2") < y1;
				boolean t4 = x < z.getProperties().get("pointX3") && z.getProperties().get("pointX3") < x1;
				boolean t5 = y < z.getProperties().get("pointY3") && z.getProperties().get("pointY3") < y1;
				if (t && t1 && t2 && t3 && t4 && t5) {
					// shArr.remove(i);
					z.setFillColor(Color.RED);
					found = true;
				}
			} else if (z.getClass().getName().equalsIgnoreCase(LineClass)) {
				boolean t = x < z.getPosition().x && z.getPosition().x < x1;
				boolean t1 = y < z.getPosition().y && z.getPosition().y < y1;
				boolean t2 = x < z.getProperties().get("pointX2") && z.getProperties().get("pointX2") < x1;
				boolean t3 = y < z.getProperties().get("pointY2") && z.getProperties().get("pointY2") < y1;
				if (t && t1 && t2 && t3) {
					z.setColor(Color.RED);
					found = true;
				}
			}
		}
		if (found) {
			return z;
		} else {
			return null;
		}
	}

}
