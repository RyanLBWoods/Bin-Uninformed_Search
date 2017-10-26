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
    public static char[][] map1 = new char[][]{
        {'I', 'X', 'O'},
        {'O', 'O', 'O'},
        {'B', 'O', 'G'}
    };
    public static char[][] map2 = new char[][] {
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
    
    public static void BFSearch(Node start, Node goal){
        Queue<Node> q = new LinkedList<>();
        ArrayList<Node> explored = new ArrayList<>();
        q.add(start);
        explored.add(start);
        Node parent = null;
        
        while(!q.isEmpty()){
            Node current = q.remove();
            current.parent = parent;
            System.out.println(current.parent);
            System.out.println(current.uChild);
            System.out.println(current.dChild);
            System.out.println(current.lChild);
            System.out.println(current.rChild);
            System.out.println(current.getX());
            System.out.println(current.getY());
            if(current.getValue() == goal.getValue()){
                System.out.println(explored);
            } else {
                // Get child nodes
                if(current.getX() - 1 >= 0 && map1[current.getX() - 1][current.getY()] != 'X'){
                    current.uChild = new Node(current.getX() - 1, current.getY(), map1[current.getX() - 1][current.getY()]);
                    if(current.uChild.equals(parent)){
                        current.uChild = null;
                    }
                }
                if(current.getX() + 1 < 3 && map1[current.getX() + 1][current.getY()] != 'X'){
                    current.dChild = new Node(current.getX() + 1, current.getY(), map1[current.getX() + 1][current.getY()]);
                    if(current.dChild.getValue() == current.parent.getValue()){
                        current.dChild = null;
                    }
                }
                if(current.getY() - 1 >= 0 && map1[current.getX()][current.getY() - 1] != 'X'){
                    current.lChild = new Node(current.getX(), current.getY() - 1, map1[current.getX()][current.getY() - 1]);
                    if(current.lChild.getValue() == current.parent.getValue()){
                        current.lChild = null;
                    }
                }
                if(current.getY() + 1 < 3 && map1[current.getX()][current.getY() + 1] != 'X'){
                    current.rChild = new Node(current.getX(), current.getY() + 1, map1[current.getX()][current.getY() + 1]);
                    if(current.rChild.getValue() == current.parent.getValue()){
                        current.rChild = null;
                    }
                }
                
                if(current.getChildren().isEmpty()){
                    System.out.println("Path not found");
                } else {
                    q.addAll(current.getChildren());
                    System.out.println(q);
                }
            }
            parent = current;
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Node start = null, bob = null, goal = null;
        for(int i = 0; i < map1.length; i++){
            for(int j = 0; j < map1[i].length; j++){
                if(map1[i][j] == 'I'){
                    start = new Node(i, j, map1[i][j]);
                }
                if(map1[i][j] == 'B'){
                    bob = new Node(i, j, map1[i][j]);
                }
                if(map1[i][j] == 'G'){
                    goal = new Node(i, j, map1[i][j]);
                }
            }
        }
        System.out.println(start.getValue());
        System.out.println(bob.getValue());
        System.out.println(goal.getValue());
        BFSearch(start, bob);
        System.out.println("bob");
//        BFSearch(bob, goal);
    }

}
