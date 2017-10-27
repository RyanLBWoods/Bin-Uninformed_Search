package search;

import java.util.ArrayList;

/**
 * CS5011-A2: Search-Rescue Simulation.
 * 
 * @author bl41
 *
 */
public class Search {
    // List for nodes of map
    public static ArrayList<Node> nodes = new ArrayList<>();
    static int counter = 0;
    static int Bcount = 0;
    static int Gcount = 0;

    // public static char[][] map1 = new char[][]{
    // {'I', 'G', 'O'},
    // {'O', 'O', 'O'},
    // {'O', 'O', 'B'}
    // };
    // Set maps
    public static char[][] map1 = new char[][] {
            { 'I', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
            { 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
            { 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
            { 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O' },
            { 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O' },
            { 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
            { 'O', 'O', 'X', 'X', 'O', 'X', 'O', 'O', 'O', 'O' },
            { 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'B', 'O' },
            { 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
            { 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'G' } };

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // Get start and aims
        Node start = null, bob = null, goal = null;
        for (int i = 0; i < map1.length; i++) {
            for (int j = 0; j < map1[i].length; j++) {
                if (map1[i][j] == 'I') {
                    start = new Node(i, j, map1[i][j]);
                }
                if (map1[i][j] == 'B') {
                    bob = new Node(i, j, map1[i][j]);
                }
                if (map1[i][j] == 'G') {
                    goal = new Node(i, j, map1[i][j]);
                }
            }
        }
        // Find Bob
        BFS.BFSearch(map1, start, bob);
        // Find Goal
        BFS.BFSearch(map1, bob, goal);
    }

}
