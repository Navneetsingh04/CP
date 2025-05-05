public class ConnectedComponent{
    private static void dfs(int[][] graph, boolean[] visited, int vertex) {
        visited[vertex] = true;
        for (int i = 0; i < graph[vertex].length; i++) {
            if (graph[vertex][i] == 1 && !visited[i]) {
                dfs(graph, visited, i);
            }
        }
    }   
    public static int countConnectedComponents(int[][] graph) {
        int count = 0; 
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) { 
                dfs(graph, visited, i); 
                count++; 
            }
        }
        return count;
    }
    public static void main(){
        int[][] graph = {
            {0, 1, 0, 0, 1},
            {1, 0, 1, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 1, 0, 1},
            {1, 0, 0, 1, 0}
        };
        System.out.println("Number of connected components: " + countConnectedComponents(graph));
    }
}