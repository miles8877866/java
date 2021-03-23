package W06;


import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

public class Vtri extends Shape {

	private int type;
	final int UpLeft = 1;
	final int UpRight = 2;
	final int DownLeft = 3;
	final int DownRight = 4;

	public Vtri(int x1, int y1, int x2, int y2, int type, boolean filled, Color color) {
		super(x1, y1, x2, y2, filled, color);
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getY4() {
		return Y4;
	}

	public void setY4(int y4) {
		Y4 = y4;
	}

	int X1 = Math.min(x1, x2);
	int Y1 = Math.min(y1, y2);
	int X2 = Math.max(x1, x2);
	int Y2 = Math.min(y1, y2);
	int X3 = Math.min(x1, x2);
	int Y3 = Math.max(y1, y2);
	int X4 = Math.max(x1, x2);
	int Y4 = Math.max(y1, y2);

	int[] x;
	int[] y;

	public void draw(Graphics g) {
		g.setColor(color);
		switch (type) {
		case UpLeft:
			x = new int[] { X1, X3, X4 };
			y = new int[] { Y1, Y3, Y4 };

			break;
		case UpRight:
			x = new int[] { X4, X2, X3 };
			y = new int[] { Y4, Y2, Y3 };

		case DownLeft:
			x = new int[] { X1, X2, X3 };
			y = new int[] { Y1, Y2, Y3 };

			break;
		case DownRight:
			x = new int[] { X1, X2, X4 };
			y = new int[] { Y1, Y2, Y4 };
			break;
		}
		if (filled)
			g.fillPolygon(x, y, 3);
		else
			g.drawPolygon(x, y, 3);

	}

	@Override
	public String toString() {
		return "Vtri [type=" + type + ", x=" + Arrays.toString(x) + ", y=" + Arrays.toString(y) + ", x1=" + x1 + ", y1="
				+ y1 + ", x2=" + x2 + ", y2=" + y2 + ", filled=" + filled + ", color=" + color + "]";
	}

}
