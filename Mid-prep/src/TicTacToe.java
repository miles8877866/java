import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class TicTacToe extends Rect {

	public TicTacToe(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
	}

	public void draw(Graphics g) {

		Random rand = new Random();

		Graphics2D g2d = (Graphics2D) g;
		int width;
		if (Math.abs(x1 - x2) > Math.abs(y1 - y2)) {
			width = Math.abs(x1 - x2);
		} else {
			width = Math.abs(y1 - y2);
		}

		if (x1 > x2) {
			g2d.drawLine(x1 - width / 3, y1, x1 - width / 3, y1 + width);
			g2d.drawLine(x1 - width / 3 * 2, y1, x1 - width * 2 / 3, y1 + width);
			g2d.drawLine(x1, y1 + width / 3, x1 - width, y1 + width / 3);
			g2d.drawLine(x1, y1 + width * 2 / 3, x1 - width, y1 + width * 2 / 3);
		}else {
			g2d.drawLine(x1 + width / 3, y1, x1 + width / 3, y1 + width);
			g2d.drawLine(x1 + width / 3 * 2, y1, x1 + width * 2 / 3, y1 + width);
			g2d.drawLine(x1, y1 + width / 3, x1 + width, y1 + width / 3);
			g2d.drawLine(x1, y1 + width * 2 / 3, x1 + width, y1 + width * 2 / 3);
		}

	}

	@Override
	public String toString() {
		return "TicTacToe [x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + "]";
	}

}
