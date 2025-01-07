package main.model;

import java.util.ArrayList;
import java.util.List;

/**
 *  The Grid class represents a 2D grid of Integers. Here, expected values are -1 (white square) ; 0 (undefined square) ; 1 (black square).
 */
public class Grid {

	/**
	 * Content of the grid
	 */
	protected Integer[][] grid; 
	
	/**
	 * Number of lines of the grid
	 */
	protected int height;
	
	/**
	 * Number of columns of the grid
	 */
	protected int width;
	
	/**
	 * Constructor to create a Grid. Default is a 25 pixel side long square.
	 */
	public Grid() {
		this(25);
	}
	
	/**
	 * Constructor to create a square Grid of side s.
	 * 
	 * @param s Number of pixels on the side
	 */
	public Grid(int s) {
		this(s, s);
	}
	
	/**
	 * Constructor to create a rectangular Grid.
	 * 
	 * @param height Index of pixels high
	 * @param width  Index of pixels long
	 */
	public Grid(int height, int width) {
		this.height = height;
		this.width = width;
		
		// Fill the grid with 0
		grid = new Integer[height][width];
		for (int i = 0 ; i < height ; i++) {
			for (int j = 0; j < width ; j++) {
				grid[i][j] = 0;
			}
		}
	}

	/**
	 * Gets the element of the grid on line i and column j
	 * 
	 * @param i Index of the chosen line
	 * @param j Index of the chosen column
	 * @return Element at line i and column j
	 * @throws GridHeightException Raised when line i not in table
	 * @throws GridWidthException Raised when column j not in table
	 */
	public Integer getElement(int i, int j) throws GridHeightException, GridWidthException {
		checkGridHeightException(i);
		checkGridWidthException(j);
		return grid[i][j];
	}
	
	/**
	 * Sets a new element in the grid on line i and column j
	 * 
	 * @param i Index of the chosen line
	 * @param j Index of the chosen column
	 * @param value New element at line i and column j
	 * @throws GridHeightException Raised when line i not in table
	 * @throws GridWidthException Raised when column j not in table
	 */
	public void setElement(int i, int j, int value) throws GridHeightException, GridWidthException {
		checkGridHeightException(i);
		checkGridWidthException(j);
		
		grid[i][j] = value;
	}
	
	/**
	 * Get the number of lines of the grid
	 * @return Total number of lines of the grid
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Get the number of columns of the grid
	 * @return Total number of columns of the grid
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Gets the content of line n
	 * 
	 * @param n Index of the chosen line
	 * @throws GridHeightException Raised when line i not in table
	 * @return Line number n
	 */
 	public List<Integer> getLine(int n) throws GridHeightException {
		checkGridHeightException(n);
		ArrayList<Integer> line = new ArrayList<>();
		for (int i = 0; i < height; i++) {
			line.add(grid[n][i]);	
		}
		return line;
	}
	
 	/**
	 * Gets the content of column n
	 * 
	 * @param n Index of the chosen column
	 * @throws GridWidthException Raised when column j not in table
	 * @return Column number n
	 */
	public List<Integer> getColumn(int n) throws GridWidthException {
		checkGridWidthException(n);
		ArrayList<Integer> line = new ArrayList<>();
		for (int i = 0; i < height; i++) {
			line.add(grid[i][n]);	
		}
		return line;
	}
	
	/**
	 * Sets the content of line i
	 * 
	 * @param i Index of the chosen line
	 * @param value List of number to be put in the line
	 * @throws GridHeightException Raised when line i not in table
	 */
	public void setLine(int i, List<Integer> value) throws GridHeightException {
		checkGridHeightException(i);
		
		// Fill line
		for (int j = 0; j < width; j++) {
			grid[i][j] = value.get(j);
		}
	}
	
	/**
	 * Sets the content of column j
	 * 
	 * @param j Index of the chosen column
	 * @param value List of number to be put in the column
	 * @throws GridWidthException Raised when column j not in table
	 */
	public void setColumn(int j, List<Integer> value) throws GridWidthException {
		checkGridWidthException(j);
		
		for (int i = 0; i < height; i++) {
	        grid[i][j] = value.get(i);
	    }
	}
	
	/**
	 * Gives a visual representation of the grid
	 * @return String representing the grid
	 */
	public String toString() {
		StringBuilder description = new StringBuilder();
	    
	    for (int i = 0; i < height; i++) {
	        for (int j = 0; j < width; j++) {
	            try {
	                int element = this.getElement(i, j);
	                
	                if (element == -1) {
	                    description.append("_ ");  
	                } else if (element == 0) {
	                    description.append("O ");  
	                } else if (element == 1) {
	                    description.append("1 ");  
	                } else {
	                    description.append(element).append(" "); 
	                }
	            } catch (GridHeightException | GridWidthException e) {
	                // Shouldn't occur
	                e.printStackTrace();
	            }
	        }
	        description.append("\n");
	    }
	    return description.toString();
	}
	
	/**
	 * Checks if this object instance is equal to another object
	 * 
	 * @param o Another object
	 * @return boolean if this is equal to o
	 */
	public boolean equals(Object o) {
		// Compare type
		if (!(o instanceof Grid)) {
			return false;
		}
		
		// Compare Grid dimensions
		Grid h = (Grid) o;
		if (height != h.getHeight() || width != h.getWidth()) {
			return false;
		}
		
		// Compare Grid content
		for (int i = 0; i < height ; i++) {
			for (int j = 0; j < width ; j++) {
				try {
					if (getElement(i,j) != h.getElement(i, j)) {
						return false;
					}
				} catch (GridHeightException | GridWidthException e) {
					e.printStackTrace();
				}
			}
		}
		
		return true;
	}
		
	/**
	 * Checks if the chosen line index is in table
	 * 
	 * @param n Index of chosen line
	 * @throws GridHeightException
	 */
	protected void checkGridHeightException(int n) throws GridHeightException {
		if (n >= height) {
			throw new GridHeightException("Line Index out of bounds");
		}
	}
	
	/**
	 * Checks if the chosen column index is in table
	 * 
	 * @param n Index of chosen column
	 * @throws GridWidthException
	 */
	protected void checkGridWidthException(int n) throws GridWidthException {
		if (n >= width) {
			throw new GridWidthException("Column Index out of bounds");
		}
	}

}
