package Events.hung;

public class Edge {
    private NodeMap source,destination;
    String name;
    public NodeMap getSource() {
        return source;
    }
    public void setSource(NodeMap source) {
        this.source = source;
    }
    public NodeMap getDestination() {
        return destination;
    }
    public void setDestination(NodeMap destination) {
        this.destination = destination;
    }
    private int mana;
    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public Edge(NodeMap s,NodeMap d, int mana){
        this.source=s;
        this.destination=d;
        this.mana=mana;
        this.name  = s.getId()+d.getId();
    }
    @Override
    public String toString() {
        return this.name;
    }
    
}
