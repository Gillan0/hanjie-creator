package main.logic;

import java.util.ArrayList;
import java.util.List;

import main.logic.model.GridHeightException;
import main.logic.model.GridWidthException;
import main.logic.model.HanjieGrid;

public class PossibilityManager {

	public PossibilityManager() {}

	public static ArrayList<ArrayList<Integer>> computePossibilities(ArrayList<Integer> pattern, int max) {
		ArrayList<ArrayList<Integer>> possibilities = new ArrayList<ArrayList<Integer>>();
		
		if (pattern.isEmpty()) {
			ArrayList<Integer> possibility = new ArrayList<Integer>();
			while (possibility.size() < max) {
				possibility.add(-1);
	        }
			possibilities.add(possibility);
			return possibilities;
		}
		
		computeRecursivePossibilities(new ArrayList<Integer>(), pattern, possibilities, max, pattern.stream().mapToInt(Integer::intValue).sum());
		
		return possibilities;
	}
	
	public static void computeRecursivePossibilities(ArrayList<Integer> currentPossibility,
											  	List<Integer> pattern,
												ArrayList<ArrayList<Integer>> possibilities,
												int max,
												int patternSum) {				
		if (currentPossibility.size() == max && pattern.size() <= 0) {
			possibilities.add(currentPossibility);
		} else if (pattern.size() <= 0) {
			int currentSize = currentPossibility.size();
			for (int i = 0; i < max - currentSize; i++) {
				currentPossibility.add(-1);
			}
			possibilities.add(currentPossibility);
		} else if (currentPossibility.size() + pattern.get(0) <= max) {
			
			ArrayList<Integer> currentPattern = new ArrayList<Integer>();
			if (currentPossibility.size() > 0) {
				currentPattern.add(-1);
			}
			
			for (int j = 0; j < pattern.get(0); j++) {
				currentPattern.add(1);
			}

			for (int i = currentPossibility.size()-1+currentPattern.size(); i < max; i++) {
			
				ArrayList<Integer> followingPossibility = (ArrayList<Integer>) currentPossibility.clone();
				
				followingPossibility.addAll(currentPattern);
			
				computeRecursivePossibilities(followingPossibility,
						pattern.subList(1, pattern.size()),
						possibilities,
						max,
						patternSum);

				currentPossibility.add(-1);
				
			}
			
		}
	}

	public static ArrayList<Integer> checkCommonElements(ArrayList<ArrayList<Integer>> possibilities) {
		ArrayList<Integer> commonElements = new ArrayList<Integer>();
		
		for (int i=0; i < possibilities.get(0).size(); i++) {
			boolean isEqual = true;
			for (int j=0; j < possibilities.size() - 1; j++) {
				if (possibilities.get(j).get(i) != possibilities.get(j + 1).get(i)) {
					isEqual = false;
					break;
				}
			}
			if (isEqual) {
				commonElements.add(possibilities.get(0).get(i));
			} else {
				commonElements.add(0);
			}
		}
		
		return commonElements;
	}
	
	public static ArrayList<ArrayList<Integer>> updatePossibilities(ArrayList<ArrayList<Integer>> possibilities,
																	ArrayList<Integer> currentAxis) {
		ArrayList<ArrayList<Integer>> updatedPossibilities = new ArrayList<ArrayList<Integer>>();
		
		for (int i=0; i < possibilities.size(); i++) {
			
			boolean toAdd = true;
			for (int j=0; j < currentAxis.size(); j++) {
				if (currentAxis.get(j) == 0) {
					continue;
				}
				if (currentAxis.get(j) != possibilities.get(i).get(j)) {
					toAdd = false;
				}
			}
			
			if (toAdd) {
				updatedPossibilities.add(possibilities.get(i));
			}
		}
		
		return updatedPossibilities;
	}
	
	public static ArrayList<ArrayList<Integer>> computeLinePossibilities(HanjieGrid h, int n) throws GridHeightException {
		int length = h.getHeight();
		ArrayList<Integer> pattern = (ArrayList<Integer>) h.getLineDescription(n);		
		
		return PossibilityManager.computePossibilities(pattern, length);
	}

	public static ArrayList<ArrayList<Integer>> computeColumnPossibilities(HanjieGrid h, int n) throws GridWidthException {
		int width = h.getWidth();
		ArrayList<Integer> pattern = (ArrayList<Integer>) h.getColumnDescription(n);
		
		return PossibilityManager.computePossibilities(pattern, width);
	}
	
}