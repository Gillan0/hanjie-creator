package main.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.model.Grid;
import main.model.HanjieGrid;
import test.model.HanjieGridTemplates;

public class HanjieSolver {

	private HanjieGrid hanjieGrid;
	private Grid solveGrid;
	private ArrayList<AxisArray> axisArrays;
	
	public HanjieSolver(HanjieGrid h) throws Exception {
		hanjieGrid = h;
		solveGrid = new Grid(h.getHeight());
		axisArrays = new ArrayList<>();
	
		convertToAxisArray();
	}
	
	private void convertToAxisArray() throws Exception {		
		for (int i=0; i < hanjieGrid.getWidth(); i++) {
			axisArrays.add(new LineArray(solveGrid.getLine(i), hanjieGrid.getLineDescription(i), i));
		}
		for (int i=0; i < hanjieGrid.getHeight(); i++) {
			axisArrays.add(new ColumnArray(solveGrid.getColumn(i), hanjieGrid.getColumnDescription(i), i));
		}
		axisArrays.sort((AxisArray e1, AxisArray e2) -> Double.compare(e1.getHeuristic(), e2.getHeuristic()));
	}
	
	public boolean solve() {
		boolean result = false;
		
		try {
			solveRecursive(0, result);
		} catch (Exception e) {
			System.out.println("Couldn't be solved");
			System.out.println(solveGrid);
		}
	
		return result;
	}
	
	private void solveRecursive(int nbLoop, boolean isSolvable) throws Exception {
		if (hanjieGrid.equals(solveGrid) || axisArrays.isEmpty()) {
			isSolvable = true;
			System.out.println("Solved in " + nbLoop + " steps");
			System.out.println(solveGrid);
			return;
		}
		if (nbLoop >= 1000) {
			isSolvable = false;
			System.out.println("Couldn't be solved");
			System.out.println(solveGrid);
			return;
		}

		AxisArray a = axisArrays.getFirst();
		
		if (a instanceof LineArray) {
			a.setContent(solveGrid.getLine(a.getIndex()));
		} else {
			a.setContent(solveGrid.getColumn(a.getIndex()));
		}
		a.updatePossibilities();
		
		List<Integer> commonElements = PossibilityManager.checkCommonElements(a.getPossibilities());
		
		a.setContent(commonElements);
		
		axisArrays.removeFirst();
		if (!a.isComplete()) {
			a.computeHuristic();
			axisArrays.add(a);
		}
		axisArrays.sort((AxisArray e1, AxisArray e2) -> Double.compare(e2.getHeuristic(), e1.getHeuristic()));

		
		a.updateGrid(solveGrid);
		solveRecursive(nbLoop + 1, isSolvable);
	}
	
	
	public static void main(String[] args) throws Exception {
		HanjieGrid h = HanjieGridTemplates.buildBreizhHanjieGrid();
		HanjieSolver solver = new HanjieSolver(h);
		solver.solve();
	}
	
	
}