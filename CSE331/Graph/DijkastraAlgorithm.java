// Time Complexity: O(V^2)
// Space Complexity: O(V)

import java.util.ArrayList;
import java.util.List;
public class DijkastraAlgorithm {
    public static final int V = 6; 
    public static int minDistance(int dist[], Boolean vis[]){
        int min = Integer.MAX_VALUE, min_index = -1;
        for(int v = 0; v < V; v++){
            if(!vis[v] && dist[v] <= min){
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }
    public static void dijkstra(int graph[][], int src){
        int dist[] = new int[V];
        Boolean vis[] = new Boolean[V];

        for(int i = 0;i < V;i++){
            dist[i] = Integer.MAX_VALUE;
            vis[i] = false;
        }
        dist[src] = 0;
        for(int count = 0;count < V - 1;count++){
            int u = minDistance(dist, vis);
            vis[u] = true;

            for(int v = 0; v < V; v++){
                if(!vis[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        printSolution(dist, src);
    }
    public static void printSolution(int dist[], int src) {
        List<Integer> distances = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            distances.add(dist[i]);
        }
        System.out.println("Vertex \t Distance from Source " + src);
        for (int i = 0; i < distances.size(); i++) {
            System.out.println(i + " \t\t " + distances.get(i));
        }
    }
    public static void main(String[] args) {
        int[][] graph = {
            {0, 7, 9, 0, 0, 14},
            {7, 0, 10, 15, 0, 0},
            {9, 10, 0, 11, 0, 2},
            {0, 15, 11, 0, 6, 0},
            {0, 0, 0, 6, 0, 9},
            {14, 0, 2, 0, 9, 0}
        };
        int source = 0; 
        dijkstra(graph, source);
    }
}
