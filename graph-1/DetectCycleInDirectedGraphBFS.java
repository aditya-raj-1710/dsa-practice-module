import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInDirectedGraphBFS {
    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(2); adj.get(1).add(5);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(4).add(1);

        DetectCycleInDirectedGraphBFSSolution sol = new DetectCycleInDirectedGraphBFSSolution();

        boolean ans = sol.isCyclic(V, adj);

        if(ans)
            System.out.println("The given directed graph contains a cycle.");
        else
            System.out.println("The given directed graph does not contain a cycle.");
    }
}

class DetectCycleInDirectedGraphBFSSolution {
    public boolean isCyclic(int N, List<List<Integer>> adj) {
        List<Integer> topo = topoSort(N, adj);

        if(topo.size() < N) return true;
        return false;

    }

    private List<Integer> topoSort(int V, List<List<Integer>> adj){
        List<Integer> ans = new ArrayList<>();

        int[] inDegree = new int[V];

        for(int i=0; i< V;i++){
            for(int it: adj.get(i)){
                inDegree[it]++;
            }
        }
        Queue<Integer> q = new  LinkedList<>();

        for(int i=0;i<V;i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);

            for(int it: adj.get(node)){
                inDegree[it] --;

                if(inDegree[it]==0){
                    q.offer(it);
                }
            }
        }
        return ans;
    }

    /// LeetCode solution
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }

        List<Integer> topo = topoSort(numCourses, adj);

        if(topo.size() == numCourses) return true;
        return false;
    }
}

