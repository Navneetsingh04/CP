import java.util.LinkedList;
import java.util.Queue;

public class TopSort{
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for(int[] p : prerequisites){
            indegree[p[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            count++;
            for(int[] p : prerequisites){
                if(p[1] == course){
                    indegree[p[0]]--;
                    if(indegree[p[0]] == 0){
                        q.offer(p[0]);
                    }
                }
            }
        }
        return count == numCourses;
    }
    public static void main(String[] args) {
        int[][] prerequisites = {{2,0},{3,0},{1,2},{1,3},{4,2},{5,3},{5,4}};
        System.out.println(canFinish(6, prerequisites)); 
    }
}