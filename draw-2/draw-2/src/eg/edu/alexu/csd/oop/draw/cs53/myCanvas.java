package eg.edu.alexu.csd.oop.draw.cs53;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
/*
import javax.script.ScriptException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.color.*;
*/
@SuppressWarnings("serial")
public class myCanvas extends Canvas {

	public void paint(Graphics g) {
		rectangles m = new rectangles();
		m.setColor(Color.black);
		Point xx = new Point(15, 20);
		m.setPosition(xx);
		m.draw(g);

		circles n = new circles();
		n.setColor(Color.BLUE);
		n.draw(g);
	}
/*
	public static void main(String[] args) {

		JFrame jf = new JFrame("tutorial");
		myCanvas t = new myCanvas();
		jf.setSize(600, 400);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(t);

	}
*/
}
