package main.logic;

import java.util.List;

import main.model.Grid;
import main.model.GridHeightException;
import main.model.GridWidthException;

public class LineArray extends AxisArray {

	public LineArray(List<Integer> content, List<Integer> description, int index) {
		super(content, description, index);
	}
	
	public void updateGrid(Grid solveGrid) throws GridHeightException, GridWidthException {
		solveGrid.setLine(index, content);
	}

}
