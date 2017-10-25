package search;
/**
 * CS5011-A2: Search-Rescue Simulation.
 * 
 * @author bl41
 *
 */

import java.util.LinkedList;

public class Node {
    // public char status;
    private int x;
    private int y;
    public char flag;
    public char value;
    LinkedList<Node> childNodes;
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

    // Get child nodes of node
    public LinkedList<Node> getChildren() {
        return childNodes;
    }

    // Remove child node
    public boolean removeChild(Node n) {
        return false;
    }
}
