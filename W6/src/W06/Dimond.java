package W06;


import java.awt.Color;
import java.awt.Graphics;

public class Dimond extends Shape {

	public Dimond(int x1, int y1, int x2, int y2, boolean filled, Color color) {
		super(x1, y1, x2, y2, filled, color);

	}

	

	int X1 = x1;
	int X2 = (x1 + x2) / 2;
	int X3 = x2;
	int X4 = (x1 + x2) / 2;

	int Y1 =  (y1 + y2) / 2;
	int Y2 = y1;
	int Y3 = (y1 + y2) / 2;
	int Y4 = y2;
	
	int[] x = {X1,X2,X3,X4};
	int[] y = {Y1,Y2,Y3,Y4};

	public void draw(Graphics g) {
		g.setColor(color);
		if(filled) 
			g.fillPolygon(x, y, 4);
		else
			g.drawPolygon(x, y, 4);
	}

	@Override
	public String toString() {
		return "Dimond [X1=" + X1 + ", X2=" + X2 + ", X3=" + X3 + ", X4=" + X4 + ", Y1=" + Y1 + ", Y2=" + Y2 + ", Y3="
				+ Y3 + ", Y4=" + Y4 + "]";
	}

	

	
}
