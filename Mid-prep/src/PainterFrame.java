import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PainterFrame extends JFrame implements ActionListener, ItemListener {

	public final static Color purple = new Color(128, 0, 128);

	private drawPanel drawPanel;
	private JPanel actionPanel;
	private JButton clear;
	private JButton undo;
	private JButton redo;
	private JButton ColorReset;

	private JPanel shapePanel;
	private GridBagConstraints gbc;
	private JButton rect;
	private JButton oval;
	private JButton Square3;
	private JButton Circle3;
	private JButton TicTacToe;
	private JButton Flag3;
	private JButton Cross; // °é°é©Î¤e¤e
	
	private Icon colorIcon;

	private JCheckBox filled;
	private JCheckBox gradient;

	private JButton colorBtn1;
	private JButton colorBtn2;
	private JButton colorBtn3;
	private Color color;
	private Color color2;
	private Color color3;

	private int numTypes = 5;
	final int FLAG3 = 1;
	final int CIRCLE3 = 2;
	final int TICTACTOE = 3;
	final int RECT = 4;
	final int CROSS = 5; 
	final int OVAL = 6;
	
	void setGridBagConstraints(int x, int y, int h, int w, boolean fill) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridheight = h;
		gbc.gridwidth = w;
		if (fill)
			gbc.fill = GridBagConstraints.BOTH;
	}

	public PainterFrame() {
		super();

		drawPanel = new drawPanel();
		actionPanel = new JPanel();
		add(drawPanel, BorderLayout.CENTER);

		// add(shapePanal , BorderLayout.NORTH);

		clear = new JButton("Clear");
		actionPanel.add(clear);
		clear.addActionListener(this);

		undo = new JButton("Undo");
		actionPanel.add(undo);
		undo.addActionListener(this);

		redo = new JButton("Redo");
		actionPanel.add(redo);
		redo.addActionListener(this);

		add(actionPanel, BorderLayout.SOUTH);

		shapePanel = new JPanel(new GridBagLayout());
		gbc = new GridBagConstraints();
		add(shapePanel, BorderLayout.NORTH);

		ColorReset = new JButton("ColorReset");
		setGridBagConstraints(0, 0, 2, 1, true);
		shapePanel.add(ColorReset, gbc);
		ColorReset.addActionListener(this);

		colorIcon = new ImageIcon(getClass().getResource("color.png"));
		colorBtn1 = new JButton("C1", colorIcon);
		colorBtn1.setBackground(Color.BLUE);
		setGridBagConstraints(1, 0, 2, 1, true);
		shapePanel.add(colorBtn1, gbc);
		colorBtn1.addActionListener(this);

		colorBtn2 = new JButton("C2", colorIcon);
		colorBtn2.setBackground(purple);
		setGridBagConstraints(2, 0, 2, 1, true);
		shapePanel.add(colorBtn2, gbc);
		colorBtn2.addActionListener(this);

		colorBtn3 = new JButton("C3", colorIcon);
		colorBtn3.setBackground(Color.GREEN);
		setGridBagConstraints(3, 0, 2, 1, true);
		shapePanel.add(colorBtn3, gbc);
		colorBtn3.addActionListener(this);

		filled = new JCheckBox("Filled", false);
		setGridBagConstraints(4, 0, 1, 1, true);
		shapePanel.add(filled, gbc);
		filled.addItemListener(this);

		gradient = new JCheckBox("Gradient", false);
		setGridBagConstraints(4, 1, 1, 1, true);
		shapePanel.add(gradient, gbc);
		gradient.addItemListener(this);

		Square3 = new JButton("Square3");
		setGridBagConstraints(5, 0, 1, 1, true);
		shapePanel.add(Square3, gbc);
		Square3.addActionListener(this);

		Circle3 = new JButton("Circle3");
		setGridBagConstraints(5, 1, 1, 1, true);
		shapePanel.add(Circle3, gbc);
		Circle3.addActionListener(this);

		rect = new JButton("Rect");
		setGridBagConstraints(6, 0, 1, 1, true);
		shapePanel.add(rect, gbc);
		rect.addActionListener(this);

		oval = new JButton("Oval");
		setGridBagConstraints(6, 1, 1, 1, true);
		shapePanel.add(oval, gbc);
		oval.addActionListener(this);

		TicTacToe = new JButton("TicTacToe");
		setGridBagConstraints(7, 0, 1, 1, true);
		shapePanel.add(TicTacToe, gbc);
		TicTacToe.addActionListener(this);

		Flag3 = new JButton("Flag3");
		setGridBagConstraints(7, 1, 1, 1, true);
		shapePanel.add(Flag3, gbc);
		Flag3.addActionListener(this);
		
		Cross = new JButton("Cross");
		setGridBagConstraints(8, 0, 2, 1, true);
		shapePanel.add(Cross, gbc);
		Cross.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ColorReset) {
			colorBtn1.setBackground(Color.BLUE);
			colorBtn2.setBackground(purple);
			colorBtn3.setBackground(Color.GREEN);
		} else if (e.getSource() == colorBtn1) {
			color = JColorChooser.showDialog(PainterFrame.this, "Pick Color", color);
			colorBtn1.setBackground(color);
			drawPanel.setColor(color);
		} else if (e.getSource() == TicTacToe) {
			drawPanel.setType(TICTACTOE);
		} else if (e.getSource() == Flag3) {
			drawPanel.setType(FLAG3);
		} else if (e.getSource() == Circle3) {
			drawPanel.setType(CIRCLE3);
		} else if (e.getSource() == colorBtn2) {
			color2 = JColorChooser.showDialog(PainterFrame.this, "Pick Color", color2);
			colorBtn2.setBackground(color2);
			drawPanel.setColor2(color2);
		} else if (e.getSource() == colorBtn3) {
			color3 = JColorChooser.showDialog(PainterFrame.this, "Pick Color", color3);
			colorBtn3.setBackground(color3);
			drawPanel.setColor3(color3);
		} else if (e.getSource() == clear) {
			drawPanel.clear();
		} else if (e.getSource() == undo) {
			drawPanel.undo();
		} else if (e.getSource() == redo) {
			drawPanel.redo();
		}else if(e.getSource() == Cross) {
			drawPanel.setType(CROSS);
		}else if (e.getSource() == rect) {
			drawPanel.setType(RECT);
		}else if(e.getSource() == oval) {
			drawPanel.setType(OVAL);
		}
	}
	
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == filled) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				drawPanel.setFilled(true);
			} else {
				drawPanel.setFilled(false);
			}
		}

		if (e.getSource() == gradient) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				drawPanel.setGradient(true);
			} else {
				drawPanel.setGradient(false);
			}
		}

	}

}
