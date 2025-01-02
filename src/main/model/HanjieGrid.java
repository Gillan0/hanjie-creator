package main.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Grid containing a Hanjie Design. Expected values are -1 (white square) and 1 (black square).
 */
public class HanjieGrid extends Grid {
	
	/**
	 * Constructor to create a HanjieGrid. Default is a 25 pixel side long square.
	 */
	public HanjieGrid() {
		this(25);
	}
	
	/**
	 * Constructor to create a square HanjieGrid of side s.
	 * 
	 * @param s Number of pixels on the side
	 */
	public HanjieGrid(int s) {
		this(s, s);
	}

	/**
	 * Constructor to create a rectangular HanjieGrid.
	 * 
	 * @param height Index of pixels high
	 * @param width  Index of pixels long
	 */
	public HanjieGrid(int height, int width) {
		this.height = height;
		this.width = width;
		
		// Fill the grid with 0
		grid = new Integer[height][width];
		for (int i = 0 ; i < height ; i++) {
			for (int j = 0; j < width ; j++) {
				grid[i][j] = -1;
			}
		}
	}
	
	/**
	 * Get the description for Hanjie puzzle of the chosen line.
	 * 
	 * @param n Index of chosen line
	 * @return List of Integers describing the line per the Hanjie rules
	 * @throws GridHeightException Raised when line n not in table 
	 */
	public List<Integer> getLineDescription(int n) throws GridHeightException {	
		checkGridHeightException(n);
		
		List<Integer> line = getLine(n);
		ArrayList<Integer> description = new ArrayList<>();
		
		// Count the amount of following black squares
		int count = 0;
		for (int i = 0; i < width; i++ ) {
			if (line.get(i) == 1) {
				count++;
			} else if (count != 0) {
				description.add(count);
				count = 0;
			}
		}
		
		if (count != 0) {
	        description.add(count);
	    }
		
		return description;
	}
	
	/**
	 * Get the description for Hanjie puzzle of the chosen column.
	 * 
	 * @param n Index of chosen column
	 * @return List of Integers describing the column per the Hanjie rules
	 * @throws GridWidthException Raised when column n not in table 
	 */
	public List<Integer> getColumnDescription(int n) throws GridWidthException {
		checkGridWidthException(n);
		
		List<Integer> column = getColumn(n);		
		ArrayList<Integer> description = new ArrayList<>();
		// Count the amount of following black squares
		int count = 0;
		for (int i = 0; i < height; i++ ) {
			if (column.get(i) == 1) {
				count++;
			} else if (count != 0) {
				description.add(count);
				count = 0;
			}
		}
		
		if (count != 0) {
	        description.add(count);
	    }

		return description;
	}
	
	/**
	 * Changes a black square to a white one and vice-versa.
	 * 
	 * @param i Index of the chosen line
	 * @param j Index of the chosen column
	 * @throws GridHeightException Raised when line i not in table
	 * @throws GridWidthException Raised when column j not in table
	 */
	public void toggleElement(int i, int j) throws GridHeightException, GridWidthException {
		checkGridHeightException(i);
		checkGridWidthException(j);
		grid[i][j] = -grid[i][j];
	}
	
}