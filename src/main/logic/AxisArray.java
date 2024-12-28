package main.logic;

import java.util.ArrayList;
import java.util.List;

import main.model.Grid;
import main.model.GridHeightException;
import main.model.GridWidthException;

public abstract class AxisArray {
	
	protected List<Integer> content;
	protected final List<Integer> description;
	protected final int index;
	protected int heuristic;
	protected List<ArrayList<Integer>> possibilities;
	protected final int descriptionPriority;
	
	public AxisArray(List<Integer> content, List<Integer> description, int index) {
		this.content = content;
		this.description = description;
		this.index = index;
		this.heuristic = 0;
		this.possibilities = PossibilityManager.computePossibilities(description, content.size());
		this.descriptionPriority = description.stream().mapToInt(Integer::intValue).sum() - description.size() + 1;
		
		this.computeHuristic();
	}
	
	public boolean isComplete() {
		int contentFilled = (int) content.stream().mapToInt(Integer::intValue).filter(e -> e != 0).count();
		return contentFilled == content.size();
	}
	
	public void computeHuristic() {		
		int contentFilled = (int) content.stream().mapToInt(Integer::intValue).filter(e -> e != 0).count();
		
		if (description.isEmpty()) {
			heuristic = 1000;
			return;
		}
		
		heuristic = 2*descriptionPriority + contentFilled;
		heuristic = 0;
	}

	public int getHeuristic() {
		return heuristic;
	}

	public int getIndex() {
		return index;
	}

	public List<Integer> getContent() {
		return content;
	}

	public List<ArrayList<Integer>> getPossibilities() {
		return possibilities;
	}
	
	public void updatePossibilities() {
		possibilities = PossibilityManager.updatePossibilities(possibilities, content);
	}
	
	public void setContent(List<Integer> content) {
		this.content = content;
	}

	public abstract void updateGrid(Grid solveGrid) throws GridHeightException, GridWidthException ;

}