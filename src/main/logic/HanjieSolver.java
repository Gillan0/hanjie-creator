package main.logic;

import java.util.ArrayList;
import java.util.Arrays;
import main.logic.model.Grid;
import main.logic.model.HanjieGrid;

public class HanjieSolver {

	private HanjieGrid hanjieGrid;
	private Grid solveGrid;
	private ArrayList<AxisArray> axisArrays;
	
	public HanjieSolver(HanjieGrid h) throws Exception {
		hanjieGrid = h;
		solveGrid = new Grid(h.getHeight());
		axisArrays = new ArrayList<AxisArray>();
	
		convertToAxisArray();
		solve(0);
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
	
	private void solve(int NB_LOOP) throws Exception {
		if (NB_LOOP >= 150 || axisArrays.size() <= 0) {
			return;
		}
		AxisArray a = axisArrays.getFirst();
		if (a instanceof LineArray) {
			a.setContent(solveGrid.getLine(a.getIndex()));
		} else {
			a.setContent(solveGrid.getColumn(a.getIndex()));
		}
		a.updatePossibilities();
		
		ArrayList<Integer> commonElements = PossibilityManager.checkCommonElements(a.getPossibilities());
		
		a.setContent(commonElements);
		
		axisArrays.removeFirst();
		if (!a.isComplete()) {
			a.computeHuristic();
			axisArrays.add(a);
		}
		axisArrays.sort((AxisArray e1, AxisArray e2) -> Double.compare(e1.getHeuristic(), e2.getHeuristic()));

		
		a.updateGrid(solveGrid);
		System.out.println(solveGrid.toString());
		solve(NB_LOOP + 1);
	}
	
	
	
	public static void main(String[] args) throws Exception {
		HanjieGrid h = new HanjieGrid(10);
		
		/* h Figure
		 * 
		 *        x x
		 *      x x x x
		 *    x x x x x x
		 *      x x x x
		 *    x x x x x x
		 *  x x x x x x x x 
		 *        x x   
		 *        x x
		 * 
		 */
		
		h.setLine(0, new ArrayList<Integer>(Arrays.asList(-1,-1,-1,-1,-1,-1,-1,-1,-1,-1)));
		h.setLine(1, new ArrayList<Integer>(Arrays.asList(-1,-1,-1,-1,1,1,-1,-1,-1,-1)));
		h.setLine(2, new ArrayList<Integer>(Arrays.asList(-1,-1,-1,1,1,1,1,-1,-1,-1)));
		h.setLine(3, new ArrayList<Integer>(Arrays.asList(-1,-1,1,1,1,1,1,1,-1,-1)));
		h.setLine(4, new ArrayList<Integer>(Arrays.asList(-1,-1,-1,1,1,1,1,-1,-1,-1)));
		h.setLine(5, new ArrayList<Integer>(Arrays.asList(-1,-1,1,1,1,1,1,1,-1,-1)));
		h.setLine(6, new ArrayList<Integer>(Arrays.asList(-1,1,1,1,1,1,1,1,1,-1)));
		h.setLine(7, new ArrayList<Integer>(Arrays.asList(-1,-1,-1,-1,1,1,-1,-1,-1,-1)));
		h.setLine(8, new ArrayList<Integer>(Arrays.asList(-1,-1,-1,-1,1,1,-1,-1,-1,-1)));
		h.setLine(9, new ArrayList<Integer>(Arrays.asList(-1,-1,-1,-1,-1,-1,-1,-1,-1,-1)));

		HanjieSolver solver = new HanjieSolver(h);
	}
	
	
}