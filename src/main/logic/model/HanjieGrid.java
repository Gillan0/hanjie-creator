package main.logic.model;

import java.util.ArrayList;
import java.util.List;

public class HanjieGrid extends Grid {
	
	public HanjieGrid() {
		super(25);
	}
	
	public HanjieGrid(int s) {
		super(s, s);
	}

	public HanjieGrid(int height, int width) {
		super(height, width);
	}
	
	public ArrayList<Integer> getLineDescription(int n) throws GridHeightException {	
		checkGridHeightException(n);
		
		ArrayList<Integer> line = getLine(n);
		ArrayList<Integer> description = new ArrayList<Integer>();
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
	
	public ArrayList<Integer> getColumnDescription(int n) throws GridWidthException {
		checkGridWidthException(n);
		
		ArrayList<Integer> column = getColumn(n);		
		ArrayList<Integer> description = new ArrayList<Integer>();
		
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
	
	public void toggleElement(int i, int j) throws GridHeightException, GridWidthException {
		checkGridHeightException(i);
		checkGridWidthException(j);
		grid[i][j] = -grid[i][j];
		
	}
	
}