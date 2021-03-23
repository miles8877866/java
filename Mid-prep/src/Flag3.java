import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Flag3 extends Rect {

	private Color color3;

	public Flag3(int x1, int y1, int x2, int y2, Color color, Color color2, Color color3) {
		super(x1, y1, x2, y2, color, color2);
		this.color3 = color3;
	}

	public void draw(Graphics g) {
		Graphics2D g2d =  (Graphics2D)g;
		g2d.setStroke(new BasicStroke(40));
		
		if (x1 < x2) {
			g2d.setColor(color);
			g2d.fillRect(x1, y1, Math.abs(x1 - x2) / 3, Math.abs(y1 - y2));
			g2d.setColor(color2);
			g2d.fillRect(x1 + Math.abs(x1 - x2) / 3, y1, Math.abs(x1 - x2) / 3, Math.abs(y1 - y2));
			g2d.setColor(color3);
			g2d.fillRect(x1 + 2 * Math.abs(x1 - x2) / 3, y1, Math.abs(x1 - x2) / 3, Math.abs(y1 - y2));
		} else {
			g2d.setColor(color);
			g2d.fillRect(x1 - Math.abs(x1 - x2) / 3, y1, Math.abs(x1 - x2) / 3, Math.abs(y1 - y2));
			g2d.setColor(color2);
			g2d.fillRect(x1 - 2 * Math.abs(x1 - x2) / 3, y1, Math.abs(x1 - x2) / 3, Math.abs(y1 - y2));
			g2d.setColor(color3);
			g2d.fillRect(x1 - 3 * Math.abs(x1 - x2) / 3, y1, Math.abs(x1 - x2) / 3, Math.abs(y1 - y2));
		}

	}

	public String toString() {
		return "Flag3 [color3=" + color3 + ", color=" + color + ", color2=" + color2 + "]";
	}
}
