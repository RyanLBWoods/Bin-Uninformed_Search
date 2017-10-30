package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BreathFirstSearch extends SearchMethod {
	/**
	 * Method of breath-first search.
	 * 
	 * @param map
	 *            The map to search
	 * @param start
	 *            The start node
	 * @param goal
	 *            The aim node
	 */
	public static void BFSearch(char[][] map, Node start, Node goal) {

		Queue<Node> q = new LinkedList<>(); // frontier
		// Record nodes that already become child
		ArrayList<Node> childs = new ArrayList<>();
		// Record nodes that have been explored
		ArrayList<Node> explored = new ArrayList<>();

		// Initialise process
		start.parent = start;
		q.add(start);
		explored.add(start);
		// Search
		while (!q.isEmpty()) {
			Node current = q.remove();
			if (current.getValue() == goal.getValue()) {
				Node path = current;
				ArrayList<int[]> Path = new ArrayList<>();
				Path.add(path.getLocation()); // Get goal position
				// Put path of coordinates in to an array list of output
				while (path.getParent() != null) {
					Path.add(path.parent.getLocation());
					path = path.parent;
					if (Arrays.equals(path.getLocation(), start.getLocation())) {
						break;
					}
				}
				// Print the path of coordinates
				System.out.println("Find path from " + start.getValue() + " to " + goal.getValue());
				for (int i = Path.size() - 1; i >= 0; i--) {
					System.out.print(Arrays.toString(Path.get(i)));
				}
				System.out.println("\nPath length: " + (Path.size() - 1));
				explored.remove(0); // Get rid of first node as it is a
									// redundancy
				// Show explored times
				System.out.println("Explored " + explored.size() + " position");
				for (int j = 0; j < explored.size(); j++) {
					System.out.print(Arrays.toString(explored.get(j).getLocation()));
				}
				System.out.println("\n");
				break;
			} else {
				findChild(current, map, childs, explored);
				// Insert nodes to frontier
				if (!current.getChildren().isEmpty()) {
					q.addAll(current.getChildren());
					childs.addAll(current.getChildren());
				}
				explored.add(current);
			}
		}
	}
}
