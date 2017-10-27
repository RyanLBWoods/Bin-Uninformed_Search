package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    Node start;
    Node goal;
    
    public BFS(Node start, Node goal){
        this.start = start;
        this.goal = goal;
    }
    
    public static boolean notExplored(ArrayList<Node> check, Node node){
        for(int i = 0; i < check.size(); i++) {
            Node n = check.get(i);
            if(Arrays.equals(n.getLocation(), node.getLocation())){
                return false;
            }
        }
        return true;
    }
    
    public static boolean existChild(ArrayList<Node> check, Node node){
        for(int i = 0; i < check.size();i++){
            Node n = check.get(i);
            if(Arrays.equals(n.getLocation(), node.getLocation())){
                return false;
            }
        }
        return true;
    }
    
    public boolean explore(){
        
        if(this.start.equals(goal)){
            System.out.println("Found!!!");
        }
        
        Queue<Node> q = new LinkedList<>();
        ArrayList<Node> explored = new ArrayList<>();
        q.add(this.start);
        explored.add(start);
        
        while(!q.isEmpty()){
            Node current = q.remove();
            if(current.equals(this.goal)){
                System.out.println(explored);
                return true;
            } else {
                if(current.getChildren().isEmpty()) {
                    return false;
                } else {
                    q.addAll(current.getChildren());
                }
            }
            explored.add(current);
        }
        
        return false;
    }
}
