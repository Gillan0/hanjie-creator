package test.logic;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.logic.model.HanjieGrid;

class HanjieGridTest {

	private HanjieGrid emptyGrid; // TO BE TESTED LATER
	private HanjieGrid hanjieGrid;
	
	@BeforeEach
	void setup() throws Exception {
		hanjieGrid = new HanjieGrid(10);
		
		/* hanjieGrid Figure
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
		
		hanjieGrid.setLine(0, new Integer[] {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1});
		hanjieGrid.setLine(1, new Integer[] {-1,-1,-1,-1,1,1,-1,-1,-1,-1});
		hanjieGrid.setLine(2, new Integer[] {-1,-1,-1,1,1,1,1,-1,-1,-1});
		hanjieGrid.setLine(3, new Integer[] {-1,-1,1,1,1,1,1,1,-1,-1});
		hanjieGrid.setLine(4, new Integer[] {-1,-1,-1,1,1,1,1,-1,-1,-1});
		hanjieGrid.setLine(5, new Integer[] {-1,-1,1,1,1,1,1,1,-1,-1});
		hanjieGrid.setLine(6, new Integer[] {-1,1,1,1,1,1,1,1,1,-1});
		hanjieGrid.setLine(7, new Integer[] {-1,-1,-1,-1,1,1,-1,-1,-1,-1});
		hanjieGrid.setLine(8, new Integer[] {-1,-1,-1,-1,1,1,-1,-1,-1,-1});
		hanjieGrid.setLine(9, new Integer[] {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1});
		
	}
	
	@Test
	void testGetLineDescription() throws Exception {
		
		assertEquals(hanjieGrid.getLineDescription(0), new ArrayList<Integer>());
		assertEquals(hanjieGrid.getLineDescription(1), new ArrayList<Integer>(Arrays.asList(2))); 
		assertEquals(hanjieGrid.getLineDescription(2), new ArrayList<Integer>(Arrays.asList(4)));
		assertEquals(hanjieGrid.getLineDescription(3), new ArrayList<Integer>(Arrays.asList(6)));
		assertEquals(hanjieGrid.getLineDescription(4), new ArrayList<Integer>(Arrays.asList(4)));
		assertEquals(hanjieGrid.getLineDescription(5), new ArrayList<Integer>(Arrays.asList(6)));
		assertEquals(hanjieGrid.getLineDescription(6), new ArrayList<Integer>(Arrays.asList(8)));
		assertEquals(hanjieGrid.getLineDescription(7), new ArrayList<Integer>(Arrays.asList(2)));
		assertEquals(hanjieGrid.getLineDescription(8), new ArrayList<Integer>(Arrays.asList(2)));
		assertEquals(hanjieGrid.getLineDescription(9), new ArrayList<Integer>());
	}
	
	@Test
	void testGetColumnDescription() throws Exception {
		assertEquals(hanjieGrid.getColumnDescription(0), new ArrayList<Integer>());
		assertEquals(hanjieGrid.getColumnDescription(1), new ArrayList<Integer>(Arrays.asList(1))); 
		assertEquals(hanjieGrid.getColumnDescription(2), new ArrayList<Integer>(Arrays.asList(1,2)));
		assertEquals(hanjieGrid.getColumnDescription(3), new ArrayList<Integer>(Arrays.asList(5)));
		assertEquals(hanjieGrid.getColumnDescription(4), new ArrayList<Integer>(Arrays.asList(8)));
		assertEquals(hanjieGrid.getColumnDescription(5), new ArrayList<Integer>(Arrays.asList(8)));
		assertEquals(hanjieGrid.getColumnDescription(6), new ArrayList<Integer>(Arrays.asList(5)));
		assertEquals(hanjieGrid.getColumnDescription(7), new ArrayList<Integer>(Arrays.asList(1,2)));
		assertEquals(hanjieGrid.getColumnDescription(8), new ArrayList<Integer>(Arrays.asList(1)));
		assertEquals(hanjieGrid.getColumnDescription(9), new ArrayList<Integer>());
	}
	
	@Test
	void testToggleElement() throws Exception {
		hanjieGrid.toggleElement(0, 0);
		assertEquals(hanjieGrid.getElement(0, 0), 1);
		hanjieGrid.toggleElement(1, 4);
		assertEquals(hanjieGrid.getElement(1, 4), -1);
	}

}
