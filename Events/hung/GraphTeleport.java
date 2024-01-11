package Events.hung;
import java.util.*;
public class GraphTeleport {
   private Map<NodeMap,List<Edge>> mapEdge;
   public List<Edge> edges = new ArrayList<>();
   private NodeMap source;
   private NodeMap destination;
   private int mana;
   private String EdgeName;
   int count = 0;
   private int[][] graph;

   public Map<NodeMap, List<Edge>> getMapEdge() {
    return mapEdge;
  }
 
  
  public GraphTeleport(){
    mapEdge=new LinkedHashMap<>();
    mapNode=new LinkedHashMap<>();
  }
  public void setMapEdge(Map<NodeMap, List<Edge>> mapEdge) {
    this.mapEdge = mapEdge;
  }
  private Map<NodeMap,List<NodeMap>> mapNode;
   public void addEdge(Edge edge){
        NodeMap source=edge.getSource();
        NodeMap destination=edge.getDestination();
        mapEdge.computeIfAbsent(source, k -> new LinkedList<>()).add(edge);
        mapNode.computeIfAbsent(source, k -> new LinkedList<>()).add(destination);

   }
   public void addNode(NodeMap newNode){
     mapNode.put(newNode,new ArrayList<>());
     mapEdge.put(newNode,new ArrayList<>());
    count+=1;
   }

   
   public List<Edge> getAllEdges() {
    for (List<Edge> edgeList : mapEdge.values()) {
      edges.addAll(new ArrayList<>(edgeList));
    }
    
    return edges;
  }
  public void printEdges(){
    for (int i = 0; i < edges.size(); i++) {
      System.out.println((i+1)+". "+edges.get(i).toString() +" mana: "+ edges.get(i).getMana() + "\n");
  }
  }
  public List<Edge> getData(){
    return edges;
  }
  public void getEdges(String name){
    getAllEdges();
    int index = find(name);
    if (index!= -1){
      source = this.edges.get(index).getSource();
      destination = this.edges.get(index).getDestination();
      mana = this.edges.get(index).getMana();
      EdgeName =  this.edges.get(index).toString();

    }
    else{
      System.out.println("Error: " + name);
    }
   
  }
  public void getEdges(int index){
    getAllEdges();

    if (index!= -1){
      source = this.edges.get(index).getSource();
      destination = this.edges.get(index).getDestination();
      mana = this.edges.get(index).getMana();
      EdgeName =  this.edges.get(index).toString();

    }
    else{
      System.out.println("Error");
    }
   
  }
    private int find(String target){
    int index=-1;
    for (int i = 0; i < edges.size(); i++) {
      if (edges.get(i).toString().equals(target)) {
          index = i;
          break; // Exit the loop once the element is found
      }
  }

    return index;
    
}
public int getSourceX(){
  return this.source.getX();
}
public int getSourceY(){
  return this.source.getY();
}

public int getDestinationX(){
  return this.destination.getX();
}
public int getDestinationY(){
  return this.destination.getY();
}
public int getMana(){
   return mana;
}
public String getName(){
  return EdgeName;
}
public String getSourceName(){
  return source.getId();
}
public String getDestinationName(){
  return destination.getId();
}
private void makeGraph(){
  graph = new int[count][count];
 
  
}
public Map<NodeMap, NodeMap> shortestPathW(NodeMap start, NodeMap end) {
  Map<NodeMap, NodeMap> previous = new HashMap<>();
  Queue<NodeMap> queue = new LinkedList<>();
  Set<NodeMap> visited = new HashSet<>();
  Map<NodeMap, Double> distance = new HashMap<>();
  distance.put(start, 0.0);
  queue.add(start);
  visited.add(start);
  for (NodeMap node : mapNode.keySet()) {
      distance.put(node, Double.POSITIVE_INFINITY);
  }
  while (!queue.isEmpty()) {
      NodeMap current = queue.poll();

      for (Edge edge : mapEdge.get(current)) {
          NodeMap neighbor = edge.getDestination();
          double newDistance = distance.get(current) + edge.getMana();
          if (!visited.contains(neighbor) || newDistance < distance.get(neighbor)) {
              queue.add(neighbor);
              visited.add(neighbor);
              previous.put(neighbor, current);
          }
      }
  }

  return previous;
}

public void printGraph() {
      for (NodeMap node : mapNode.keySet()) {
          System.out.print("Node " + node.getId() + ": "+ node.getX() +" "+ node.getY());
          System.out.println();
      }
  }
  
  public List<NodeMap> shortestPath(NodeMap start, NodeMap end) {
    Map<NodeMap, NodeMap> previous = new HashMap<>();
    Queue<NodeMap> queue = new LinkedList<>();
    Set<NodeMap> visited = new HashSet<>();
    Map<NodeMap, Double> distance = new HashMap<>();
    queue.add(start);
    visited.add(start);
    distance.put(start, 0.0);

    while (!queue.isEmpty()) {
        NodeMap current = queue.poll();
        for (Edge edge : mapEdge.get(current)) {
            NodeMap neighbor = edge.getDestination();
            double newDistance = distance.get(current) + edge.getMana();
            if (!visited.contains(neighbor) || newDistance < distance.get(neighbor)) {
                queue.add(neighbor);
                visited.add(neighbor);
                distance.put(neighbor, newDistance);
                previous.put(neighbor, current);
            }
        }
    }

    return reconstructPathNode(previous, start, end);
}
private List<NodeMap> reconstructPathNode(Map<NodeMap, NodeMap> previous, NodeMap start, NodeMap end) {
  List<NodeMap> path = new ArrayList<>();

  NodeMap current = end;

  while (current != null) {
      path.add(current);
      current = previous.get(current);
  }

  Collections.reverse(path);
  return path;
}
public double reconstructW(Map<NodeMap, NodeMap> previous, NodeMap start, NodeMap end) {
List<NodeMap> path = new ArrayList<>();
double totalWeight = 0;

NodeMap current = end;

while (previous.containsKey(current)) {
    NodeMap previousNode = previous.get(current);

    for (Edge edge : mapEdge.get(previousNode)) {
        if (edge.getDestination().equals(current)) {
            totalWeight += edge.getMana();
            break;
        }
    }

    path.add(current);
    current = previousNode;
}

Collections.reverse(path);
return totalWeight;
}

   
}
