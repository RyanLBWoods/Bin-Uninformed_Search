package search;

import java.util.ArrayList;

/**
 * CS5011-A2: Search-Rescue Simulation.
 * 
 * @author bl41
 *
 */
public class Search {
    
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
//        ArrayList<char> nodes = new ArrayList<>();
       
        Map map = new Map(map1);
//        for(int i = 0; i < map.xlength; i++){
//            for(int j = 0; j < map.ylength; j++) {
//                System.out.println(map.toString());
//            }
//        }
        System.out.println(map.xlength);
    }

}
