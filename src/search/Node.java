package search;
/**
 * CS5011-A2: Search-Rescue Simulation.
 * 
 * @author bl41
 *
 */

import java.util.LinkedList;

public class Node {
    private int x;
    private int y;
    public LinkedList<Node> children = new LinkedList<>();
    public String parent = null;
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    
}
