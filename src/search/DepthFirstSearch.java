package search;

import java.util.ArrayList;
import java.util.Stack;

public class DepthFirstSearch extends SearchMethod {
	/**
	 * Method of depth-first search.
	 * 
	 * @param map
	 *            The map to search
	 * @param start
	 *            The start node
	 * @param goal
	 *            The aim node
	 */
	public static void DFSearch(char[][] map, Node start, Node goal) {
		Stack<Node> s = new Stack<>(); // frontier
		// Record nodes that already become child
		ArrayList<Node> childs = new ArrayList<>();
		// Record nodes that have been explored
		ArrayList<Node> explored = new ArrayList<>();
		// Initialise process
		start.parent = start;
		s.push(start);
		explored.add(start);
		// Search
		while (!s.isEmpty()) {
			Node current = s.pop();
			if (current.getValue() == goal.getValue()) {
				find = true;
				printOutput(current, start, goal, explored);
				break;
			} else {
				findChild(current, map, childs, explored);
				// Insert nodes to frontier
				if (!current.getChildren().isEmpty()) {
					s.addAll(current.getChildren());
					childs.addAll(current.getChildren());
				}
				explored.add(current);
			}
		}
	}
}
