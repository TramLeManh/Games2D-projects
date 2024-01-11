package Events.graphs;

public class Location {
    int x;
    int y;
    String name = "ab";
   
    public int getX() { return x; }
     public int getY() { return y; }
     public String getName() {
         return name;
     }
    public Location(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }
}