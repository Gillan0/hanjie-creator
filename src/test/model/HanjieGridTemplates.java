package test.model;

import java.util.ArrayList;
import java.util.Arrays;

import main.model.HanjieGrid;

public class HanjieGridTemplates {


	public static HanjieGrid buildTreeHanjieGrid() throws Exception {
		
		/*
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
		
		HanjieGrid h = new HanjieGrid(10);
		
		h.setLine(0, new ArrayList<>(Arrays.asList(-1,-1,-1,-1,-1,-1,-1,-1,-1,-1)));
		h.setLine(1, new ArrayList<>(Arrays.asList(-1,-1,-1,-1,1,1,-1,-1,-1,-1)));
		h.setLine(2, new ArrayList<>(Arrays.asList(-1,-1,-1,1,1,1,1,-1,-1,-1)));
		h.setLine(3, new ArrayList<>(Arrays.asList(-1,-1,1,1,1,1,1,1,-1,-1)));
		h.setLine(4, new ArrayList<>(Arrays.asList(-1,-1,-1,1,1,1,1,-1,-1,-1)));
		h.setLine(5, new ArrayList<>(Arrays.asList(-1,-1,1,1,1,1,1,1,-1,-1)));
		h.setLine(6, new ArrayList<>(Arrays.asList(-1,1,1,1,1,1,1,1,1,-1)));
		h.setLine(7, new ArrayList<>(Arrays.asList(-1,-1,-1,-1,1,1,-1,-1,-1,-1)));
		h.setLine(8, new ArrayList<>(Arrays.asList(-1,-1,-1,-1,1,1,-1,-1,-1,-1)));
		h.setLine(9, new ArrayList<>(Arrays.asList(-1,-1,-1,-1,-1,-1,-1,-1,-1,-1)));
		
		return h;
	}
	
	public static HanjieGrid buildShieldHanjieGrid() throws Exception {
		
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
			 
	 
		 */
		
		HanjieGrid h = new HanjieGrid(10);
		
		h.setLine(0, new ArrayList<>(Arrays.asList(-1, -1, -1, -1,  1, -1, -1, -1, -1, -1)));
		h.setLine(1, new ArrayList<>(Arrays.asList(-1, -1, -1,  1,  1,  1, -1, -1, -1, -1)));
		h.setLine(2, new ArrayList<>(Arrays.asList(-1, -1,  1,  1,  1,  1,  1, -1, -1, -1)));
		h.setLine(3, new ArrayList<>(Arrays.asList(-1,  1,  1,  -1,  -1,  1,  1,  1, -1, -1)));
		h.setLine(4, new ArrayList<>(Arrays.asList( 1,  1,  1,  -1,  -1,  -1,  1,  1,  1, -1)));
		h.setLine(5, new ArrayList<>(Arrays.asList(-1,  1,  1,  +1,  -1,  -1,  -1,  1,  1, -1)));
		h.setLine(6, new ArrayList<>(Arrays.asList(-1, -1,  1,  1,  1,  -1,  -1,  1,  1, -1)));
		h.setLine(7, new ArrayList<>(Arrays.asList(-1, -1, -1,  1,  1,  1,  1,  1,  1, -1)));
		h.setLine(8, new ArrayList<>(Arrays.asList(-1, -1, -1, -1,  1,  1,  1,  1,  1, -1)));
		h.setLine(9, new ArrayList<>(Arrays.asList(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1)));
	
		return h;
	}
	
	public static HanjieGrid buildPresentHanjieGrid() throws Exception {
		
		/* Present figure 
	 	
			_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ 
			_ _ _ _ _ 1 1 1 1 _ _ _ _ _ _ _ 1 1 1 1 _ _ _ _ _ 
			_ _ _ _ 1 1 _ _ 1 1 _ _ _ _ _ 1 1 _ _ 1 1 _ _ _ _ 
			_ _ _ _ 1 _ _ _ _ 1 1 _ _ _ 1 1 _ _ _ _ 1 _ _ _ _ 
			_ _ _ _ 1 1 _ _ _ _ 1 _ _ _ 1 _ _ _ _ 1 1 _ _ _ _ 
			_ _ _ _ _ 1 1 _ _ _ _ 1 _ 1 _ _ _ 1 1 _ _ _ _ _ _ 
			_ _ _ _ _ _ 1 1 1 1 1 _ 1 _ 1 1 1 1 _ _ _ _ _ _ _ 
			_ _ _ 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 _ _ _ 
			_ _ _ 1 _ _ _ _ _ 1 _ _ _ _ _ 1 _ _ _ _ _ 1 _ _ _ 
			_ _ _ 1 _ _ _ _ _ 1 _ _ _ _ _ 1 _ _ _ _ _ 1 _ _ _ 
			_ _ _ 1 _ _ _ _ _ 1 _ _ _ _ _ 1 _ _ _ _ _ 1 _ _ _ 
			_ _ _ 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 _ _ _ 
			_ _ _ _ 1 _ _ _ _ _ 1 _ _ _ 1 _ _ _ _ _ 1 _ _ _ _ 
			_ _ _ _ 1 _ _ _ _ _ 1 _ _ _ 1 _ _ _ _ _ 1 _ _ _ _ 
			_ _ _ _ 1 _ _ _ _ _ 1 _ _ _ 1 _ _ _ _ _ 1 _ _ _ _ 
			_ _ _ _ 1 _ _ _ _ _ 1 _ _ _ 1 _ _ _ _ _ 1 _ _ _ _ 
			_ _ _ _ 1 _ _ _ _ _ 1 _ _ _ 1 _ _ _ _ _ 1 _ _ _ _ 
			_ _ _ _ 1 _ _ _ _ _ 1 _ _ _ 1 _ _ _ _ _ 1 _ _ _ _ 
			_ _ _ _ 1 _ _ _ _ _ 1 _ _ _ 1 _ _ _ _ _ 1 _ _ _ _ 
			_ _ _ _ 1 _ _ _ _ _ 1 _ _ _ 1 _ _ _ _ _ 1 _ _ _ _ 
			_ _ _ _ 1 _ _ _ _ _ 1 _ _ _ 1 _ _ _ _ _ 1 _ _ _ _ 
			_ _ _ _ 1 _ _ _ _ _ 1 _ _ _ 1 _ _ _ _ _ 1 _ _ _ _ 
			_ _ _ _ 1 _ _ _ _ _ 1 _ _ _ 1 _ _ _ _ _ 1 _ _ _ _ 
			_ _ _ _ 1 _ _ _ _ _ 1 _ _ _ 1 _ _ _ _ _ 1 _ _ _ _ 
			_ _ _ _ 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 _ _ _ _
		 	
			 
		 */
		
		HanjieGrid h = new HanjieGrid(25);
		
		h.setLine(0, new ArrayList<>(Arrays.asList(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1)));
		h.setLine(1, new ArrayList<>(Arrays.asList(-1, -1, -1, -1, -1, 1, 1, 1, 1, -1, -1, -1, -1, -1, -1, -1, 1, 1, 1, 1, -1, -1, -1, -1, -1)));
		h.setLine(2, new ArrayList<>(Arrays.asList(-1, -1, -1, -1, 1, 1, -1, -1, 1, 1, -1, -1, -1, -1, -1, 1, 1, -1, -1, 1, 1, -1, -1, -1, -1)));
		h.setLine(3, new ArrayList<>(Arrays.asList(-1, -1, -1, -1, 1, -1, -1, -1, -1, 1, 1, -1, -1, -1, 1, 1, -1, -1, -1, -1, 1, -1, -1, -1, -1)));
		h.setLine(4, new ArrayList<>(Arrays.asList(-1, -1, -1, -1, 1, 1, -1, -1, -1, -1, 1, -1, -1, -1, 1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1)));

		h.setLine(5, new ArrayList<>(Arrays.asList(-1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, -1)));
		h.setLine(6, new ArrayList<>(Arrays.asList(-1, -1, -1, -1, -1, -1, 1, 1, 1, 1, 1, -1, 1, -1, 1, 1, 1, 1, -1, -1, -1, -1, -1, -1, -1)));
		h.setLine(7, new ArrayList<>(Arrays.asList(-1, -1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -1, -1, -1)));
		h.setLine(8, new ArrayList<>(Arrays.asList(-1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1)));
		h.setLine(9, new ArrayList<>(Arrays.asList(-1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1)));

		h.setLine(10, new ArrayList<>(Arrays.asList(-1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1)));
		h.setLine(11, new ArrayList<>(Arrays.asList(-1, -1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -1, -1, -1)));
		h.setLine(12, new ArrayList<>(Arrays.asList(-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1)));
		h.setLine(13, new ArrayList<>(Arrays.asList(-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1)));
		h.setLine(14, new ArrayList<>(Arrays.asList(-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1)));

		h.setLine(15, new ArrayList<>(Arrays.asList(-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1)));
		h.setLine(16, new ArrayList<>(Arrays.asList(-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1)));
		h.setLine(17, new ArrayList<>(Arrays.asList(-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1)));
		h.setLine(18, new ArrayList<>(Arrays.asList(-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1)));
		h.setLine(19, new ArrayList<>(Arrays.asList(-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1)));

		h.setLine(20, new ArrayList<>(Arrays.asList(-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1)));
		h.setLine(21, new ArrayList<>(Arrays.asList(-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1)));
		h.setLine(22, new ArrayList<>(Arrays.asList(-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1)));
		h.setLine(23, new ArrayList<>(Arrays.asList(-1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1)));
		h.setLine(24, new ArrayList<>(Arrays.asList(-1, -1, -1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -1, -1, -1, -1)));

		return h;
	}
	
	public static HanjieGrid buildBreizhHanjieGrid() throws Exception {
		
		/* Present figure 
	 	
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
			 	
				 
		 */
		
		HanjieGrid h = new HanjieGrid(25);
		
		h.setLine(0, new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0,  0, 0, 0, 0, 1,  1, 1, 1, 1, 1,  1, 0, 0, 0, 0,  0, 0, 0, 0, 0)));
		h.setLine(1, new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0,  0, 0, 0, 1, 1,  1, 1, 1, 1, 1,  1, 1, 0, 0, 0,  0, 0, 0, 0, 0)));
		h.setLine(2, new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0,  0, 0, 1, 1, 1,  0, 0, 0, 0, 0,  1, 1, 1, 0, 0,  0, 0, 0, 0, 0)));
		h.setLine(3, new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0,  0, 0, 1, 1, 0,  0, 0, 0, 0, 0,  0, 1, 1, 1, 0,  0, 0, 0, 0, 0)));
		h.setLine(4, new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0,  0, 0, 1, 1, 0,  1, 1, 1, 0, 0,  0, 0, 1, 1, 0,  0, 0, 0, 0, 0)));
															
		h.setLine(5, new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0,  0, 0, 1, 1, 0,  0, 0, 1, 1, 1,  0, 0, 1, 1, 0,  0, 0, 0, 0, 0)));
		h.setLine(6, new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0,  0, 0, 1, 1, 0,  0, 0, 0, 1, 1,  0, 0, 1, 1, 0,  0, 0, 0, 0, 0)));
		h.setLine(7, new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0,  0, 0, 1, 1, 1,  0, 0, 0, 1, 1,  0, 0, 1, 1, 0,  0, 0, 0, 0, 0)));
		h.setLine(8, new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0,  0, 0, 0, 1, 1,  1, 1, 1, 1, 0,  0, 0, 1, 1, 0,  0, 0, 0, 0, 0)));
		h.setLine(9, new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0,  0, 0, 0, 0, 1,  1, 1, 1, 0, 0,  0, 1, 1, 1, 0,  0, 0, 0, 0, 0)));
																
		h.setLine(10, new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0,  0, 0, 0, 0, 0,  0, 0, 0, 0, 0,  0, 1, 1, 0, 0,  0, 0, 0, 0, 0)));
		h.setLine(11, new ArrayList<>(Arrays.asList(0, 0, 0, 0, 1,  1, 1, 1, 1, 0,  0, 0, 0, 0, 1,  1, 1, 1, 0, 0,  0, 0, 0, 0, 0)));
		h.setLine(12, new ArrayList<>(Arrays.asList(0, 0, 1, 1, 1,  1, 1, 1, 1, 1,  1, 1, 1, 1, 1,  1, 1, 0, 0, 0,  0, 0, 0, 0, 0)));
		h.setLine(13, new ArrayList<>(Arrays.asList(0, 1, 1, 1, 1,  1, 1, 1, 1, 1,  1, 1, 1, 1, 1,  1, 0, 0, 0, 0,  0, 0, 0, 0, 0)));
		h.setLine(14, new ArrayList<>(Arrays.asList(1, 1, 1, 0, 0,  0, 0, 0, 0, 0,  1, 1, 1, 1, 1,  0, 0, 0, 1, 1,  1, 1, 1, 1, 0)));
																
		h.setLine(15, new ArrayList<>(Arrays.asList(1, 1, 0, 0, 0,  0, 0, 0, 0, 0,  0, 1, 1, 1, 1,  0, 0, 1, 1, 1,  1, 1, 1, 1, 1)));
		h.setLine(16, new ArrayList<>(Arrays.asList(1, 0, 0, 0, 1,  1, 1, 1, 0, 0,  0, 1, 1, 1, 0,  0, 0, 1, 1, 0,  0, 0, 0, 1, 1)));
		h.setLine(17, new ArrayList<>(Arrays.asList(1, 0, 0, 1, 1,  1, 1, 1, 1, 0,  0, 1, 1, 1, 0,  0, 0, 1, 0, 0,  0, 0, 0, 0, 1)));
		h.setLine(18, new ArrayList<>(Arrays.asList(1, 0, 0, 1, 1,  0, 0, 1, 1, 1,  0, 0, 1, 1, 0,  0, 0, 1, 1, 0,  0, 0, 0, 0, 1)));
		h.setLine(19, new ArrayList<>(Arrays.asList(1, 0, 0, 1, 1,  0, 0, 0, 1, 1,  0, 0, 1, 1, 0,  0, 0, 1, 1, 1,  1, 1, 0, 0, 1)));
																		
		h.setLine(20, new ArrayList<>(Arrays.asList(1, 0, 0, 0, 0,  0, 0, 0, 1, 1,  0, 0, 1, 1, 1,  0, 0, 0, 1, 1,  1, 0, 0, 0, 1)));
		h.setLine(21, new ArrayList<>(Arrays.asList(1, 1, 0, 0, 0,  0, 0, 0, 1, 1,  0, 0, 0, 1, 1,  1, 0, 0, 0, 0,  0, 0, 0, 1, 1)));
		h.setLine(22, new ArrayList<>(Arrays.asList(1, 1, 1, 0, 0,  0, 1, 1, 1, 0,  0, 0, 0, 1, 1,  1, 1, 0, 0, 0,  0, 0, 1, 1, 1)));
		h.setLine(23, new ArrayList<>(Arrays.asList(0, 1, 1, 1, 1,  1, 1, 1, 1, 0,  0, 0, 0, 0, 1,  1, 1, 1, 1, 1,  1, 1, 1, 1, 1)));
		h.setLine(24, new ArrayList<>(Arrays.asList(0, 0, 1, 1, 1,  1, 1, 1, 0, 0,  0, 0, 0, 0, 0,  0, 1, 1, 1, 1,  1, 1, 1, 1, 0)));

		return h;
	}

}
