import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Oval extends Shape {
	
	
	public Oval(int x1, int y1, int x2, int y2, boolean filled, Color color1, Color color2, boolean gradient) {
		super(x1, y1, x2, y2, filled, color1, color2, gradient);
	}
	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		if(gradient == true) {
			g2d.setPaint(new GradientPaint(x1, y1, color, x2, y2, color2, true));
			g2d.setStroke(new BasicStroke(40f));
		}else 
			g2d.setColor(color);
		
		if(filled) {
			g2d.fillOval(x1, y1, Math.abs(x1 - x2), Math.abs(y1 - y2));
		}else {
			g2d.drawOval(x1, y1, Math.abs(x1- x2), Math.abs(y1 - y2));
			
		}

	}

}
