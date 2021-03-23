import java.awt.Graphics;

import javax.swing.JPanel;

public class Board extends JPanel{

	
	//複寫JPanel的paint方法，實作繪畫
	public void paint(Graphics g) {
		g.drawImage(table, 0, 0, null);
	}
}
