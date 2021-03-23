package W06;


import java.awt.Color;

import java.awt.Graphics;

import javax.swing.JPanel;

import java.util.Random;

public class DrawPanel extends JPanel {

	private int shapeCount;
	private Shape shapes[];
	
	
	final int MAX = 100; //最多畫100個
	private int x1, y1, x2, y2;
	private boolean filled;
	private Color color;

	private int shapeType;

	final int shapeNum = 4;
	final int RECT = 1;
	final int OVAL = 2;
	final int VTRI = 3;
	final int DIAMOND = 4;

	private int type;
	final int UpLeft = 1;
	final int UpRight = 2;
	final int DownLeft = 3;
	final int DownRight = 4;

	Random rand;

	public DrawPanel() {
		super();
		shapes = new Shape[MAX];
		
		rand = new Random();
		Randgen(20);
	}
	
	
	
	public void Randgen(int n) {
		
		for(int i=0;i<n;i++) {
			x1 = rand.nextInt(900);
			y1 = rand.nextInt(900);
			x2 = rand.nextInt(900);
			y2 = rand.nextInt(900);
			filled = rand.nextBoolean();
			type = rand.nextInt(4) + 1;
			color = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
			shapeType = rand.nextInt(shapeNum)+1;
			switch(shapeType) {
			case RECT:
				shapes[shapeCount++] = new Rect(x1, y1, x2, y2, filled, color);
				break;
			case OVAL:
				shapes[shapeCount++] = new Oval(x1, y1, x2, y2, filled, color);
				break;
			case VTRI:
				shapes[shapeCount++] = new Vtri(x1, y1, x2, y2, type, filled, color);
				break;
			case DIAMOND:
				shapes[shapeCount++] = new Dimond(x1, y1, x2, y2, filled, color);
				break;
			}
			
		}
		repaint(); //重新畫
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i = 0; i < shapeCount; i++) {
			shapes[i].draw(g);
			System.out.println(shapes[i]);
		}
	}



	public void clear() {
		shapeCount = 0;
		repaint();
	}
	
	public void undo() {
		shapeCount --;
		repaint();
		if(shapeCount < 0)
			return;
	}
	
	public void redo() {
		shapeCount ++;
		repaint();
		if(shapeCount>=MAX)
			return;
		
	}
}
