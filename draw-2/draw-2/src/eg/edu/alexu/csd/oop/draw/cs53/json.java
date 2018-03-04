package eg.edu.alexu.csd.oop.draw.cs53;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

import eg.edu.alexu.csd.oop.draw.Shape;

public class json {

	public void write(ArrayList<Shape> shapes, String path) throws IOException {

		try (FileWriter file = new FileWriter("path");) {
			char a = '"';
			file.write("{" + a + "shapes" + a + ':' + '[');

			for (int i = 0; i < shapes.size(); i++) {
				Shape myshape = shapes.get(i);
				String m = myshape.getClass().getName();
				try {

					String kindofShape = shapes.get(i).getClass().getName();
					if (kindofShape == "eg.edu.alexu.csd.oop.draw.cs53.rectangles") {
						rectangles myRect = new rectangles();
						myRect = (rectangles) shapes.get(i);
						Point f = myshape.getPosition();
						String x = String.valueOf(f.x);
						String y = String.valueOf(f.y);

						Map<String, Double> mymap = new HashMap<>();
						mymap = myshape.getProperties();
						double x1 = myRect.getPosition().getX();
						double y1 = myRect.getPosition().getY();
						double w = mymap.get("width");
						double h = mymap.get("hieght");
						String positionX = Double.toString(x1);
						String positionY = Double.toString(y1);
						String Width = Double.toString(w);
						String Height = Double.toString(h);
						Color colo = myRect.getColor();
						Color filcolo = myRect.getFillColor();
						int gcolor = colo.getGreen();
						int bcolor = colo.getBlue();
						int rcolor = colo.getRed();
						int gfillcolor = filcolo.getGreen();
						int bfillcolor = filcolo.getBlue();
						int rfillcolor = filcolo.getRed();

						file.write("{" + a + "kind" + a + ":" + a + kindofShape + a + ',' + a + "positionx" + a + ":"
								+ a + positionX + a + ',' + a + "positiony" + a + ":" + a + positionY + a + ',' + a
								+ "width" + a + ":" + a + Width + a + ',' + a + "height" + a + ":" + a + Height + a
								+ ',' + a + "color" + a + ":" + "[" + rcolor + "," + gcolor + "," + bcolor + "]" + ','
								+ a + "fillcolor" + a + ":" + "[" + rfillcolor + "," + gfillcolor + "," + bfillcolor
								+ "]" + "}");
						if (i + 1 != shapes.size()) {
							file.write(",");
						}

					}
					if (kindofShape == "eg.edu.alexu.csd.oop.draw.cs53.circles") {
						circles myCircle = new circles();
						myCircle = (circles) shapes.get(i);
						Point f = myshape.getPosition();
						String x = String.valueOf(f.x);
						String y = String.valueOf(f.y);

						Map<String, Double> mymap = new HashMap<>();
						mymap = myshape.getProperties();
						double x1 = myCircle.getPosition().getX();
						double y1 = myCircle.getPosition().getY();
						double w = mymap.get("width");
						double h = mymap.get("hieght");
						String positionX = Double.toString(x1);
						String positionY = Double.toString(y1);
						String Width = Double.toString(w);
						String Height = Double.toString(h);
						Color colo = myCircle.getColor();
						Color filcolo = myCircle.getFillColor();
						int gcolor = colo.getGreen();
						int bcolor = colo.getBlue();
						int rcolor = colo.getRed();
						int gfillcolor = filcolo.getGreen();
						int bfillcolor = filcolo.getBlue();
						int rfillcolor = filcolo.getRed();

						file.write("{" + a + "kind" + a + ":" + a + kindofShape + a + ',' + a + "positionx" + a + ":"
								+ a + positionX + a + ',' + a + "positiony" + a + ":" + a + positionY + a + ',' + a
								+ "width" + a + ":" + a + Width + a + ',' + a + "height" + a + ":" + a + Height + a
								+ ',' + a + "color" + a + ":" + "[" + rcolor + "," + gcolor + "," + bcolor + "]" + ','
								+ a + "fillcolor" + a + ":" + "[" + rfillcolor + "," + gfillcolor + "," + bfillcolor
								+ "]" + "}");
						if (i + 1 != shapes.size()) {
							file.write(",");
						}

					}

					if (kindofShape == "eg.edu.alexu.csd.oop.draw.cs53.Triangle") {
						Triangle myTriangle = new Triangle();
						myTriangle = (Triangle) shapes.get(i);
						Point f = myshape.getPosition();
						String x = String.valueOf(f.x);
						String y = String.valueOf(f.y);

						Map<String, Double> mymap = new HashMap<>();
						mymap = myshape.getProperties();

						double x1 = myTriangle.getPosition().getX();
						double y1 = myTriangle.getPosition().getY();
						double x2 = mymap.get("pointX2");
						double y2 = mymap.get("pointY2");
						double x3 = mymap.get("pointX3");
						double y3 = mymap.get("pointY3");

						String positionX = Double.toString(x1);
						String positionY = Double.toString(y1);
						String positionx2 = Double.toString(x2);
						String positiony2 = Double.toString(y2);
						String positionx3 = Double.toString(x3);
						String positiony3 = Double.toString(y3);
						Color colo = myTriangle.getColor();
						Color filcolo = myTriangle.getFillColor();
						int gcolor = colo.getGreen();
						int bcolor = colo.getBlue();
						int rcolor = colo.getRed();
						int gfillcolor = filcolo.getGreen();
						int bfillcolor = filcolo.getBlue();
						int rfillcolor = filcolo.getRed();

						file.write("{" + a + "kind" + a + ":" + a + kindofShape + a + ',' + a + "positionx" + a + ":"
								+ a + positionX + a + ',' + a + "positiony" + a + ":" + a + positionY + a + ',' + a
								+ "pointX2" + a + ":" + a + positionx2 + a + ',' + a + "pointY2" + a + ":" + a
								+ positiony2 + a + ',' + a + "pointX3" + a + ":" + a + positionx3 + a + ',' + a
								+ "pointY3" + a + ":" + a + positiony3 + a + ',' + a + "color" + a + ":" + "[" + rcolor
								+ "," + gcolor + "," + bcolor + "]" + ',' + a + "fillcolor" + a + ":" + "[" + rfillcolor
								+ "," + gfillcolor + "," + bfillcolor + "]" + "}");
						if (i + 1 != shapes.size()) {
							file.write(",");
						}

					}
					if (kindofShape == "eg.edu.alexu.csd.oop.draw.cs53.Line") {
						Line myLine = new Line();
						myLine = (Line) shapes.get(i);
						Point f = myshape.getPosition();
						String x = String.valueOf(f.x);
						String y = String.valueOf(f.y);

						Map<String, Double> mymap = new HashMap<>();
						mymap = myshape.getProperties();

						double x1 = myLine.getPosition().getX();
						double y1 = myLine.getPosition().getY();
						double x2 = mymap.get("pointX2");
						double y2 = mymap.get("pointY2");

						String positionX = Double.toString(x1);
						String positionY = Double.toString(y1);
						String positionx2 = Double.toString(x2);
						String positiony2 = Double.toString(y2);
						Color colo = myLine.getColor();
						Color filcolo = myLine.getFillColor();

						int gcolor = colo.getGreen();
						int bcolor = colo.getBlue();
						int rcolor = colo.getRed();

						file.write("{" + a + "kind" + a + ":" + a + kindofShape + a + ',' + a + "positionx" + a + ":"
								+ a + positionX + a + ',' + a + "positiony" + a + ":" + a + positionY + a + ',' + a
								+ "pointX2" + a + ":" + a + positionx2 + a + ',' + a + "pointY2" + a + ":" + a
								+ positiony2 + a + ',' + a + "color" + a + ":" + "[" + rcolor + "," + gcolor + ","
								+ bcolor + "]" + "}");
						if (i + 1 != shapes.size()) {
							file.write(",");
						}

					}

				}

				catch (Exception e) {
					System.out.println("ff");
					// TODO: handle exception
				}

			}

			file.write("]" + "}");

		}

	}

	public ArrayList<Shape> read(String path) {
		ArrayList<Shape> shArr = new ArrayList<Shape>();
		JSONParser parsers = new JSONParser();
		Object obj = null;
		try {
			obj = parsers.parse(new FileReader(path));
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject jsonObject1 = (JSONObject) obj;
		JSONArray solutions = (JSONArray) jsonObject1.get("shapes");

		for (int y = 0; y < solutions.size(); y++) {
			JSONObject h = new JSONObject();
			h = (JSONObject) solutions.get(y);
			// System.out.println(h.get("nullshape"));
			String o = "false";
			if (h.get("nullshape").equals(o)) {
				String kind = (String) h.get("kind");
				if (kind.equals("eg.edu.alexu.csd.oop.draw.cs53.Line")) {
					Line myline = new Line();
					Point myposition = new Point(0, 0);
					double xpos = Double.parseDouble((h.get("positionx").toString()));
					double ypos = Double.parseDouble((h.get("positiony").toString()));
					myposition.x = (int) xpos;
					myposition.y = (int) ypos;
					if (h.get("map").equals("true")) {

						double xpos2 = Double.parseDouble((h.get("pointX2").toString()));
						double ypos2 = Double.parseDouble((h.get("pointY2").toString()));
						Map<String, Double> shapeProp = new HashMap<>();
						shapeProp.put("pointX2", xpos2);
						shapeProp.put("pointY2", ypos2);
						myline.setProperties(shapeProp);

					}
					JSONArray col = (JSONArray) h.get("color");
					String fg = col.toJSONString();
					String co = "";
					for (int k = 0; k < fg.length(); k++) {
						if (fg.charAt(k) != '[' && fg.charAt(k) != ']') {
							co += fg.charAt(k);
						}
					}
					String part[] = co.split(",");
					int red = Integer.parseInt(part[0]);
					int green = Integer.parseInt(part[1]);
					int blue = Integer.parseInt(part[2]);

					Color myColor = new Color(red, green, blue);
					myline.setPosition(myposition);

					myline.setColor(myColor);
					shArr.add(myline);
				}
				if (kind.equals("eg.edu.alexu.csd.oop.draw.cs53.circles")) {
					circles myrectangle = new circles();
					Point myposition = new Point(0, 0);
					double xpos = Double.parseDouble((h.get("positionx").toString()));
					double ypos = Double.parseDouble((h.get("positiony").toString()));

					myposition.x = (int) xpos;
					myposition.y = (int) ypos;
					if (h.get("map").equals("true")) {
						double xpos2 = Double.parseDouble((h.get("width").toString()));
						double ypos2 = Double.parseDouble((h.get("hieght").toString()));
						Map<String, Double> shapeProp = new HashMap<>();
						shapeProp.put("width", xpos2);
						shapeProp.put("hieght", ypos2);
						myrectangle.setProperties(shapeProp);
					}
					JSONArray col = (JSONArray) h.get("color");

					String fg = col.toJSONString();
					String co = "";
					for (int k = 0; k < fg.length(); k++) {
						if (fg.charAt(k) != '[' && fg.charAt(k) != ']') {
							co += fg.charAt(k);
						}
					}
					String part[] = co.split(",");
					int red = Integer.parseInt(part[0]);
					int green = Integer.parseInt(part[1]);
					int blue = Integer.parseInt(part[2]);

					Color myColor = new Color(red, green, blue);
					myrectangle.setPosition(myposition);

					myrectangle.setColor(myColor);

					JSONArray fcol = (JSONArray) h.get("fillcolor");

					String ffg = fcol.toJSONString();
					String fco = "";
					for (int k = 0; k < ffg.length(); k++) {
						if (ffg.charAt(k) != '[' && ffg.charAt(k) != ']') {
							fco += ffg.charAt(k);
						}
					}
					String fpart[] = fco.split(",");
					int fred = Integer.parseInt(fpart[0]);
					int fgreen = Integer.parseInt(fpart[1]);
					int fblue = Integer.parseInt(fpart[2]);

					Color myfColor = new Color(fred, fgreen, fblue);

					myrectangle.setFillColor(myfColor);

					shArr.add(myrectangle);
				}
				if (kind.equals("eg.edu.alexu.csd.oop.draw.cs53.Triangle")) {
					Triangle myrectangle = new Triangle();
					Point myposition = new Point(0, 0);
					double xpos = Double.parseDouble((h.get("positionx").toString()));
					double ypos = Double.parseDouble((h.get("positiony").toString()));

					myposition.x = (int) xpos;
					myposition.y = (int) ypos;
					if (h.get("map").equals("true")) {
						double xpos2 = Double.parseDouble((h.get("pointX2").toString()));
						double ypos2 = Double.parseDouble((h.get("pointY2").toString()));
						double xpos3 = Double.parseDouble((h.get("pointX3").toString()));
						double ypos3 = Double.parseDouble((h.get("pointY3").toString()));
						Map<String, Double> shapeProp = new HashMap<>();
						shapeProp.put("pointX2", xpos2);
						shapeProp.put("pointY2", ypos2);
						shapeProp.put("pointX3", xpos3);
						shapeProp.put("pointY3", ypos3);
						myrectangle.setProperties(shapeProp);
					}

					JSONArray col = (JSONArray) h.get("color");

					String fg = col.toJSONString();
					String co = "";
					for (int k = 0; k < fg.length(); k++) {
						if (fg.charAt(k) != '[' && fg.charAt(k) != ']') {
							co += fg.charAt(k);
						}
					}
					String part[] = co.split(",");
					int red = Integer.parseInt(part[0]);
					int green = Integer.parseInt(part[1]);
					int blue = Integer.parseInt(part[2]);

					Color myColor = new Color(red, green, blue);
					myrectangle.setPosition(myposition);

					myrectangle.setColor(myColor);

					JSONArray fcol = (JSONArray) h.get("fillcolor");

					String ffg = fcol.toJSONString();
					String fco = "";
					for (int k = 0; k < ffg.length(); k++) {
						if (ffg.charAt(k) != '[' && ffg.charAt(k) != ']') {
							fco += ffg.charAt(k);
						}
					}
					String fpart[] = fco.split(",");
					int fred = Integer.parseInt(fpart[0]);
					int fgreen = Integer.parseInt(fpart[1]);
					int fblue = Integer.parseInt(fpart[2]);

					Color myfColor = new Color(fred, fgreen, fblue);

					myrectangle.setFillColor(myfColor);

					shArr.add(myrectangle);
				}
				if (kind.equals("eg.edu.alexu.csd.oop.draw.cs53.rectangles")) {
					rectangles myrectangle = new rectangles();
					Point myposition = new Point(0, 0);
					double xpos = Double.parseDouble((h.get("positionx").toString()));
					double ypos = Double.parseDouble((h.get("positiony").toString()));

					myposition.x = (int) xpos;
					myposition.y = (int) ypos;
					if (h.get("map").equals("true")) {

						double xpos2 = Double.parseDouble((h.get("width").toString()));
						double ypos2 = Double.parseDouble((h.get("hieght").toString()));
						Map<String, Double> shapeProp = new HashMap<>();
						shapeProp.put("width", xpos2);
						shapeProp.put("hieght", ypos2);
						myrectangle.setProperties(shapeProp);
					}
					JSONArray col = (JSONArray) h.get("color");

					String fg = col.toJSONString();
					String co = "";
					for (int k = 0; k < fg.length(); k++) {
						if (fg.charAt(k) != '[' && fg.charAt(k) != ']') {
							co += fg.charAt(k);
						}
					}
					String part[] = co.split(",");
					int red = Integer.parseInt(part[0]);
					int green = Integer.parseInt(part[1]);
					int blue = Integer.parseInt(part[2]);

					Color myColor = new Color(red, green, blue);
					myrectangle.setPosition(myposition);

					myrectangle.setColor(myColor);

					JSONArray fcol = (JSONArray) h.get("fillcolor");

					String ffg = fcol.toJSONString();
					String fco = "";
					for (int k = 0; k < ffg.length(); k++) {
						if (ffg.charAt(k) != '[' && ffg.charAt(k) != ']') {
							fco += ffg.charAt(k);
						}
					}
					String fpart[] = fco.split(",");
					int fred = Integer.parseInt(fpart[0]);
					int fgreen = Integer.parseInt(fpart[1]);
					int fblue = Integer.parseInt(fpart[2]);

					Color myfColor = new Color(fred, fgreen, fblue);

					myrectangle.setFillColor(myfColor);

					shArr.add(myrectangle);
				}
				if (kind.equals("eg.edu.alexu.csd.oop.draw.DummyShape")) {
					rectangles myrectangle = new rectangles();
					Point myposition = new Point(0, 0);
					double xpos = Double.parseDouble((h.get("positionx").toString()));
					double ypos = Double.parseDouble((h.get("positiony").toString()));
					Map<String, Double> shapeProp1 = new HashMap<>();
					shapeProp1.put("width", 0.0);
					shapeProp1.put("hieght", 0.0);
					myrectangle.setProperties(shapeProp1);
					myposition.x = (int) xpos;
					myposition.y = (int) ypos;
					if (h.get("map").equals("true")) {

						double xpos2 = Double.parseDouble((h.get("width").toString()));
						double ypos2 = Double.parseDouble((h.get("hieght").toString()));
						Map<String, Double> shapeProp = new HashMap<>();
						shapeProp.put("width", xpos2);
						shapeProp.put("hieght", ypos2);
						myrectangle.setProperties(shapeProp);
					}else{
						Map<String, Double> shapeProp = new HashMap<>();
						shapeProp.put("width", 0.0);
						shapeProp.put("hieght", 0.0);
						myrectangle.setProperties(shapeProp);
					}
					
					JSONArray col = (JSONArray) h.get("color");

					String fg = col.toJSONString();
					String co = "";
					for (int k = 0; k < fg.length(); k++) {
						if (fg.charAt(k) != '[' && fg.charAt(k) != ']') {
							co += fg.charAt(k);
						}
					}
					String part[] = co.split(",");
					int red = Integer.parseInt(part[0]);
					int green = Integer.parseInt(part[1]);
					int blue = Integer.parseInt(part[2]);

					Color myColor = new Color(red, green, blue);
					myrectangle.setPosition(myposition);

					myrectangle.setColor(myColor);

					JSONArray fcol = (JSONArray) h.get("fillcolor");

					String ffg = fcol.toJSONString();
					String fco = "";
					for (int k = 0; k < ffg.length(); k++) {
						if (ffg.charAt(k) != '[' && ffg.charAt(k) != ']') {
							fco += ffg.charAt(k);
						}
					}
					String fpart[] = fco.split(",");
					int fred = Integer.parseInt(fpart[0]);
					int fgreen = Integer.parseInt(fpart[1]);
					int fblue = Integer.parseInt(fpart[2]);

					Color myfColor = new Color(fred, fgreen, fblue);

					myrectangle.setFillColor(myfColor);

					shArr.add(myrectangle);
				}
				if (!kind.equals("eg.edu.alexu.csd.oop.draw.cs53.Line")
						&& !kind.equals("eg.edu.alexu.csd.oop.draw.cs53.circles")
						&& !kind.equals("eg.edu.alexu.csd.oop.draw.cs53.Triangle")
						&& !kind.equals("eg.edu.alexu.csd.oop.draw.cs53.rectangles")
						&& !kind.equals("eg.edu.alexu.csd.oop.draw.DummyShape")) {

					throw new RuntimeException(kind);

				}

			} else {
				shArr.add(null);
			}
		}
		return shArr;

	}

	public void save(ArrayList<Shape> shapes, String path) {
		JSONObject jo = new JSONObject();

		JSONArray ja = new JSONArray();

		for (int i = 0; i < shapes.size(); i++) {
			JSONObject myobject = new JSONObject();
			Shape myshape = shapes.get(i);
			if (shapes.get(i) != null) {

				String m = myshape.getClass().getName();
				try {
					Point f = myshape.getPosition();
					if (f == null) {
						Point ds = new Point(0, 0);
						f = ds;

					}
					String x = String.valueOf(f.x);
					String y = String.valueOf(f.y);

					myobject.put("kind", myshape.getClass().getName());
					myobject.put("positionx", x);
					myobject.put("positiony", y);
					Color colo = myshape.getColor();
					Color filcolo = myshape.getFillColor();
					int gcolor = colo.getGreen();
					int bcolor = colo.getBlue();
					int rcolor = colo.getRed();

					JSONArray col = new JSONArray();
					col.add(rcolor);
					col.add(gcolor);
					col.add(bcolor);

					myobject.put("color", col);

					try {
						int gfillcolor = 10;
						int bfillcolor = 10;
						int rfillcolor = 10;
						JSONArray fcol = new JSONArray();
						fcol.add(rfillcolor);
						fcol.add(gfillcolor);
						fcol.add(bfillcolor);
						myobject.put("fillcolor", fcol);
					} catch (Exception e) {
						throw new RuntimeException("a7a7a7a7a7a7");
						// TODO: handle exception
					}

					myobject.put("nullshape", "false");

					Map<String, Double> mymap = new HashMap<>();
					mymap = myshape.getProperties();
					if (mymap != null) {
						myobject.put("map", "true");
						ArrayList<String> l = new ArrayList<String>(mymap.keySet());
						for (int d = 0; d < l.size(); d++) {
							myobject.put(l.get(d), mymap.get(l.get(d)));
						}

					} else {
						myobject.put("map", "false");
					}
					ja.add(myobject);

				} catch (Exception e) {
					throw new RuntimeException(e);
					// TODO Auto-generated catch block
				}
			} else {
				myobject.put("nullshape", "true");
				ja.add(myobject);
			}
			try (FileWriter file = new FileWriter(path);) {
				jo.put("shapes", ja);
				file.write(jo.toString());
				file.flush();

			} catch (Exception e) {
				throw new RuntimeException(e);
				// TODO: handle exception
			}

		}

	}

}
