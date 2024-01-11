package Events.hung;

import java.util.List;
import java.util.Map;

public class MapApp {
    int[][]array = new int[7][3];
    int shortWeight;

  private GraphTeleport graph; // declare a field to store the graph
  private Edge ab, ac, ad, ae, bc, bd, be, ba, ca, cb, cd, ce, da, db, dc, de, ea, eb, ec, ed,cf,df,ef;

  public GraphTeleport getGraph() { // create a getter method to access the graph
    return graph;
  }
  public int getIndex(int i ,int j ){
    return array[i][j];
  }

  public void CreateMap() {
    NodeMap A = new NodeMap(166, 20, "A");
    NodeMap B = new NodeMap(205, 20, "B");
    NodeMap C = new NodeMap(189, 57, "C");
    NodeMap D = new NodeMap(180, 39, "D");
    NodeMap E = new NodeMap(222, 39, "E");
    NodeMap F = new NodeMap(70, 74, "F");

    ab = new Edge(A, B, 1);
    ac = new Edge(A, C, 2);
    ad = new Edge(A, D, 3);
    ae = new Edge(A, E, 4);

    ca = new Edge(C, A, 4);
    cd = new Edge(C, D, 5);
    ce = new Edge(C, E, 6);
    cb = new Edge(C, B, 7);
     cf = new Edge(C, F, 10);

    ba = new Edge(B, A, 8);
    bc = new Edge(B, C, 8);
    bd = new Edge(B, D, 9);
    be = new Edge(B, E, 3);
    

    da = new Edge(D, A, 2);
    dc = new Edge(D, C, 8);
    de = new Edge(D, E, 4);
    db = new Edge(D, B, 5);
    df = new Edge(D, F, 7);

    ea = new Edge(E, A, 6);
    eb = new Edge(E, B, 4);
    ec = new Edge(E, C, 9);
    ed = new Edge(E, D, 3);
    ef = new Edge(E,F,5);

    graph = new GraphTeleport();
    graph.addNode(A);
    graph.addNode(B);
    graph.addNode(C);
    graph.addNode(D);
    graph.addNode(E);
      graph.addNode(F);
    createGraph(graph);
  
    graph.getAllEdges();
    graph.printEdges();
    shortestPath(A, F);
 
   

    // graph.addEdge(cd);//3
    // graph.addEdge(db);//4
    // graph.addEdge(ce);//5
    // graph.addEdge(ca);//6
    // graph.addEdge(ed);//7
   

  
  }

  public void shortestPath(NodeMap startNode, NodeMap endNode) {
    // Find the shortest path
    Map<NodeMap, NodeMap> shortestPathPrevious = graph.shortestPathW(
      startNode,
      endNode
    );
    double shortestPathWeight = graph.reconstructW(
      shortestPathPrevious,
      startNode,
      endNode
    );

    // Print the shortest path and its weight
    List<NodeMap> ln = graph.shortestPath(startNode, endNode);
    System.out.println(
      "Shortest Path from " +
      startNode.getId() +
      " to " +
      endNode.getId() +
      ": "
    );
    for (int i = 0; i < ln.size(); i++) {
      System.err.print(ln.get(i).getId() + " ");
    }
    System.err.println();

    System.out.println("Shortest Path Weight: " + shortestPathWeight);
    this.shortWeight = (int)shortestPathWeight;
  
  }

  public static void main(String[] args) {
    MapApp mapApp = new MapApp(); // create a MapApp object
    mapApp.CreateMap(); // call the CreateMap() method
    GraphTeleport g = mapApp.getGraph(); // get the graph object
   

// print
    // System.out.println("Source name " +g.getSourceName() + " Destination name " + g.getDestinationName());
    // System.out.println("Source x " + g.getSourceX() + " Source y " + g.getSourceY() + "\nDestination X "+ g.getDestinationX() + " Destination Y "+ g.getDestinationY());
    // System.out.println(g.getName() + " Mana: "+g.getMana());

  }

  public void add( int index) {
    switch (index) {
      case 1:
        graph.addEdge(ab); //0
        break;
      case 2:
        graph.addEdge(ac); //0
        break;
      case 3:
        graph.addEdge(ad); //0
        break;
      case 4:
        graph.addEdge(ae); //0
        break;
      case 5:
        graph.addEdge(ba); //0
        break;
      case 6:
        graph.addEdge(bc); //0
        break;
      case 7:
        graph.addEdge(bd); //0
        break;
      case 8:
        graph.addEdge(be); //0
        break;
     
      case 9:
        graph.addEdge(ca); //0
        break;
      case 10:
        graph.addEdge(cb); //0
        break;
      case 11:
        graph.addEdge(cd); //0
        break;
      case 12:
        graph.addEdge(ce); //0
        break;
      case 13:
       graph.addEdge(cf); //0
      case 14:
        graph.addEdge(da); //0
        break;
      case 15:
        graph.addEdge(db); //0
        break;
      case 16:
        graph.addEdge(dc); //0
        break;
      case 17:
        graph.addEdge(de); //0
        break;
        case 18:
         graph.addEdge(df); //0
        break;
      case 19:
        graph.addEdge(ea); //0
        break;
      case 20:
        graph.addEdge(eb); //0
        break;
      case 21:
        graph.addEdge(ec); //0
        break;
      case 22:
        graph.addEdge(ed); //0
        break;
       case 23:
        graph.addEdge(ef); //0
        break;
      default:
      System.out.println("error");
        break;
    }
  }
   
  public void createGraph( GraphTeleport g) {
    random r = new random();
    array = r.getArray();
    for (int i = 1; i <6; i++) {
        for (int j = 1; j < 4; j++) {
         add(array[i][j]);
        }   
      }
  }
  public void reset(){
    random r = new random();
    array = r.getArray();
    for (int i = 1; i <6; i++) {
        for (int j = 1; j < 4; j++) {
         add(array[i][j]);
        }   
      }
  }
  public int getshortWeight(){
    return shortWeight;
}
}