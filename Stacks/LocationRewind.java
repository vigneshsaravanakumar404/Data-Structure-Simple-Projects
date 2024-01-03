import java.util.Stack;

import javax.security.auth.x500.X500Principal;

import java.util.Scanner;

public class LocationRewind {

	private char[][] grid;
	private Stack<Location> locs;

	public LocationRewind() {

		Scanner reader = new Scanner(System.in);
		locs = new Stack<Location>();
		grid = new char[10][20];
		fillBlank();
		String response = "";
		while (!response.equalsIgnoreCase("q")) {
			print();
			System.out.print("Type X for new random X, R to rewind, Q to quit: ");
			response = reader.nextLine();
			if (response.equalsIgnoreCase("X"))
				randomX();
			if (response.equalsIgnoreCase("R")) {
				rewind(); // Does nothing yet, you will complete this method
			}
		}

		reader.close();

	}

	public void randomX() {

		int r = (int) (Math.random() * grid.length);
		int c = (int) (Math.random() * grid[0].length);
		grid[r][c] = 'X';
		locs.push(new Location(r, c));
	}

	public void rewind() {

		try {
			locs.pop();
			Location last = locs.peek();
			grid[last.getX()][last.getY()] = '_';
			System.out.println("REWIND STUB ");
		} catch (Exception e) {
			System.out.println("No more X's to rewind");
		}

	}

	public void fillBlank() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++)
				grid[i][j] = '_';
		}
	}

	public void print() {

		System.out.print("\033[H\033[2J");
		System.out.flush();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++)
				System.out.print(grid[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new LocationRewind();
	}
}