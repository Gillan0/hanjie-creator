package main.logic.model;

import java.util.ArrayList;
import java.util.List;

public class Grid {

	protected Integer[][] grid; 
	protected int length;
	protected int width;
	
	public Grid() {
		this(25);
	}
	
	public Grid(int s) {
		this(s, s);
	}

	public Grid(int length, int width) {
		this.length = length;
		this.width = width;
		
		grid = new Integer[length][width];
		for (int i = 0 ; i < length ; i++) {
			for (int j = 0; j < width ; j++) {
				grid[i][j] = 0;
			}
		}
	}

	public Integer getElement(int i, int j) throws GridLengthException, GridWidthException {
		checkGridLengthException(i);
		checkGridWidthException(j);
		
		return grid[i][j];
	}
	
	public void setElement(int i, int j, int value) throws GridLengthException, GridWidthException {
		checkGridLengthException(i);
		checkGridWidthException(j);
		
		grid[i][j] = value;
	}
	
	public void setLine(int i, Integer[] value) throws GridLengthException {
		checkGridLengthException(i);
		
		grid[i] = value;
	}
	
	public int getLength() {
		return length;
	}
	
	public int getWidth() {
		return width;
	}
	
	public String getGrid() {
		return grid.toString();
	}
	
 	public ArrayList<Integer> getLine(int n) throws GridLengthException {
		checkGridLengthException(n);
		ArrayList<Integer> line = new ArrayList<Integer>();
		for (int i = 0; i < length; i++) {
			line.add(grid[n][i]);	
		}
		return line;
	}
	
	public ArrayList<Integer> getColumn(int n) throws GridWidthException {
		checkGridWidthException(n);
		ArrayList<Integer> line = new ArrayList<Integer>();
		for (int i = 0; i < length; i++) {
			line.add(grid[i][n]);	
		}
		return line;
	}
	
	/**
	 * WIP - NOT FINISHED
	 */
	public String toString() {
		String description = "";
		
		for (int i = 0; i < length ; i++) {
			description += "####";
		}
		
		for (int i = 0; i < length ; i++) {
		
			for (int j = 0; i < width ; i++) {
				try {
					description += "# " + this.getElement(i, j).toString() + " ";
				} catch (GridLengthException | GridWidthException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
			
		return description;
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof Grid)) {
			return false;
		}
		Grid h = (Grid) o;
		if (length != h.getLength() || width != h.getWidth()) {
			return false;
		}
		
		for (int i = 0; i < length ; i++) {
			for (int j = 0; j < width ; j++) {
				try {
					if (!(getElement(i,j) == h.getElement(i, j))) {
						return false;
					}
				} catch (GridLengthException | GridWidthException e) {
					e.printStackTrace();
				}
			}
		}
		
		return true;
	}
		
	protected void checkGridLengthException(int n) throws GridLengthException {
		if (n >= length) {
			throw new GridLengthException("Line Index out of bounds");
		}
	}
	
	protected void checkGridWidthException(int n) throws GridWidthException {
		if (n >= width) {
			throw new GridWidthException("Column Index out of bounds");
		}
	}

}
