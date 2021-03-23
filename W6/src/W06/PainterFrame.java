package W06;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PainterFrame extends JFrame implements ActionListener {

	private DrawPanel drawPanel;

	private JPanel actionPanel;
	
	private JButton clear;
	private JButton undo;
	private JButton redo;

	private JPanel shapePanel;
	
	private JButton randgen; // 亂數產生按鈕
	private JButton rect;
	private JButton oval;
	
	private JButton colorBtn;
	private Icon colorIcon;
	private Color color;
	
	private JPanel buttonPanel;

	public PainterFrame() {

		super();
		buttonPanel = new JPanel();
		drawPanel = new DrawPanel();
		add(drawPanel, BorderLayout.CENTER);

		actionPanel = new JPanel();

		clear = new JButton("Clear");
		actionPanel.add(clear);
		clear.addActionListener(this);

		undo = new JButton("Undo");
		actionPanel.add(undo);
		undo.addActionListener(this);

		redo = new JButton("Redo");
		actionPanel.add(redo);
		redo.addActionListener(this);

		//add(actionPanel, BorderLayout.NORTH);
		buttonPanel.add(actionPanel);
		
		shapePanel = new JPanel();

		randgen = new JButton(" Random ");
		randgen.addActionListener(this);
		shapePanel.add(randgen);

		rect = new JButton(" Rect ");
		rect.addActionListener(this);
		shapePanel.add(rect);

		oval = new JButton(" Oval ");
		oval.addActionListener(this);
		shapePanel.add(oval);

		colorIcon = new ImageIcon(getClass().getResource("color.png"));
		colorBtn = new JButton("Color", colorIcon);
		colorBtn.addActionListener(this);
		shapePanel.add(colorBtn);
		
		//add(shapePanel, BorderLayout.SOUTH);
		buttonPanel.add(shapePanel);
		
		add(buttonPanel, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == randgen) {// 從randgem呼叫資源，並在選擇完後repaint
			drawPanel.Randgen(100);

		} else if (e.getSource() == clear) {
			drawPanel.clear();
		}else if (e.getSource() == redo) {
			drawPanel.redo();
		}else if (e.getSource() == undo) {
			drawPanel.undo();
		}else if (e.getSource() == colorBtn) {
			color = JColorChooser.showDialog(PainterFrame.this, "Pick Color", color);
			colorBtn.setBackground(color);  
		}
	}

}
