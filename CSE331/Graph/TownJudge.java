
public class TownJudge {
    public static int townJudge(int n, int[][] trust) {
        int[] indegree = new int[n];
        
        for(int[] t : trust){
            int src = t[0];
            int dest = t[1];
            indegree[src]--;
            indegree[dest]++;
        }
        for(int i = 0;i<n;i++){
            if(indegree[i] == n-1){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] trust = {{0,1}, {0,3}, {0,2}, {2,1}, {2,3}, {3,1},{3,2},{4,1},{4,0}};
        int result = townJudge(n, trust);
        System.out.println(result);
    }
}