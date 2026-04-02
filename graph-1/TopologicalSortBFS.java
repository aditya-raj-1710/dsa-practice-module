import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortBFS {
    public static void main(String[] args) {
        int V = 6;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        TopologicalSortBFSSolution sol = new TopologicalSortBFSSolution();

        int[] ans = sol.topoSort(V, adj);

        System.out.println("The topological sorting of the given graph is:");
        for (int i = 0; i < V; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}

class TopologicalSortBFSSolution {
    public int[] topoSort(int V, List<List<Integer>> adj) {
        int[] inDegree = new int[V];
        for(int i=0;i<V;i++){
            for(int neigh: adj.get(i)){
                inDegree[neigh]++;
            }
        }

        int[] ans = new int[V];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }

        int idx=0;

        while(!q.isEmpty()){
            int node = q.poll();
            ans[idx++]=node;

            for(int neigh : adj.get(node)){
                inDegree[neigh]--;
                if(inDegree[neigh] == 0){
                    q.offer(neigh);
                }
            }
        }

        return ans;
    }
}