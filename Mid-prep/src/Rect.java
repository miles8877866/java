import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rect extends Shape {

	@Override
	public String toString() {
		return "Rect [x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + ", filled=" + filled + ", gradient="
				+ gradient + ", color=" + color + ", color2=" + color2 + "]";
	}

	// private int type;
	// final int SQUARE = 4;// 對應ShapeType中的SQUARE
	public Rect() {
		super();
	}

	public Rect(int x1, int y1, int x2, int y2, boolean filled, Color color, Color color2, Color color3) {
		super(x1, y1, x2, y2, filled, color, color2);

	}

	public Rect(int x1, int y1, int x2, int y2, boolean filled, Color color, Color color2, boolean gradient) {
		super(x1, y1, x2, y2, filled, color, color2, gradient);

	}

	public Rect(int x1, int y1, int x2, int y2, boolean filled, Color color, Color color2) {
		super(x1, y1, x2, y2, filled, color, color2);

	}

	/*
	 * public Rect(int x1, int y1, int x2, int y2, boolean filled, Color color,
	 * Color color2, int type) { super(x1, y1, x2, y2, filled, color, color2);
	 * this.type = type; }
	 */

	public Rect(int x1, int y1, int x2, int y2, Color color, Color color2) {
		super(x1, y1, x2, y2, color, color2);
	}

	public Rect(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
	}

	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		// g2d.setColor(color2);

		if (gradient == true) {
			g2d.setPaint(new GradientPaint(x1, y1, color, x2, y2, color2, true));
			g2d.setStroke(new BasicStroke(40f));
		} else {
			g2d.setColor(color);
		}
		if (filled) {
			g2d.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));

		} else {
			g2d.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
		}

	}

}