package search;

import java.util.ArrayList;
import java.util.Arrays;
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
		Stack<Node> frontier = new Stack<>(); // frontier
		// Record nodes that already become child
		ArrayList<Node> childs = new ArrayList<>();
		// Record nodes that have been explored
		ArrayList<Node> explored = new ArrayList<>();
		// Initialise process
		start.parent = start;
		frontier.push(start);
		// Add start to explored list to avoid null pointer exception
		explored.add(start);
		
		int max = 0;
		
		// Search
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			System.out.println("Current node: " + Arrays.toString(current.getLocation()));
			if (current.getValue() == goal.getValue()) {
				find = true;
				printOutput(current, start, goal, explored);
				System.out.println(max);
				break;
			} else {
				findChild(current, map, childs, explored);
				// Insert nodes to frontier
				if (!current.getChildren().isEmpty()) {
					frontier.addAll(current.getChildren());
					childs.addAll(current.getChildren());
				}
				showDFSFrontier(frontier);
				explored.add(current);
				showExplored(explored);
				System.out.println();
			}
			if(frontier.size() > max){
				max = frontier.size();
			}
		}
	}
}
