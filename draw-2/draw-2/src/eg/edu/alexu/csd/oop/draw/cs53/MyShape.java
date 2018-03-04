package eg.edu.alexu.csd.oop.draw.cs53;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import eg.edu.alexu.csd.oop.draw.Shape;

public class MyShape implements Shape {
	
	
	public MyShape(){
		Point x = new Point(0, 0);
		this.setPosition(x);
		this.setColor(Color.CYAN);
		this.setFillColor(Color.black);
		Map<String, Double> h = new HashMap<>();
		
		this.setProperties(h);
	}
	public Point shapePosition = new Point(0,0);
	public Map<String, Double> shapeProp = new HashMap<>();
	
	
	public Color shapeColor = Color.CYAN;
	public Color shapeFillColor = Color.blue;

	
	@Override
	public void setPosition(Point position) {
		// TODO Auto-generated method stub
		if(position != null){
		shapePosition = position;}
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return shapePosition;
	}

	@Override
	public void setProperties(Map<String, Double> properties) {
		// TODO Auto-generated method stub
		
		shapeProp = properties;
		
		ArrayList<String> l = new ArrayList<String>(shapeProp.keySet());
if(l.size()==0){
	shapeProp = null;
}

		
	}

	@Override
	public Map<String, Double> getProperties() {

		// TODO Auto-generated method stub
		return shapeProp;
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		if(color != null){
		shapeColor = color;}
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return shapeColor;
	}

	@Override
	public void setFillColor(Color color) {
		// TODO Auto-generated method stub
		if(color != null){
			shapeFillColor = color;}
	}

	@Override
	public Color getFillColor() {
		// TODO Auto-generated method stub
		return shapeFillColor;
	}

	@Override
	public void draw(Graphics canvas) {
		// TODO Auto-generated method stub
		//canvas.setColor(getColor());
		//Point g = getPosition();

		//canvas.drawRect(this.theshapeposition.x, this.theshapeposition.y, 20, 50);
	}

	@Override
	public Object clone() {
		
		
		
		
		//this.mycictionary.get("width");

		return null;
	}

	
}
