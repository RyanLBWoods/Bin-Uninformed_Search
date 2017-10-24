package search;
/**
 * CS5011-A2: Search-Rescue Simulation.
 * 
 * @author bl41
 *
 */

import java.util.ArrayList;

public class Node {
    public char status;
    private int x;
    private int y;
    ArrayList<Node> childNodes;
    
    Node leftChild;
    Node rightChild;
    
    public Node(char status, int x, int y, Node leftChild, Node rightChild){
        this.status = status;
        this.x = x;
        this.y = y;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
    
    public char getPosition(int x, int y){
        return status;
    }
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public ArrayList<Node> getChildren(){
        ArrayList<Node> childNodes = new ArrayList<>();
        if(this.leftChild !=null){
            childNodes.add(leftChild);
        }
        
        if(this.rightChild != null){
            childNodes.add(rightChild);
        }
        
        return childNodes;
    }
    
    public boolean removeChild(Node n){
        return false;
    }
}
