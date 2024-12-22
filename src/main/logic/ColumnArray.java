package main.logic;

import java.util.ArrayList;

import main.logic.model.Grid;

public class ColumnArray extends AxisArray {

	public ColumnArray(ArrayList<Integer> content, ArrayList<Integer> description, int index) {
		super(content, description, index);
		// TODO Auto-generated constructor stub
	}

	public void updateGrid(Grid solveGrid) throws Exception {

		solveGrid.setColumn(this.getIndex(), this.getContent());
	}
	
}
