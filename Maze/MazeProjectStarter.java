
// Planning Document: https://docs.google.com/document/d/1dufhUD82mlUIdbwCK6SsGjpbT6wpN2yvbTwExrpknxU/edit#heading=h.w4876d7fbz4z
// Rubric: https://docs.google.com/document/d/1Mh1c2kgGWCqwbN1J-Ac40Enl5OJVPP6XJz0VJcx8FWc/edit
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.awt.image.*;
import java.awt.geom.AffineTransform;

public class MazeProjectStarter extends JPanel implements KeyListener, ActionListener {

	// Instance variables
	private JFrame frame;
	private int size = 30, width = 1500, height = 1000, currentLevel = 0;
	private char[][] maze;
	private Timer t;
	private Explorer explorer;
	private Location startLocation;
	private boolean is3DView = false;
	private ArrayList<Monster> monsters = new ArrayList<>();

	// Constructor
	public MazeProjectStarter() {
		// Maze variables
		setBoard(currentLevel);
		frame = new JFrame("A-Mazing Program");
		frame.setSize(width, height);
		frame.add(this);
		frame.addKeyListener(this);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		explorer = new Explorer(startLocation, size, "explorer.png");
		t = new Timer(10, this);
		t.start();
		repaint();
	}

	// Graphics
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (is3DView) {
			drawMaze3D(g);
		} else {
			drawMaze2D(g, monsters); // Use the class member monsters list
		}
	}

	/*
	 * KeyListener methods
	 */
	public void keyPressed(KeyEvent e) {

		// Move the explorer
		int key = e.getKeyCode();
		explorer.move(key, maze);
		Location newLoc = explorer.getLoc();

		// Toggle 3D view
		if (key == KeyEvent.VK_SPACE) {
			is3DView = !is3DView;
			repaint();
		}

		// Check if explorer lands on the end point ('E')
		if (maze[newLoc.getX()][newLoc.getY()] == 'E') {

			// Move the explorer to the end point
			explorer.setLoc(newLoc);
			repaint();
			currentLevel++;

			// Next level dialog
			try {
				int dialogResult = JOptionPane.showConfirmDialog(frame,
						"Great Job! Do you want to go to the next level?", "Next Level", JOptionPane.YES_NO_OPTION);

				if (dialogResult == JOptionPane.YES_OPTION) {
					explorer.setLoc(new Location(0, 0));
					repaint();
					setBoard(currentLevel);
					explorer.resetMoveCount();
					explorer.setLoc(startLocation);
				} else {
					JOptionPane.showMessageDialog(frame, "Congratulations, you've completed all available mazes!");
					t.stop();
					Thread.sleep(1000);
					System.exit(0);
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(frame, "Congratulations, you've completed all available mazes!");
				t.stop();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
			}
		}

		repaint();
	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == 27) {
			System.exit(0);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Timer Triggered");
		for (Monster monster : monsters) {
			System.out.println("Monster's current position: " + monster.getX() + ", " + monster.getY());
			monster.move(maze);
		}
		repaint();
	}

	// Reads the maze file and stores it as a 2D array
	public void setBoard(int level) {
		String fileName = "maze" + level + ".txt";
		try {
			// Read the file
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			ArrayList<String> lines = new ArrayList<>();
			String line;

			while ((line = br.readLine()) != null) {
				lines.add(line);
			}

			// Store as a 2D array
			int rows = lines.size();
			int cols = lines.get(0).length();
			maze = new char[rows][cols];

			// Clear any existing monsters when a new board is set
			monsters.clear();

			// Identify the points of interest
			int startX = -1, startY = -1;
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					maze[r][c] = lines.get(r).charAt(c);

					if (maze[r][c] == 'S') { // Find the starting point
						startX = r;
						startY = c;
						startLocation = new Location(startX, startY); // Store it
					}
					// Create monsters based on their initial direction and add to the list
					else if (maze[r][c] == 'R' || maze[r][c] == 'L' || maze[r][c] == 'U' || maze[r][c] == 'D') {
						Monster monster = new Monster(new Location(r, c), size, "monster.png", maze[r][c]);
						monsters.add(monster);
					}
				}
			}

			br.close();

			// Initialize the explorer at the starting point
			if (startX != -1 && startY != -1) {
				explorer = new Explorer(new Location(startX, startY), size, "explorer.png");
			} else {
				throw new IllegalArgumentException("No starting point ('S') found in the maze file.");
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + fileName);
		} catch (IOException e) {
			System.out.println("An error occurred while reading the file.");
		}
	}

	// Draws the maze in 2D
	public void drawMaze2D(Graphics g, ArrayList<Monster> monsters) {

		// Draw the maze
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, frame.getWidth(), frame.getHeight());

		for (int r = 0; r < maze.length; r++) {
			for (int c = 0; c < maze[0].length; c++) {
				if (maze[r][c] == '#') {
					g2.setColor(Color.GRAY);
					g2.fillRect(c * size, r * size, size, size); // Wall
				} else if (maze[r][c] == 'S') {
					g2.setColor(Color.decode("#66FF66"));
					g2.fillRect(c * size, r * size, size, size); // Start
				} else if (maze[r][c] == 'E') { // End
					g2.setColor(Color.decode("#FFFF66"));
					g2.fillRect(c * size, r * size, size, size); // End
				}
				// Draw gridlines
				g2.setColor(Color.gray);
				g2.drawRect(c * size, r * size, size, size);
			}
		}

		// Draw the explorer
		if (explorer != null && explorer.getImg() != null) {
			BufferedImage img = explorer.getImg();
			Location loc = explorer.getLoc();

			char orientation = explorer.getOrientation(); // getOrientation() should return 'N', 'S', 'E', or 'W'

			// Rotate the image based on orientation
			double angle = 0.0;
			switch (orientation) {
				case 'N':
					angle = -Math.PI / 2;
					break;
				case 'S':
					angle = Math.PI - Math.PI / 2;
					break;
				case 'E':
					angle = Math.PI / 2 - Math.PI / 2;
					break;
				case 'W':
					angle = -Math.PI / 2 - Math.PI / 2;
					break;
			}
			// Rotate the image
			AffineTransform tx = AffineTransform.getRotateInstance(angle, img.getWidth() / 2.0,
					img.getHeight() / 2.0);
			AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
			img = op.filter(img, null);

			int drawX = loc.getY() * size;
			int drawY = loc.getX() * size;

			int adjustedX = drawX - (size / 2);
			int adjustedY = drawY - (size / 2);

			g2.drawImage(img, adjustedX, adjustedY, size * 2, size * 2, null); // size * 2 to make it twice as large
		}

		// Draw the monsters
		for (Monster monster : monsters) {
			BufferedImage monsterImg = monster.getImg();
			if (monsterImg != null) {
				Location monsterLoc = monster.getLoc();
				int monsterX = monsterLoc.getY() * size;
				int monsterY = monsterLoc.getX() * size;

				g2.drawImage(monsterImg, monsterX, monsterY, size, size, null);

			}
		}

		// Display move count at bottom of page
		int hor = size;
		int vert = maze.length * size + 2 * size;
		g2.setFont(new Font("Arial", Font.BOLD, 20));
		g2.setColor(Color.PINK);
		g2.drawString("Moves: " + explorer.getMoveCount(), hor, vert); // Using explorer.getMoveCount()
	}

	// Draws the maze in 3D
	public void drawMaze3D(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, frame.getWidth(), frame.getHeight()); // Background

		int offsetX = 100; // Perspective offset x
		int offsetY = 100; // Perspective offset y

		// Loop through the maze to draw walls, start, and end points.
		for (int r = 0; r < maze.length; r++) {
			for (int c = 0; c < maze[0].length; c++) {
				int x = c * size;
				int y = r * size;

				// Draw Walls as trapezoids for a simple 3D effect.
				if (maze[r][c] == '#') {
					int[] xPoints = { x, x + size, x + size + offsetX, x + offsetX };
					int[] yPoints = { y, y, y + size + offsetY, y + offsetY };
					g2d.setColor(Color.GRAY);
					g2d.fillPolygon(xPoints, yPoints, 4);
				} else if (maze[r][c] == 'S') {
					g2d.setColor(Color.decode("#66FF66"));
					g2d.fillRect(x + offsetX, y + offsetY, size, size); // Start
				} else if (maze[r][c] == 'E') {
					g2d.setColor(Color.decode("#FFFF66"));
					g2d.fillRect(x + offsetX, y + offsetY, size, size); // End
				}
			}
		}

		// Draw the explorer
		if (explorer != null && explorer.getImg() != null) {
			BufferedImage img = explorer.getImg();
			Location loc = explorer.getLoc();

			char orientation = explorer.getOrientation(); // getOrientation() should return 'N', 'S', 'E', or 'W'

			// Rotate the image based on orientation
			double angle = 0.0;
			switch (orientation) {
				case 'N':
					angle = -Math.PI / 2;
					break;
				case 'S':
					angle = Math.PI - Math.PI / 2;
					break;
				case 'E':
					angle = Math.PI / 2 - Math.PI / 2;
					break;
				case 'W':
					angle = -Math.PI / 2 - Math.PI / 2;
					break;
			}
			// Rotate the image
			AffineTransform tx = AffineTransform.getRotateInstance(angle, img.getWidth() / 2.0,
					img.getHeight() / 2.0);
			AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
			img = op.filter(img, null);

			int drawX = loc.getY() * size;
			int drawY = loc.getX() * size;

			int adjustedX = drawX - (size / 2);
			int adjustedY = drawY - (size / 2);

			g2d.drawImage(img, adjustedX, adjustedY, size * 2, size * 2, null); // size * 2 to make it twice as large
		}

		// Display move count at bottom of page
		int hor = size;
		int vert = maze.length * size + 2 * size;
		g2d.setFont(new Font("Arial", Font.BOLD, 20));
		g2d.setColor(Color.PINK);
		g2d.drawString("Moves: " + explorer.getMoveCount(), hor, vert); // Using explorer.getMoveCount()
	}

	public static void main(String[] args) {
		MazeProjectStarter app = new MazeProjectStarter();
		app.setFocusable(true);
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = env.getDefaultScreenDevice();
		device.setFullScreenWindow(app.frame);
	}
}