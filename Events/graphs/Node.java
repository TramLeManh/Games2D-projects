package Events.graphs;
public class Node {
    Node next;
    Location l;
    public Node(Location l) {
        this.l = l;
    }
    public Location getData() {
        return l;
    }
    public Node getNext() {
        return next;
    }
}
