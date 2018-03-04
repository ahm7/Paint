package eg.edu.alexu.csd.oop.draw.cs53;

import java.awt.Color;
//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
//import java.awt.Point;
import java.awt.geom.Ellipse2D;
//import java.util.Map;
import java.util.HashMap;
import java.util.Map;

//import eg.edu.alexu.csd.oop.draw.Shape;

public class circles extends MyShape {
	
public circles(){
	Point x = new Point(0, 0);
	this.setPosition(x);
	this.setColor(Color.CYAN);
	this.setFillColor(Color.black);
		Map<String, Double> h = new HashMap<>();
		h.put("width", 0.0);
		h.put("hieght", 0.0);
		this.setProperties(h);		
	}
	
	
	private int x=0;
	private int  y =0;
	private double widt=0;
	private double high=0;
	
	
	@Override
	public void draw(Graphics canvas) {
		double x1 = this.shapePosition.getX();
		if(this.getPosition()==null || this.shapeProp.get("width")==null || this.shapeProp.get("hieght")==null){
			throw null;
		}
		x=(int)x1;
		double y1 = this.shapePosition.getY();		
		y=(int)y1;
		double w = this.shapeProp.get("width");
		widt = w;
		double h = this.shapeProp.get("hieght");
		high=h;
		Graphics2D g2 =(Graphics2D)canvas;
		g2.setColor(this.shapeFillColor);
	    g2.fill(new Ellipse2D.Double(x1, y1, w, h));
		g2.setColor(this.shapeColor);
	    g2.draw(new Ellipse2D.Double(x1, y1, w, h));
	    // TODO Auto-generated method stub
	}
	@Override
	public Object clone() {
		MyShape copy = new circles();
		Point mypoint = new Point(x,y);
		 Map<String, Double> shapeProp = new HashMap<>();
		 shapeProp =this.shapeProp;
		 copy.setPosition(mypoint);
copy.setColor(this.shapeColor);
copy.setFillColor(this.shapeFillColor);
		// TODO Auto-generated method stub
		return copy;
	}

}
