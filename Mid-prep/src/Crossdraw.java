import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Crossdraw extends Shape {

	public Crossdraw(int x1, int y1, int x2, int y2, boolean filled, Color color, Color color2, boolean gradient) {
		super(x1, y1, x2, y2, filled, color, color2, gradient);
	}

	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if (gradient == true) {
			g2d.setPaint(new GradientPaint(x1, y1, color, x2, y2, color2, true));
			g2d.setStroke(new BasicStroke(40f));
		} else {
			g2d.setColor(Color.black);
		}

		g2d.drawLine(x1, y1, x2, y2);
		g2d.drawLine(x2, y1, x1, y2);
	}

	@Override
	public String toString() {
		return "Crossdraw [x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + ", filled=" + filled + ", gradient="
				+ gradient + ", color=" + color + ", color2=" + color2 + "]";
	}

	
}
