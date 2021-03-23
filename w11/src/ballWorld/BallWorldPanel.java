package ballWorld;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

/**
 * The control logic and main display panel for game.
 */
public class BallWorldPanel extends JPanel implements ActionListener {
	private static final int UPDATE_RATE = 30; // Frames per second (fps)

//   vtri = new JButton("Vtri");
//	setGridBagConstraints(0,1,1,1,true);
//	shapePanel.add(vtri, gbc);
//	vtri.addActionListener(this);

	private JButton stop;
	private JButton resume;
	private JPanel bottomPanel;

	// private Ball ball; // A single bouncing Ball's instance
	private ContainerBox box; // The container rectangular box
	// private Ball ball2;

	private DrawCanvas canvas; // Custom canvas for drawing the box/ball
	private int canvasWidth;
	private int canvasHeight;
	volatile boolean suspend = false;
	// volatile boolean start = false;

	Ball[] balls;

	final int MAX = 100;

	Thread gameThread;

	/**
	 * Constructor to create the UI components and init the game objects. Set the
	 * drawing canvas to fill the screen (given its width and height).
	 * 
	 * @param width  : screen width
	 * @param height : screen height
	 */
	public BallWorldPanel(int width, int height) {
		balls = new Ball[MAX];
		canvasWidth = width;
		canvasHeight = height;

		// Init the ball at a random location (inside the box) and moveAngle
		Random rand = new Random();
		int radius = 50;
		int x = rand.nextInt(canvasWidth - radius * 2 - 20) + radius + 10;
		int y = rand.nextInt(canvasHeight - radius * 2 - 20) + radius + 10;
		int speed = 5;
		int angleInDegree = rand.nextInt(360);

		for (int i = 0; i < 10; i++) {
			radius = rand.nextInt(100) + 50;
			x = rand.nextInt(canvasWidth - radius * 2 - 20) + radius + 10;
			y = rand.nextInt(canvasHeight - radius * 2 - 20) + radius + 10;
			speed = 5;
			angleInDegree = rand.nextInt(360);
			Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));

			balls[i] = new Ball(x, y, radius, speed, angleInDegree, color);
		}

//		balls[0] = new Ball(x, y, radius, speed, angleInDegree, Color.BLUE);
//		balls[1] = new Ball(x, y, radius, speed, angleInDegree, Color.red);

		// Init the Container Box to fill the screen
		box = new ContainerBox(0, 0, canvasWidth, canvasHeight, Color.BLACK, Color.WHITE);

		// Init the custom drawing panel for drawing the game

		canvas = new DrawCanvas();
		this.setLayout(new BorderLayout());
		this.add(canvas, BorderLayout.CENTER);

		bottomPanel = new JPanel();

		stop = new JButton("STOP");
		bottomPanel.add(stop);
		stop.addActionListener(this);

		resume = new JButton("RESUME");
		bottomPanel.add(resume);
		resume.addActionListener(this);

		add(bottomPanel, BorderLayout.SOUTH);

		// Handling window resize.
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				Component c = (Component) e.getSource();
				Dimension dim = c.getSize();
				canvasWidth = dim.width;
				canvasHeight = dim.height;
				// Adjust the bounds of the container to fill the window
				box.set(0, 0, canvasWidth, canvasHeight);
			}
		});

		// Start the ball bouncing
		gameStart();
	}

	

	public BallWorldPanel() {
		// TODO Auto-generated constructor stub
	}



	/** Start the ball bouncing. */
	public void gameStart() {
		// Run the game logic in its own thread.
		Thread gameThread = new Thread() {
			public void run() {
				while (true) {
					// Execute one time-step for the game
					if (!suspend) {
						gameUpdate();
						// Refresh the display
						repaint();
						// Delay and give other thread a chance
						try {
							Thread.sleep(1000 / UPDATE_RATE);
						} catch (InterruptedException ex) {

						}
					}

				}
			}
		};
		gameThread.start(); // Invoke GaemThread.run()
	}

	/**
	 * One game time-step. Update the game objects, with proper collision detection
	 * and response.
	 */
	public void gameUpdate() {
		for (int i = 0; i < 10; i++) {
			balls[i].moveOneStepWithCollisionDetection(box);
		}

	}

	/** The custom drawing panel for the bouncing ball (inner class). */
	class DrawCanvas extends JPanel {
		/** Custom drawing codes */
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g); // Paint background
			// Draw the box and the ball
			box.draw(g);

			for (int i = 0; i < 10; i++) {
				balls[i].draw(g);
			}
//			balls[0].draw(g);
//			balls[1].draw(g);
			//Display ball's information
			g.setColor(Color.WHITE);
			g.setFont(new Font("Courier New", Font.PLAIN, 12));
			g.drawString("Ball " + balls[0].toString(), 20, 30);
		}

		/** Called back to get the preferred size of the component. */
		@Override
		public Dimension getPreferredSize() {
			return (new Dimension(canvasWidth, canvasHeight));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == stop) {
			suspend = true;
		} else if (e.getSource() == resume) {
			suspend = false;
		}

	}

}