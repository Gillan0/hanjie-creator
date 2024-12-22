package main.logic;

import java.util.ArrayList;

import main.logic.model.Grid;
import main.logic.model.GridHeightException;

public class LineArray extends AxisArray {

	public LineArray(ArrayList<Integer> content, ArrayList<Integer> description, int index) {
		super(content, description, index);
		// TODO Auto-generated constructor stub
	}
	
	public void updateGrid(Grid solveGrid) throws Exception {
		solveGrid.setLine(index, content);
	}

}
