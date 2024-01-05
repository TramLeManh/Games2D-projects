package Events.pickObjects.Graph;

public class NodeMap {
    private int x,y;
    private String id;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    
    public NodeMap(int x, int y,String id){
        this.x=x;
        this.y=y;
        this.id=id;
    }

}
