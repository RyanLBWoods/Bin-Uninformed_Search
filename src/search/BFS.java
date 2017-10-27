package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS extends SearchMethod {
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
        Queue<Node> q = new LinkedList<>();
        ArrayList<Node> childs = new ArrayList<>();
        ArrayList<Node> explored = new ArrayList<>();
        start.parent = start;
        q.add(start);
        explored.add(start);

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
                for (int i = Path.size() - 1; i >= 0; i--) {
                    System.out.print(Arrays.toString(Path.get(i)));
                }
                System.out.println();
                explored.remove(0); // Get rid of first node as it is a
                                    // redundancy
                for (int j = 0; j < explored.size(); j++) {
                    System.out.print(Arrays.toString(explored.get(j).getLocation()));
                }
                // Show explored times
                System.out.println("\nExplored " + explored.size() + " position");
                break;
            } else {
                /*
                 * Get child nodes 1. give the potential child nodes 2. check if
                 * the potential child node is the parent node or has been
                 * explored 3. if so, get rid of that child node
                 */
                if (current.getX() - 1 >= 0 && map[current.getX() - 1][current.getY()] != 'X') {
                    current.uChild = new Node(current.getX() - 1, current.getY(),
                            map[current.getX() - 1][current.getY()]);
                    if (Arrays.equals(current.uChild.getLocation(), current.parent.getLocation())
                            || !existChild(childs, current.uChild) || !notExplored(explored, current.uChild)) {
                        current.uChild = null;
                    } else {
                        current.uChild.parent = current;
                    }
                }
                if (current.getX() + 1 < 10 && map[current.getX() + 1][current.getY()] != 'X') {
                    current.dChild = new Node(current.getX() + 1, current.getY(),
                            map[current.getX() + 1][current.getY()]);
                    if (Arrays.equals(current.dChild.getLocation(), current.parent.getLocation())
                            || !existChild(childs, current.dChild) || !notExplored(explored, current.dChild)) {
                        current.dChild = null;
                    } else {
                        current.dChild.parent = current;
                    }
                }
                if (current.getY() - 1 >= 0 && map[current.getX()][current.getY() - 1] != 'X') {
                    current.lChild = new Node(current.getX(), current.getY() - 1,
                            map[current.getX()][current.getY() - 1]);
                    if (Arrays.equals(current.lChild.getLocation(), current.parent.getLocation())
                            || !existChild(childs, current.lChild) || !notExplored(explored, current.lChild)) {
                        current.lChild = null;
                    } else {
                        current.lChild.parent = current;
                    }
                }
                if (current.getY() + 1 < 10 && map[current.getX()][current.getY() + 1] != 'X') {
                    current.rChild = new Node(current.getX(), current.getY() + 1,
                            map[current.getX()][current.getY() + 1]);
                    if (Arrays.equals(current.rChild.getLocation(), current.parent.getLocation())
                            || !existChild(childs, current.rChild) || !notExplored(explored, current.rChild)) {
                        current.rChild = null;
                    } else {
                        current.rChild.parent = current;
                    }
                }

                if (current.getChildren().isEmpty()) {
                    System.out.println("Branch ended");
                } else {
                    q.addAll(current.getChildren());
                    childs.addAll(current.getChildren());
                }
                explored.add(current);
            }
        }
    }
}
