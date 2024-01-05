package Events.pickObjects.Graph;

public class MapApp {
    private GraphTeleport graph; // declare a field to store the graph

    public GraphTeleport getGraph() { // create a getter method to access the graph
        return graph;
  }
    public void CreateMap(){
    NodeMap A=new NodeMap(29,79,"A");
    NodeMap B=new NodeMap(79,8,"B");
    NodeMap C=new NodeMap(44,71,"C");
    NodeMap D=new NodeMap(44,80,"A");
    NodeMap E=new NodeMap(70,74,"E");
    
    Edge ab=new Edge(A,B,8);
    Edge bc=new Edge(B,C,10);
    Edge cd=new Edge(C,D,7);
    Edge db=new Edge(D,B,6);
    Edge ce=new Edge(C,E,14);
    Edge ca=new Edge(C,A,9);
    Edge ed=new Edge(E,D,5);

    graph = new GraphTeleport();
    graph.addNode(A);
    graph.addNode(B);
    graph.addNode(C);
    graph.addNode(D);
    graph.addNode(E);   

    graph.addEdge(ab);
    graph.addEdge(bc);
    graph.addEdge(cd);
    graph.addEdge(db);
    graph.addEdge(ce);
    graph.addEdge(ca);
    graph.addEdge(ed);
    
    }
}
