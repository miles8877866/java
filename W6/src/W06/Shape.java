package W06;


import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {

	
	protected int x1, y1, x2, y2;//?���?
	protected boolean filled;
	protected Color color;
	
	public Shape() {
		
	}
	
	public Shape(int x1, int y1, int x2, int y2, boolean filled, Color color) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.filled = filled;
		this.color = color;
	}
	
	public abstract void draw(Graphics g);
	
	

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
