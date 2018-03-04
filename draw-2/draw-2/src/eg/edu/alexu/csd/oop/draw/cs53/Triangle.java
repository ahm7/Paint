package eg.edu.alexu.csd.oop.draw.cs53;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.util.HashMap;
import java.util.Map;

public class Triangle extends MyShape {

	public Triangle() {
		Point x = new Point(0, 0);
		this.setPosition(x);
		this.setColor(Color.CYAN);
		this.setFillColor(Color.black);
		Map<String, Double> h = new HashMap<>();
		h.put("pointX2", 0.0);
		h.put("pointY2", 0.0);
		h.put("pointX3", 0.0);
		h.put("pointY3", 0.0);
		this.setProperties(h);

	}

	private int x = 0;
	private int y = 0;

	@Override

	public void draw(Graphics canvas) {
		double x1 = this.shapePosition.getX();
		double y1 = this.shapePosition.getY();
		x = (int) x1;
		y = (int) y1;
		double x2 = this.shapeProp.get("pointX2");
		double y2 = this.shapeProp.get("pointY2");
		double x3 = this.shapeProp.get("pointX3");
		double y3 = this.shapeProp.get("pointY3");

		GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 3);
		polygon.moveTo(x1, y1);
		polygon.lineTo(x2, y2);
		polygon.lineTo(x3, y3);
		polygon.closePath();
		Graphics2D g2 = (Graphics2D) canvas;
		g2.setColor(this.shapeFillColor);
		g2.fill(polygon);
		g2.setColor(this.shapeColor);
		g2.draw(polygon);
		// TODO Auto-generated method stub
	}

	@Override
	public Object clone() {
		MyShape copy = new circles();
		Point mypoint = new Point(x, y);
		Map<String, Double> shapeProp = new HashMap<>();
		shapeProp = this.shapeProp;
		copy.setPosition(mypoint);
		copy.setColor(this.shapeColor);
		// TODO Auto-generated method stub
		return copy;
	}

}
