package test.logic;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import main.logic.HanjieSolver;
import main.logic.model.HanjieGrid;

class HanjieSolverTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void testComputePossibilities() {
		
	}
	
	/*
	 
	 HanjieGrid h = new HanjieGrid(10);
		
		 * h Figure
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
	 
	 
	 */

	/* Present lines : 
	 
	 	h.setLine(0, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1)));
		h.setLine(1, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, -1, 1, 1, 1, 1, -1, -1, -1, -1, -1, -1, -1, 1, 1, 1, 1, -1, -1, -1, -1, -1)));
		h.setLine(2, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, 1, 1, -1, -1, 1, 1, -1, -1, -1, -1, -1, 1, 1, -1, -1, 1, 1, -1, -1, -1, -1)));
		h.setLine(3, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, 1, -1, -1, -1, -1, 1, 1, -1, -1, -1, 1, 1, -1, -1, -1, -1, 1, -1, -1, -1, -1)));
		h.setLine(4, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, 1, 1, -1, -1, -1, -1, 1, -1, -1, -1, 1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1)));

		h.setLine(5, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, -1)));
		h.setLine(6, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, -1, -1, 1, 1, 1, 1, 1, -1, 1, -1, 1, 1, 1, 1, -1, -1, -1, -1, -1, -1, -1)));
		h.setLine(7, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -1, -1, -1)));
		h.setLine(8, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1)));
		h.setLine(9, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1)));

		h.setLine(10, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1)));
		h.setLine(11, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -1, -1, -1)));
		h.setLine(12, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1)));
		h.setLine(13, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1)));
		h.setLine(14, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1)));

		h.setLine(15, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1)));
		h.setLine(16, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1)));
		h.setLine(17, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1)));
		h.setLine(18, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1)));
		h.setLine(19, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1)));

		h.setLine(20, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1)));
		h.setLine(21, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1)));
		h.setLine(22, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1)));
		h.setLine(23, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1)));
		h.setLine(24, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -1, -1, -1, -1)));

	 
	 */
	
	/* Shield figure 
	 	
	 	_ _ _ _ 1 _ _ _ _ _ 
		_ _ _ 1 1 1 _ _ _ _ 
		_ _ 1 1 1 1 1 _ _ _ 
		_ 1 1 _ _ 1 1 1 _ _ 
		1 1 1 _ _ _ 1 1 1 _ 
		_ 1 1 1 _ _ _ 1 1 _ 
		_ _ 1 1 1 _ _ 1 1 _ 
		_ _ _ 1 1 1 1 1 1 _ 
		_ _ _ _ 1 1 1 1 1 _ 
		_ _ _ _ _ _ _ _ _ _ 
		 
		h.setLine(0, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1,  1, -1, -1, -1, -1, -1)));
		h.setLine(1, new ArrayList<Integer>(Arrays.asList(-1, -1, -1,  1,  1,  1, -1, -1, -1, -1)));
		h.setLine(2, new ArrayList<Integer>(Arrays.asList(-1, -1,  1,  1,  1,  1,  1, -1, -1, -1)));
		h.setLine(3, new ArrayList<Integer>(Arrays.asList(-1,  1,  1,  -1,  -1,  1,  1,  1, -1, -1)));
		h.setLine(4, new ArrayList<Integer>(Arrays.asList( 1,  1,  1,  -1,  -1,  -1,  1,  1,  1, -1)));
		h.setLine(5, new ArrayList<Integer>(Arrays.asList(-1,  1,  1,  +1,  -1,  -1,  -1,  1,  1, -1)));
		h.setLine(6, new ArrayList<Integer>(Arrays.asList(-1, -1,  1,  1,  1,  -1,  -1,  1,  1, -1)));
		h.setLine(7, new ArrayList<Integer>(Arrays.asList(-1, -1, -1,  1,  1,  1,  1,  1,  1, -1)));
		h.setLine(8, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1,  1,  1,  1,  1,  1, -1)));
		h.setLine(9, new ArrayList<Integer>(Arrays.asList(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1)));
	 
	 */
	
	/* Template for manual draw
	 
	 	_ _ _ _ _ _ _ _ _ 1 1 1 1 1 1 1 _ _ _ _ _ _ _ _ _ 
		_ _ _ _ _ _ _ _ 1 1 1 1 1 1 1 1 1 _ _ _ _ _ _ _ _ 
		_ _ _ _ _ _ _ 1 1 1 _ _ _ _ _ 1 1 1 _ _ _ _ _ _ _ 
		_ _ _ _ _ _ _ 1 1 _ _ _ _ _ _ _ 1 1 1 _ _ _ _ _ _ 
		_ _ _ _ _ _ _ 1 1 _ 1 1 1 _ _ _ _ 1 1 _ _ _ _ _ _ 
		_ _ _ _ _ _ _ 1 1 _ _ _ 1 1 1 _ _ 1 1 _ _ _ _ _ _ 
		_ _ _ _ _ _ _ 1 1 _ _ _ _ 1 1 _ _ 1 1 _ _ _ _ _ _ 
		_ _ _ _ _ _ _ 1 1 1 _ _ _ 1 1 _ _ 1 1 _ _ _ _ _ _ 
		_ _ _ _ _ _ _ _ 1 1 1 1 1 1 _ _ _ 1 1 _ _ _ _ _ _ 
		_ _ _ _ _ _ _ _ _ 1 1 1 1 _ _ _ 1 1 1 _ _ _ _ _ _ 
		_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ 1 1 _ _ _ _ _ _ _ 
		_ _ _ _ 1 1 1 1 1 _ _ _ _ _ 1 1 1 1 _ _ _ _ _ _ _ 
		_ _ 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 _ _ _ _ _ _ _ _ 
		_ 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 _ _ _ _ _ _ _ _ _ 
		1 1 1 _ _ _ _ _ _ _ 1 1 1 1 1 _ _ _ 1 1 1 1 1 1 _ 
		1 1 _ _ _ _ _ _ _ _ _ 1 1 1 1 _ _ 1 1 1 1 1 1 1 1 
		1 _ _ _ 1 1 1 1 _ _ _ 1 1 1 _ _ _ 1 1 _ _ _ _ 1 1 
		1 _ _ 1 1 1 1 1 1 _ _ 1 1 1 _ _ _ 1 _ _ _ _ _ _ 1 
		1 _ _ 1 1 _ _ 1 1 1 _ _ 1 1 _ _ _ 1 1 _ _ _ _ _ 1 
		1 _ _ 1 1 _ _ _ 1 1 _ _ 1 1 _ _ _ 1 1 1 1 1 _ _ 1 
		1 _ _ _ _ _ _ _ 1 1 _ _ 1 1 1 _ _ _ 1 1 1 _ _ _ 1 
		1 1 _ _ _ _ _ _ 1 1 _ _ _ 1 1 1 _ _ _ _ _ _ _ 1 1 
		1 1 1 _ _ _ 1 1 1 _ _ _ _ 1 1 1 1 _ _ _ _ _ 1 1 1 
		_ 1 1 1 1 1 1 1 1 _ _ _ _ _ 1 1 1 1 1 1 1 1 1 1 1 
		_ _ 1 1 1 1 1 1 _ _ _ _ _ _ _ _ 1 1 1 1 1 1 1 1 _ 
	 
	 
	 	h.setLine(0, new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0,  0, 0, 0, 0, 1,  1, 1, 1, 1, 1,  1, 0, 0, 0, 0,  0, 0, 0, 0, 0)));
		h.setLine(1, new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0,  0, 0, 0, 1, 1,  1, 1, 1, 1, 1,  1, 1, 0, 0, 0,  0, 0, 0, 0, 0)));
		h.setLine(2, new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0,  0, 0, 1, 1, 1,  0, 0, 0, 0, 0,  1, 1, 1, 0, 0,  0, 0, 0, 0, 0)));
		h.setLine(3, new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0,  0, 0, 1, 1, 0,  0, 0, 0, 0, 0,  0, 1, 1, 1, 0,  0, 0, 0, 0, 0)));
		h.setLine(4, new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0,  0, 0, 1, 1, 0,  1, 1, 1, 0, 0,  0, 0, 1, 1, 0,  0, 0, 0, 0, 0)));
															
		h.setLine(0, new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0,  0, 0, 1, 1, 0,  0, 0, 1, 1, 1,  0, 0, 1, 1, 0,  0, 0, 0, 0, 0)));
		h.setLine(1, new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0,  0, 0, 1, 1, 0,  0, 0, 0, 1, 1,  0, 0, 1, 1, 0,  0, 0, 0, 0, 0)));
		h.setLine(2, new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0,  0, 0, 1, 1, 1,  0, 0, 0, 1, 1,  0, 0, 1, 1, 0,  0, 0, 0, 0, 0)));
		h.setLine(3, new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0,  0, 0, 0, 1, 1,  1, 1, 1, 1, 0,  0, 0, 1, 1, 0,  0, 0, 0, 0, 0)));
		h.setLine(4, new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0,  0, 0, 0, 0, 1,  1, 1, 1, 0, 0,  0, 1, 1, 1, 0,  0, 0, 0, 0, 0)));
																
		h.setLine(0, new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0,  0, 0, 0, 0, 0,  0, 0, 0, 0, 0,  0, 1, 1, 0, 0,  0, 0, 0, 0, 0)));
		h.setLine(1, new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 1,  1, 1, 1, 1, 0,  0, 0, 0, 0, 1,  1, 1, 1, 0, 0,  0, 0, 0, 0, 0)));
		h.setLine(2, new ArrayList<Integer>(Arrays.asList(0, 0, 1, 1, 1,  1, 1, 1, 1, 1,  1, 1, 1, 1, 1,  1, 1, 0, 0, 0,  0, 0, 0, 0, 0)));
		h.setLine(3, new ArrayList<Integer>(Arrays.asList(0, 1, 1, 1, 1,  1, 1, 1, 1, 1,  1, 1, 1, 1, 1,  1, 0, 0, 0, 0,  0, 0, 0, 0, 0)));
		h.setLine(4, new ArrayList<Integer>(Arrays.asList(1, 1, 1, 0, 0,  0, 0, 0, 0, 0,  1, 1, 1, 1, 1,  0, 0, 0, 1, 1,  1, 1, 1, 1, 0)));
																
		h.setLine(0, new ArrayList<Integer>(Arrays.asList(1, 1, 0, 0, 0,  0, 0, 0, 0, 0,  0, 1, 1, 1, 1,  0, 0, 1, 1, 1,  1, 1, 1, 1, 1)));
		h.setLine(1, new ArrayList<Integer>(Arrays.asList(1, 0, 0, 0, 1,  1, 1, 1, 0, 0,  0, 1, 1, 1, 0,  0, 0, 1, 1, 0,  0, 0, 0, 1, 1)));
		h.setLine(2, new ArrayList<Integer>(Arrays.asList(1, 0, 0, 1, 1,  1, 1, 1, 1, 0,  0, 1, 1, 1, 0,  0, 0, 1, 0, 0,  0, 0, 0, 0, 1)));
		h.setLine(3, new ArrayList<Integer>(Arrays.asList(1, 0, 0, 1, 1,  0, 0, 1, 1, 1,  0, 0, 1, 1, 0,  0, 0, 1, 1, 0,  0, 0, 0, 0, 1)));
		h.setLine(4, new ArrayList<Integer>(Arrays.asList(1, 0, 0, 1, 1,  0, 0, 0, 1, 1,  0, 0, 1, 1, 0,  0, 0, 1, 1, 1,  1, 1, 0, 0, 1)));
																		
		h.setLine(0, new ArrayList<Integer>(Arrays.asList(1, 0, 0, 0, 0,  0, 0, 0, 1, 1,  0, 0, 1, 1, 1,  0, 0, 0, 1, 1,  1, 0, 0, 0, 1)));
		h.setLine(1, new ArrayList<Integer>(Arrays.asList(1, 1, 0, 0, 0,  0, 0, 0, 1, 1,  0, 0, 0, 1, 1,  1, 0, 0, 0, 0,  0, 0, 0, 1, 1)));
		h.setLine(2, new ArrayList<Integer>(Arrays.asList(1, 1, 1, 0, 0,  0, 1, 1, 1, 0,  0, 0, 0, 1, 1,  1, 1, 0, 0, 0,  0, 0, 1, 1, 1)));
		h.setLine(3, new ArrayList<Integer>(Arrays.asList(0, 1, 1, 1, 1,  1, 1, 1, 1, 0,  0, 0, 0, 0, 1,  1, 1, 1, 1, 1,  1, 1, 1, 1, 1)));
		h.setLine(4, new ArrayList<Integer>(Arrays.asList(0, 0, 1, 1, 1,  1, 1, 1, 0, 0,  0, 0, 0, 0, 0,  0, 1, 1, 1, 1,  1, 1, 1, 1, 0)));
	 
	 
	 */
	
}
