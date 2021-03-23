package painter;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rect extends Shape {

	public Rect(int x1, int y1, int x2, int y2, boolean filled, Color color) {
		super(x1, y1, x2, y2, filled, color);
		// TODO Auto-generated constructor stub
	}

	public Rect(int x1, int y1, int x2, int y2, boolean filled, Color color, Color color2) {
		super(x1, y1, x2, y2, filled, color, color2);
		// TODO Auto-generated constructor stub
	}

	public Rect(int x1, int y1, int x2, int y2, boolean filled, Color color, Color color2, boolean gradient, float stroke) {
		super(x1, y1, x2, y2, filled, color, color2, gradient, stroke);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if(gradient) 
		  g2d.setPaint(new GradientPaint(x1, y1, color, x2, y2, color2, true));
		else
		  g2d.setPaint(color);
		g2d.setStroke(new BasicStroke(stroke));
		if (filled) {
			g2d.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
		} else {
			g2d.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
		}

	}

	@Override
	public String toString() {
		return "Rect [x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + ", filled=" + filled + ", gradient="
				+ gradient + ", color=" + color + ", color2=" + color2 + ", stroke=" + stroke + "]";
	}

    


}
