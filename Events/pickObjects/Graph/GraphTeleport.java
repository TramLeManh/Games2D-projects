package Events.pickObjects.Graph;
import java.util.*;

import org.w3c.dom.Node;
public class GraphTeleport {
   private Map<NodeMap,List<Edge>> mapEdge;
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
    
   }
   public List<Edge> getAllEdges() {
    List<Edge> edges = new ArrayList<>();
    for (List<Edge> edgeList : mapEdge.values()) {
      edges.addAll(new ArrayList<>(edgeList));
    }
    
    return edges;
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
