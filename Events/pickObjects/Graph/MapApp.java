package Events.pickObjects.Graph;

import java.util.List;
import java.util.Map;

import org.w3c.dom.Node;

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

    graph.printGraph();
    
    NodeMap startNode = A; // Replace with your actual start node (e.g., A)
    NodeMap endNode = E;   // Replace with your actual end node (e.g., K)

        // Find the shortest path
        Map<NodeMap, NodeMap> shortestPathPrevious = graph.shortestPathW(startNode, endNode);
        double shortestPathWeight = graph.reconstructW(shortestPathPrevious, startNode, endNode);

        // Print the shortest path and its weight
        List<NodeMap> ln= graph.shortestPath(startNode, endNode);
        System.out.println("Shortest Path from " + startNode.getId() + " to " + endNode.getId() + ": "
               );
        for (int i=0;i<ln.size();i++){
            System.err.print(ln.get(i).getId()+" ");
        }
        System.err.println();       
        System.out.println("Shortest Path Weight: " + shortestPathWeight);

    }
}
