package main.logic;

import java.util.ArrayList;

import main.logic.model.Grid;

public abstract class AxisArray {
	
	protected ArrayList<Integer> content;
	protected final ArrayList<Integer> description;
	protected final int index;
	protected int heuristic;
	protected ArrayList<ArrayList<Integer>> possibilities;
	protected final int descriptionPriority;
	
	public AxisArray(ArrayList<Integer> content, ArrayList<Integer> description, int index) {
		this.content = content;
		this.description = description;
		this.index = index;
		this.heuristic = this.computeHuristic();
		this.possibilities = PossibilityManager.computePossibilities(description, content.size());
		this.descriptionPriority = description.stream().mapToInt(Integer::intValue).sum() + description.size() - 1;
	}
	
	public boolean isComplete() {
		int contentFilled = (int) content.stream().mapToInt(Integer::intValue).filter((e) -> e != 0).count();
		return contentFilled == content.size();
	}
	
	public int computeHuristic() {		
		int contentFilled = (int) content.stream().mapToInt(Integer::intValue).filter((e) -> e != 0).count();
		
		return descriptionPriority - contentFilled;
	}

	public int getHeuristic() {
		return heuristic;
	}

	public int getIndex() {
		return index;
	}

	public ArrayList<Integer> getContent() {
		return content;
	}

	public ArrayList<ArrayList<Integer>> getPossibilities() {
		return possibilities;
	}
	
	public void updatePossibilities() {
		possibilities = PossibilityManager.updatePossibilities(possibilities, content);
	}
	
	public void setContent(ArrayList<Integer> content) {
		this.content = content;
	}

	public abstract void updateGrid(Grid solveGrid) throws Exception;
	

}