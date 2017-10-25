package search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * CS5011-A2: Search-Rescue Simulation.
 * 
 * @author bl41
 *
 */
public class Search {
    //List for nodes of map
    public static ArrayList<Node> nodes = new ArrayList<>();
    static int counter = 0;
    static int Bcount = 0;
    static int Gcount = 0;
    // Set maps
    public static char[][] map1 = new char[][] {
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
    
    public void BFSearch(){
        Node s = new Node(0, 0, map1[0][0]);
        s.dChild = new Node(1, 0, map1[1][0]);
        s.rChild = new Node(0, 1, map1[0][1]);
        Queue<Node> q = new LinkedList<>();
        ArrayList<Node> explored = new ArrayList<>();
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        for(int i = 0; i < map1.length; i++){
            for(int j = 0; j < map1[i].length; j++){
                Node n = new Node(i, j, map1[i][j]);
                // Get target index in list
                if(map1[i][j] == 'B'){
                    Bcount = counter;
                }
                if(map1[i][j] == 'G'){
                    Gcount = counter;
                }
                // Set child nodes
                if(i - 1 >= 0 && map1[i - 1][j] != 'X') {
                    Node cn1 = new Node(i - 1, j, map1[i - 1][j]);
                    n.uChild = cn1;
                }
                if(j + 1 < 10 && map1[i][j + 1] != 'X') {
                    Node cn2 = new Node(i, j + 1, map1[i][j + 1]);
                    n.rChild = cn2;
                }
                if(i + 1 < 10 && map1[i + 1][j] != 'X') {
                    Node cn3 = new Node(i + 1, j, map1[i + 1][j]);
                    n.dChild = cn3;
                }
                if(j - 1 >= 0 && map1[i][j - 1] != 'X') {
                    Node cn4 = new Node(i, j - 1, map1[i][j - 1]);
                    n.lChild = cn4;
                }
                // Store nodes
                nodes.add(n);
                counter++;
            }
        }
        System.out.println(nodes.size());
        BFS getVic = new BFS(nodes.get(0), nodes.get(Bcount));
        if(getVic.explore()){
            BFS getGoal = new BFS(nodes.get(Bcount), nodes.get(Gcount));
            if(getGoal.explore()){
                System.out.println("path found!");
            } else {
                System.out.println("XG");
            }
        } else {
            System.out.println("XB");
        }
        
    }

}
