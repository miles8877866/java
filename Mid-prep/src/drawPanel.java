import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

public class drawPanel extends JPanel implements MouseListener, MouseMotionListener {

	private Shape shapes[];
	final int MAX = 100;
	private int shapeCount = 0;
	private Shape currentShape;
	private int x1, y1, x2, y2;
	private int type;
	boolean filled;
	boolean gradient;

	private int numTypes = 3;
	final int Flag3 = 1;
	final int Circle3 = 2;
	final int TicTacToe = 3;
	final int Rect = 4;
	final int Cross = 5;
	final int Oval = 6;

	private Color color1 = Color.BLUE;
	private Color color2 = new Color(128, 0, 128);
	private Color color3 = Color.GREEN;

	public void setType(int type) {
		// TODO Auto-generated method stub
		this.type = type;
	}

	public void setColor(Color color1) {
		this.color1 = color1;
	}

	public void setColor2(Color color2) {
		this.color2 = color2;
	}

	public void setColor3(Color color3) {
		this.color3 = color3;
	}

	public drawPanel() {
		super();
		shapes = new Shape[MAX];
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void clear() {
		shapeCount = 0;
		repaint();
	}

	public void undo() {
		shapeCount--;
		repaint();
	}

	public void redo() {
		shapeCount++;
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < shapeCount; i++) {
			shapes[i].draw(g);
			System.out.println(shapes[i]);
		}
		if (currentShape != null)
			currentShape.draw(g);
	}

	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
		x2 = x1;
		y2 = y1;

		switch (type) {
		case Flag3:
			currentShape = new Flag3(x1, y1, x2, y2, color1, color2, color3);
			break;
		case Circle3:
			currentShape = new Circle3(x1, y1, x2, y2, color1, color2, color3);
			break;
		case TicTacToe:
			currentShape = new TicTacToe(x1, y1, x2, y2);
			break;
		case Rect:
			currentShape = new Rect(x1, y1, x2, y2, filled, color1, color2, gradient);
			break;
		case Oval:
			currentShape = new Oval(x1, y1, x2, y2, filled, color1, color2, gradient);
			break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();

		switch (type) {
		case Flag3:
			shapes[shapeCount++] = new Flag3(x1, y1, x2, y2, color1, color2, color3);
			break;
		case Circle3:
			shapes[shapeCount++] = new Circle3(x1, y1, x2, y2, color1, color2, color3);
			break;
		case TicTacToe:
			shapes[shapeCount++] = new TicTacToe(x1, y1, x2, y2);
			break;
		case Rect:
			shapes[shapeCount++] = new Rect(x1, y1, x2, y2, filled, color1, color2, gradient);
			break;
		case Oval:
			shapes[shapeCount++] = new Oval(x1, y1 ,x2, y2 ,filled, color1, color2, gradient);
			break;
		}
		currentShape = null;
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
		x2 = x1 + 100;
		y2 = y1 + 100;
		
		shapes[shapeCount++] = new Crossdraw(x1, y1, x2, y2, filled, color1, color2, gradient);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		currentShape.x2 = e.getX();
		currentShape.y2 = e.getY();

		repaint();

	}

	public void setFilled(boolean filled) {
		this.filled = filled;

	}

	public void setGradient(boolean gradient) {
		this.gradient = gradient;

	}

}
