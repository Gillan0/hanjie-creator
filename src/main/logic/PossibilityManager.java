package main.logic;

import java.util.ArrayList;
import java.util.List;

import main.model.GridHeightException;
import main.model.GridWidthException;
import main.model.HanjieGrid;

public class PossibilityManager {

	public static List<ArrayList<Integer>> computePossibilities(List<Integer> pattern, int max) {
		ArrayList<ArrayList<Integer>> possibilities = new ArrayList<>();
		
		if (pattern.isEmpty()) {
			ArrayList<Integer> possibility = new ArrayList<>();
			while (possibility.size() < max) {
				possibility.add(-1);
	        }
			possibilities.add(possibility);
			return possibilities;
		}
		
		computeRecursivePossibilities(new ArrayList<>(), pattern, possibilities, max, pattern.stream().mapToInt(Integer::intValue).sum());
		
		return possibilities;
	}
	
	public static void computeRecursivePossibilities(ArrayList<Integer> currentPossibility,
											  	List<Integer> pattern,
												List<ArrayList<Integer>> possibilities,
												int max,
												int patternSum) {				
		if (currentPossibility.size() == max && pattern.isEmpty()) {
			possibilities.add(currentPossibility);
		} else if (pattern.isEmpty()) {
			int currentSize = currentPossibility.size();
			for (int i = 0; i < max - currentSize; i++) {
				currentPossibility.add(-1);
			}
			possibilities.add(currentPossibility);
		} else if (currentPossibility.size() + pattern.get(0) <= max) {
			
			ArrayList<Integer> currentPattern = new ArrayList<>();
			if (!currentPossibility.isEmpty()) {
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

	public static List<Integer> checkCommonElements(List<ArrayList<Integer>> possibilities) {
		ArrayList<Integer> commonElements = new ArrayList<>();
		
		for (int i=0; i < possibilities.get(0).size(); i++) {
			boolean isEqual = true;
			for (int j=0; j < possibilities.size() - 1; j++) {
				if (!possibilities.get(j).get(i).equals(possibilities.get(j + 1).get(i)) ) {
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
	
	public static List<ArrayList<Integer>> updatePossibilities(List<ArrayList<Integer>> possibilities,
																	List<Integer> currentAxis) {
		ArrayList<ArrayList<Integer>> updatedPossibilities = new ArrayList<>();
		
		for (int i=0; i < possibilities.size(); i++) {
			
			boolean toAdd = true;
			for (int j=0; j < currentAxis.size(); j++) {
				if (currentAxis.get(j) == 0) {
					continue;
				}
				if (!currentAxis.get(j).equals(possibilities.get(i).get(j))) {
					toAdd = false;
				}
			}
			
			if (toAdd) {
				updatedPossibilities.add(possibilities.get(i));
			}
		}
		
		return updatedPossibilities;
	}
	
	public static List<ArrayList<Integer>> computeLinePossibilities(HanjieGrid h, int n) throws GridHeightException {
		int length = h.getHeight();
		List<Integer> pattern = h.getLineDescription(n);		
		
		return PossibilityManager.computePossibilities(pattern, length);
	}

	public static List<ArrayList<Integer>> computeColumnPossibilities(HanjieGrid h, int n) throws GridWidthException {
		int width = h.getWidth();
		List<Integer> pattern = h.getColumnDescription(n);
		
		return PossibilityManager.computePossibilities(pattern, width);
	}
	
}