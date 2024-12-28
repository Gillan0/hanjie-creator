package main.logic;

import java.util.List;

import main.model.Grid;
import main.model.GridHeightException;
import main.model.GridWidthException;

public class ColumnArray extends AxisArray {

	public ColumnArray(List<Integer> content, List<Integer> description, int index) {
		super(content, description, index);
	}

	public void updateGrid(Grid solveGrid) throws GridHeightException, GridWidthException  {

		solveGrid.setColumn(this.getIndex(), this.getContent());
	}
	
}
