import java.awt.Graphics;

import javax.swing.JPanel;

public class Board extends JPanel{

	
	//�ƼgJPanel��paint��k�A��@ø�e
	public void paint(Graphics g) {
		g.drawImage(table, 0, 0, null);
	}
}
