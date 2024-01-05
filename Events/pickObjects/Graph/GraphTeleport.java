package Events.pickObjects.Graph;
import java.util.*;
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
  
 
   
}
