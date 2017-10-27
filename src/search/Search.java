package search;

import java.util.ArrayList;
import java.util.Arrays;
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
    
    public static char[][] map1 = new char[][]{
        {'I', 'G', 'O'},
        {'O', 'O', 'O'},
        {'O', 'O', 'B'}
    };
    // Set maps
//    public static char[][] map1 = new char[][] {
//        {'I', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
//        {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
//        {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
//        {'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O'},
//        {'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O'},
//        {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
//        {'O', 'O', 'X', 'X', 'O', 'X', 'O', 'O', 'O', 'O'},
//        {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'B', 'O'},
//        {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
//        {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'G'}
//    };
    
    public static void BFSearch(Node start, Node goal){
        Queue<Node> q = new LinkedList<>();
        ArrayList<Node> childs = new ArrayList<>();
        ArrayList<Node> explored = new ArrayList<>();
        start.parent = start;
        q.add(start);
        explored.add(start);
        
        while(!q.isEmpty()){
            Node current = q.remove();
            System.out.println(current.getX());
            System.out.println(current.getY());
            if(current.getValue() == goal.getValue()){
                System.out.println(explored);
                break;
            } else {
                /*
                 * Get child nodes
                 * 1. give the potential child nodes
                 * 2. check if the potential child node is the parent node
                 * 3. if so, get rid of that child node
                 */
                if(current.getX() - 1 >= 0 && map1[current.getX() - 1][current.getY()] != 'X'){
                    current.uChild = new Node(current.getX() - 1, current.getY(), map1[current.getX() - 1][current.getY()]);
                    if(Arrays.equals(current.uChild.getLocation(), current.parent.getLocation()) || !BFS.existChild(childs, current.uChild) || !BFS.notExplored(explored, current.uChild)){
                        current.uChild = null;
                    } else {
                        current.uChild.parent = current;
                    }
                }
                if(current.getX() + 1 < 3 && map1[current.getX() + 1][current.getY()] != 'X'){
                    current.dChild = new Node(current.getX() + 1, current.getY(), map1[current.getX() + 1][current.getY()]);
                    if(Arrays.equals(current.dChild.getLocation(), current.parent.getLocation()) || !BFS.existChild(childs, current.dChild) || !BFS.notExplored(explored, current.dChild)){
                        current.dChild = null;  
                    } else {
                        current.dChild.parent = current;
                    }
                }
                if(current.getY() - 1 >= 0 && map1[current.getX()][current.getY() - 1] != 'X'){
                    current.lChild = new Node(current.getX(), current.getY() - 1, map1[current.getX()][current.getY() - 1]);
                    if(Arrays.equals(current.lChild.getLocation(), current.parent.getLocation()) || !BFS.existChild(childs, current.lChild) || !BFS.notExplored(explored, current.lChild)){
                        current.lChild = null;
                    } else {
                        current.lChild.parent = current;
                    }
                }
                if(current.getY() + 1 < 3 && map1[current.getX()][current.getY() + 1] != 'X'){
                    current.rChild = new Node(current.getX(), current.getY() + 1, map1[current.getX()][current.getY() + 1]);
                    if(Arrays.equals(current.rChild.getLocation(), current.parent.getLocation()) || !BFS.existChild(childs, current.rChild) || !BFS.notExplored(explored, current.rChild)){
                        current.rChild = null;
                    } else {
                        current.rChild.parent = current;
                    }
                }
                
                if(current.getChildren().isEmpty()){
                    System.out.println("End of this branch");
                } else {
                    q.addAll(current.getChildren());
                    childs.addAll(current.getChildren());
                }
                explored.add(current);
            }
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
        BFSearch(bob, goal);
        System.out.println("goal");
    }

}
