package search;

import java.util.ArrayList;

/**
 * CS5011-A2: Search-Rescue Simulation.
 * 
 * @author bl41
 *
 */
public class Search {
    
    ArrayList<Node> nodes = new ArrayList<>();
    // Set maps
    static char[][] map1 = new char[][] {
        {'I', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
        {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
        {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
        {'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O'},
        {'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O'},
        {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
        {'O', 'O', 'X', 'X', 'O', 'X', 'O', 'O', 'O', 'O'},
        {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'B', 'O'},
        {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
        {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'G'}
    };
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        for(int i = 0; i < map1.length; i++){
            for(int j = 0; j < map1[i].length; j++){
                Node n = new Node(i, j, map1[i][j]);
                
                if(i - 1 >= 0) {
                    Node cn1 = new Node(i - 1, j, map1[i - 1][j]);
                    n.childNodes.add(cn1);
                }
                if(j + 1 <= 10) {
                    Node cn2 = new Node(i, j + 1, map1[i][j + 1]);
                    n.childNodes.add(cn2);
                }
                if(i + 1 <= 10) {
                    Node cn3 = new Node(i + 1, j, map1[i + 1][j]);
                    n.childNodes.add(cn3);
                }
                if(j - 1 >= 0) {
                    Node cn4 = new Node(i, j - 1, map1[i - 1][j]);
                    n.childNodes.add(cn4);
                }
            }
        }
    }

}
