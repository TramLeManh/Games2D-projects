package Events.hung;

import java.util.*;

public class test {
    private static final int INFINITY = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] graph = {
            {0, 2, 4, 1, INFINITY},
            {2, 0, INFINITY, 3, INFINITY},
            {4, INFINITY, 0, INFINITY, 5},
            {1, 3, INFINITY, 0, 2},
            {INFINITY, INFINITY, 5, 2, 0}
        };
        int[][] graphs = {
        {0,3,2,INFINITY,INFINITY},
       {INFINITY,0,INFINITY,4,2},            
       {INFINITY,INFINITY,0,1,4},
       {INFINITY,INFINITY,INFINITY,0,3},    
        {INFINITY,INFINITY,INFINITY,INFINITY,0},        
        };

        int startNode = 0; // Index of the start node (A)
        int[] distances = dijkstra(graphs, startNode);

        // Print the shortest distances from the start node to all other nodes
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Shortest distance from A to " + (char)('A' + i) + ": " + distances[i]);
        }
    }

    public static int[] dijkstra(int[][] graph, int startNode) {
        int n = graph.length;
        int[] distances = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(distances, INFINITY);
        distances[startNode] = 0;

        for (int i = 0; i < n - 1; i++) {
            int minDistanceNode = getMinDistanceNode(distances, visited);
            visited[minDistanceNode] = true;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && graph[minDistanceNode][j] != INFINITY && distances[minDistanceNode] != INFINITY
                        && distances[minDistanceNode] + graph[minDistanceNode][j] < distances[j]) {
                    distances[j] = distances[minDistanceNode] + graph[minDistanceNode][j];
                }
            }
        }

        return distances;
    }

    public static int getMinDistanceNode(int[] distances, boolean[] visited) {
        int minDistance = INFINITY;
        int minDistanceNode = -1;

        for (int i = 0; i < distances.length; i++) {
            if (!visited[i] && distances[i] < minDistance) {
                minDistance = distances[i];
                minDistanceNode = i;
            }
        }

        return minDistanceNode;
    }
}
