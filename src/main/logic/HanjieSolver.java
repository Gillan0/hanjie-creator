package main.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class HanjieSolver {

	private HanjieGrid hanjieGrid;
	private Grid solveGrid;
	private ArrayList<Integer> euristicLines;
	private ArrayList<Integer> euristicColumns;
	
	
	public HanjieSolver(HanjieGrid h) throws GridLengthException, GridWidthException {
		hanjieGrid = h;
		solveGrid = new Grid(h.getLength());
		euristicLines = new ArrayList<Integer>();
		euristicColumns = new ArrayList<Integer>();
		
		for (int i = 0; i < hanjieGrid.getLength(); i++) {
			ArrayList<Integer> line = hanjieGrid.getLine(i);
			euristicLines.add(computeEuristic(line));
		}
		
		for (int i = 0; i < hanjieGrid.getWidth(); i++) {
			ArrayList<Integer> column = hanjieGrid.getColumn(i);
			euristicColumns.add(computeEuristic(column));
		}
		
	}

	public static int computeEuristic(ArrayList<Integer> description) {
		int patternSum = description.stream().mapToInt(Integer::intValue).sum();
		int patternGap = description.size() - 1;
		
		return patternSum + patternGap;
	}
	
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
	

	public ArrayList<ArrayList<Integer>> computeLinePossibilities(int n) throws GridLengthException {
		int length = hanjieGrid.getLength();
		
		ArrayList<Integer> pattern = (ArrayList<Integer>) hanjieGrid.getLineDescription(n);
		
		return computePossibilities(pattern, length);
		
	}
		

	public ArrayList<ArrayList<Integer>> computeWidthPossibilities(int n) throws GridWidthException {
		int width = hanjieGrid.getWidth();
		
		ArrayList<Integer> pattern = (ArrayList<Integer>) hanjieGrid.getColumnDescription(n);
		
		return computePossibilities(pattern, width);
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
	
	
	public static void main(String[] args) {
		ArrayList<Integer> pattern = new ArrayList<Integer>();
		pattern.add(1);
		pattern.add(7);
		pattern.add(6);
		pattern.add(3);
		ArrayList<ArrayList<Integer>> possibilities = HanjieSolver.computePossibilities(pattern, 25);
		System.out.println("Possibilities : " + possibilities);
		ArrayList<Integer> commonElements = HanjieSolver.checkCommonElements(possibilities);
		System.out.println("CommonElements : " + commonElements);
	}
	
}