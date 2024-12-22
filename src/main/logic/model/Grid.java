package main.logic.model;

import java.util.ArrayList;
import java.util.List;

public class Grid {

	protected Integer[][] grid; 
	protected int height;
	protected int width;
	
	public Grid() {
		this(25);
	}
	
	public Grid(int s) {
		this(s, s);
	}

	public Grid(int height, int width) {
		this.height = height;
		this.width = width;
		
		grid = new Integer[height][width];
		for (int i = 0 ; i < height ; i++) {
			for (int j = 0; j < width ; j++) {
				grid[i][j] = 0;
			}
		}
	}

	public Integer getElement(int i, int j) throws GridHeightException, GridWidthException {
		checkGridHeightException(i);
		checkGridWidthException(j);
		
		return grid[i][j];
	}
	
	public void setElement(int i, int j, int value) throws GridHeightException, GridWidthException {
		checkGridHeightException(i);
		checkGridWidthException(j);
		
		grid[i][j] = value;
	}
	
	public void setLine(int i, ArrayList<Integer> value) throws GridHeightException {
		checkGridHeightException(i);
		
		for (int j = 0; j < width; j++) {
			grid[i][j] = value.get(j);
		}
	}
	
	public void setColumn(int j, ArrayList<Integer> value) throws GridWidthException {
		checkGridWidthException(j);
		
		for (int i = 0; i < height; i++) {
	        grid[i][j] = value.get(i);
	    }
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public String getGrid() {
		return grid.toString();
	}
	
 	public ArrayList<Integer> getLine(int n) throws GridHeightException {
		checkGridHeightException(n);
		ArrayList<Integer> line = new ArrayList<Integer>();
		for (int i = 0; i < height; i++) {
			line.add(grid[n][i]);	
		}
		return line;
	}
	
	public ArrayList<Integer> getColumn(int n) throws GridWidthException {
		checkGridWidthException(n);
		ArrayList<Integer> line = new ArrayList<Integer>();
		for (int i = 0; i < height; i++) {
			line.add(grid[i][n]);	
		}
		return line;
	}
	
	/**
	 * WIP - NOT FINISHED
	 */
	public String toString() {
		StringBuilder description = new StringBuilder();
	    
	    // Iterate through each row of the grid
	    for (int i = 0; i < height; i++) {
	        // Iterate through each column in the row
	        for (int j = 0; j < width; j++) {
	            try {
	                int element = this.getElement(i, j);
	                
	                // Conditionally add the correct string representation for -1, 0, and 1
	                if (element == -1) {
	                    description.append("_ ");  // or any other character for -1
	                } else if (element == 0) {
	                    description.append("O ");  // or any other character for 0
	                } else if (element == 1) {
	                    description.append("1 ");  // or any other character for 1
	                } else {
	                    description.append(element).append(" ");  // Default for other values
	                }
	            } catch (GridHeightException | GridWidthException e) {
	                // Handle exceptions (although this shouldn't occur in this context)
	                e.printStackTrace();
	            }
	        }
	        // Add a newline after each row for better formatting
	        description.append("\n");
	    }
	    return description.toString();
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof Grid)) {
			return false;
		}
		Grid h = (Grid) o;
		if (height != h.getHeight() || width != h.getWidth()) {
			return false;
		}
		
		for (int i = 0; i < height ; i++) {
			for (int j = 0; j < width ; j++) {
				try {
					if (!(getElement(i,j) == h.getElement(i, j))) {
						return false;
					}
				} catch (GridHeightException | GridWidthException e) {
					e.printStackTrace();
				}
			}
		}
		
		return true;
	}
		
	protected void checkGridHeightException(int n) throws GridHeightException {
		if (n >= height) {
			throw new GridHeightException("Line Index out of bounds");
		}
	}
	
	protected void checkGridWidthException(int n) throws GridWidthException {
		if (n >= width) {
			throw new GridWidthException("Column Index out of bounds");
		}
	}

}
