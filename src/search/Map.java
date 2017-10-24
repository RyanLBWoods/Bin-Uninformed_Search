package search;

public class Map {

    private int x;
    private int y;
    public char[][] map;
    public int xlength;
    public int ylength;
    
    public Map(char[][] map) {
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; i < map[i].length; j++) {
                this.map[i][j] = map[i][j];
            }
        }
        this.xlength = 10;
        this.ylength = 10;
    }
    
    
}
