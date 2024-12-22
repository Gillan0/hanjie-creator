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
		if (NB_LOOP >= 1000 || axisArrays.size() <= 0) {
			return;
		}
		if (hanjieGrid.equals(solveGrid)) {
			System.out.println("Solved in " + NB_LOOP + " steps");
			return;
		}

		AxisArray a = axisArrays.getFirst();
		

		System.out.println("# # # # # # # # # #");
		System.out.println("Step : " + NB_LOOP);
		System.out.println(a.getClass().getName() + " index " + a.getIndex() + " heuristic " + a.getHeuristic());
		
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
		axisArrays.sort((AxisArray e1, AxisArray e2) -> Double.compare(e2.getHeuristic(), e1.getHeuristic()));

		
		a.updateGrid(solveGrid);
		System.out.println(solveGrid.toString());
		solve(NB_LOOP + 1);
	}
	
	
	
	public static void main(String[] args) throws Exception {
		HanjieGrid h = new HanjieGrid(25);
		
		/*  h Figure
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
		 *
		 */
		
		h.setLine(0, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, -1,  -1, -1, -1, -1, 1,  1, 1, 1, 1, 1,  1, -1, -1, -1, -1,  -1, -1, -1, -1, -1)));
		h.setLine(1, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, -1,  -1, -1, -1, 1, 1,  1, 1, 1, 1, 1,  1, 1, -1, -1, -1,  -1, -1, -1, -1, -1)));
		h.setLine(2, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, -1,  -1, -1, 1, 1, 1,  -1, -1, -1, -1, -1,  1, 1, 1, -1, -1,  -1, -1, -1, -1, -1)));
		h.setLine(3, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, -1,  -1, -1, 1, 1, -1,  -1, -1, -1, -1, -1,  -1, 1, 1, 1, -1,  -1, -1, -1, -1, -1)));
		h.setLine(4, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, -1,  -1, -1, 1, 1, -1,  1, 1, 1, -1, -1,  -1, -1, 1, 1, -1,  -1, -1, -1, -1, -1)));

		h.setLine(5, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, -1,  -1, -1, 1, 1, -1,  -1, -1, 1, 1, 1,  -1, -1, 1, 1, -1,  -1, -1, -1, -1, -1)));
		h.setLine(6, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, -1,  -1, -1, 1, 1, -1,  -1, -1, -1, 1, 1,  -1, -1, 1, 1, -1,  -1, -1, -1, -1, -1)));
		h.setLine(7, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, -1,  -1, -1, 1, 1, 1,  -1, -1, -1, 1, 1,  -1, -1, 1, 1, -1,  -1, -1, -1, -1, -1)));
		h.setLine(8, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, -1,  -1, -1, -1, 1, 1,  1, 1, 1, 1, -1,  -1, -1, 1, 1, -1,  -1, -1, -1, -1, -1)));
		h.setLine(9, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, -1,  -1, -1, -1, -1, 1,  1, 1, 1, -1, -1,  -1, 1, 1, 1, -1,  -1, -1, -1, -1, -1)));

		h.setLine(10, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, -1,  -1, -1, -1, -1, -1,  -1, -1, -1, -1, -1,  -1, 1, 1, -1, -1,  -1, -1, -1, -1, -1)));
		h.setLine(11, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, 1,  1, 1, 1, 1, -1,  -1, -1, -1, -1, 1,  1, 1, 1, -1, -1,  -1, -1, -1, -1, -1)));
		h.setLine(12, new ArrayList<Integer>(Arrays.asList(-1, -1, 1, 1, 1,  1, 1, 1, 1, 1,  1, 1, 1, 1, 1,  1, 1, -1, -1, -1,  -1, -1, -1, -1, -1)));
		h.setLine(13, new ArrayList<Integer>(Arrays.asList(-1, 1, 1, 1, 1,  1, 1, 1, 1, 1,  1, 1, 1, 1, 1,  1, -1, -1, -1, -1,  -1, -1, -1, -1, -1)));
		h.setLine(14, new ArrayList<Integer>(Arrays.asList(1, 1, 1, -1, -1,  -1, -1, -1, -1, -1,  1, 1, 1, 1, 1,  -1, -1, -1, 1, 1,  1, 1, 1, 1, -1)));

		h.setLine(15, new ArrayList<Integer>(Arrays.asList(1, 1, -1, -1, -1,  -1, -1, -1, -1, -1,  -1, 1, 1, 1, 1,  -1, -1, 1, 1, 1,  1, 1, 1, 1, 1)));
		h.setLine(16, new ArrayList<Integer>(Arrays.asList(1, -1, -1, -1, 1,  1, 1, 1, -1, -1,  -1, 1, 1, 1, -1,  -1, -1, 1, 1, -1,  -1, -1, -1, 1, 1)));
		h.setLine(17, new ArrayList<Integer>(Arrays.asList(1, -1, -1, 1, 1,  1, 1, 1, 1, -1,  -1, 1, 1, 1, -1,  -1, -1, 1, -1, -1,  -1, -1, -1, -1, 1)));
		h.setLine(18, new ArrayList<Integer>(Arrays.asList(1, -1, -1, 1, 1,  -1, -1, 1, 1, 1,  -1, -1, 1, 1, -1,  -1, -1, 1, 1, -1,  -1, -1, -1, -1, 1)));
		h.setLine(19, new ArrayList<Integer>(Arrays.asList(1, -1, -1, 1, 1,  -1, -1, -1, 1, 1,  -1, -1, 1, 1, -1,  -1, -1, 1, 1, 1,  1, 1, -1, -1, 1)));

		h.setLine(20, new ArrayList<Integer>(Arrays.asList(1, -1, -1, -1, -1,  -1, -1, -1, 1, 1,  -1, -1, 1, 1, 1,  -1, -1, -1, 1, 1,  1, -1, -1, -1, 1)));
		h.setLine(21, new ArrayList<Integer>(Arrays.asList(1, 1, -1, -1, -1,  -1, -1, -1, 1, 1,  -1, -1, -1, 1, 1,  1, -1, -1, -1, -1,  -1, -1, -1, 1, 1)));
		h.setLine(22, new ArrayList<Integer>(Arrays.asList(1, 1, 1, -1, -1,  -1, 1, 1, 1, -1,  -1, -1, -1, 1, 1,  1, 1, -1, -1, -1,  -1, -1, 1, 1, 1)));
		h.setLine(23, new ArrayList<Integer>(Arrays.asList(-1, 1, 1, 1, 1,  1, 1, 1, 1, -1,  -1, -1, -1, -1, 1,  1, 1, 1, 1, 1,  1, 1, 1, 1, 1)));
		h.setLine(24, new ArrayList<Integer>(Arrays.asList(-1, -1, 1, 1, 1,  1, 1, 1, -1, -1,  -1, -1, -1, -1, -1,  -1, 1, 1, 1, 1,  1, 1, 1, 1, -1)));

		HanjieSolver solver = new HanjieSolver(h);
	}
	
	
}