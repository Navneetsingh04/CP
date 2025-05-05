import java.util.Arrays;

public class BellmanFord {
    public static int[] bellmanFord(int[][] edges,int V, int source){
        int n = edges.length;
        int[] dist = new int[V];
        Arrays.fill(dist,(int)1e9);
        dist[source] = 0;
        for(int i = 0;i<V-1;i++){
            for(int j = 0;j<n;j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                int weight = edges[j][2];
                if(dist[u] != (int)1e9 && dist[u]+weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }
        for(int j = 0;j<n; j++){
            int u = edges[j][0];
            int v = edges[j][1];
            int weight = edges[j][2];
            if(dist[u] != (int)1e9 && dist[u] + weight < dist[v]){
                System.out.println("negative-cycle detected");
                return null;
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int[][] edges ={
            {0, 3, -4},
            {0, 1, 2},
            {0, 1, 2},
            {1, 2, -3},
            {2, 3, 5},
            {3, 4, 6},
            {4, 5, 3}
        };
        int[][] edges1 ={
            {0, 3, 5},
            {0, 1, 6},
            {0, 2, 4},
            {1, 4, -1},
            {2, 1, -2},
            {2, 4, 3},
            {3, 2, -2},
            {3, 5, -1},
            {4, 5, 3},
        };
        int source = 0;
        int vertices = 6;
        int[] dist = bellmanFord(edges,vertices, source);
        int[] dist1 = bellmanFord(edges1,vertices, source);
        System.out.println(Arrays.toString(dist));
        System.out.println(Arrays.toString(dist1));
    }
}
