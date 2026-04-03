import java.util.*;

public class BiPartiteBFS {
    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(3);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(0);
        adj.get(3).add(2);

        // Creating an instance of Solution class
        BiPartiteBFSSolution sol = new BiPartiteBFSSolution();

        // Function call to check if the given graph is bipartite
        boolean ans = sol.isBipartite(V, adj);

        // Output
        if (ans)
            System.out.println("The given graph is a bipartite graph.");
        else
            System.out.println("The given graph is not a bipartite graph.");
    }
}

class BiPartiteBFSSolution {
    public boolean isBipartite(int V, List<List<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color,-1);

        for(int i=0;i<V;i++){
            if(color[i] == -1 && !bfs(i,adj,color)){
                return false;
            }
        }
        return true;
    }

    private boolean bfs(int node, List<List<Integer>> adj, int[] color){
        color[node] =0;
        Queue<Integer> q= new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty()){
            int n = q.poll();

            for(int it: adj.get(n)){
                if(color[it] == -1){
                    color[it] = 1- color[n];
                    q.offer(it);
                }else if( color[it] == color[n]){
                    return false;
                }
            }
        }
        return true;
    }
}
