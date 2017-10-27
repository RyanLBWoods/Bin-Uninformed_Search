package search;
/**
 * CS5011-A2: Search-Rescue Simulation.
 * 
 * @author bl41
 *
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Node {
    // public char status;
    private int x;
    private int y;
    public char flag;
    public char value;
    Node uChild;
    Node dChild;
    Node lChild;
    Node rChild;
    Node parent;

    // Node constructor
    public Node(int x, int y, char value) {
        this.x = x;
        this.y = y;
        this.value = value;
        if (value == 'O') {
            this.flag = 1;
        } else if (value == 'X') {
            this.flag = 0;
        }
    }

    // Get value of node
    public char getValue() {
        return value;
    }

    // Get x coordinate of node
    public int getX() {
        return x;
    }

    // Get y coordinate of node
    public int getY() {
        return y;
    }

    // Get location of node
    public int[] getLocation(){
        int[] location = {x, y};
        return location;
    }
    // Get child nodes of node
    public LinkedList<Node> getChildren() {
        LinkedList<Node> childNodes = new LinkedList<>();
        if(this.dChild != null){
            childNodes.add(dChild);
        }
        if(this.rChild != null){
            childNodes.add(rChild);
        }
        if(this.uChild != null){
            childNodes.add(uChild);
        }
        if(this.lChild != null){
            childNodes.add(lChild);
        }
        return childNodes;
    }

    public boolean checkNode(Queue<Node> q, Node node){
        Queue<Node> temp = q;
        for(int i = 0; i < q.size();i++){
            Node check = temp.remove();
            if(Arrays.equals(check.getLocation(), node.getLocation())){
                return false;
            }
        }
        return true;
    }
}
