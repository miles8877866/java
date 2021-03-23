import java.awt.Color;
import java.awt.Graphics;

public class Circle3 extends Shape {

	private Color color3;

	public Circle3(int x1, int y1, int x2, int y2, Color color, Color color2, Color color3) {
		super(x1, y1, x2, y2, color, color2);
		this.color3 = color3;
	}

	public void setColor3(Color color3) {
		this.color3 = color3;
	}

	public Color getColor3(Color color3) {
		return color3;
	}

	public void draw(Graphics g) {
		if (Math.abs(x1 - x2) > Math.abs(y1 - y2)) {// 如果x邊大於 y邊
			g.setColor(color);
			g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(x1 - x2));
			g.setColor(color2);
			g.fillOval(Math.min(x1, x2) + Math.abs(x1 - x2)/4, Math.min(y1, y2) + Math.abs(x1 - x2)/4, Math.abs(x1 - x2)/2 ,
					Math.abs(x1 - x2) /2);
			g.setColor(color3);
			g.fillOval(Math.min(x1, x2) + Math.abs(x1 - x2)/4 + 
					Math.abs(x1 - x2)/8, Math.min(y1, y2) + Math.abs(x1 - x2)/4 + Math.abs(x1 - x2)/8, Math.abs(x1 - x2)/4,
					Math.abs(x1 - x2)/4);
		} else {
			g.setColor(color);
			g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(y1 - y2), Math.abs(y1 - y2));
			g.setColor(color2);
			g.fillOval(Math.min(x1, x2) + Math.abs(y1 - y2)/4, Math.min(y1, y2) + Math.abs(y1 - y2)/4, Math.abs(y1 - y2)/2 ,
					Math.abs(y1 - y2) /2);
			g.setColor(color3);
			g.fillOval(Math.min(x1, x2) + Math.abs(y1 - y2)/4 + Math.abs(y1 - y2)/8, Math.min(y1, y2) 
					+ Math.abs(y1 - y2)/4 + Math.abs(y1 - y2)/8, Math.abs(y1 - y2)/4,
					Math.abs(y1 - y2)/4);
		}

	}

	
	public String toString() {
		return "Circle3 [color3=" + color3 + ", color=" + color + ", color2=" + color2 + "]";
	}

}
