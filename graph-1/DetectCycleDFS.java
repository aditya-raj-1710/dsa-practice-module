import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetectCycleDFS {
    public static void main(String[] args) {
        int V = 6;
        List<Integer> adj[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].addAll(Arrays.asList(1, 3));
        adj[1].addAll(Arrays.asList(0, 2, 4));
        adj[2].addAll(Arrays.asList(1, 5));
        adj[3].addAll(Arrays.asList(0, 4));
        adj[4].addAll(Arrays.asList(1, 3, 5));
        adj[5].addAll(Arrays.asList(2, 4));

        DetectCycleDFSSolution sol = new DetectCycleDFSSolution();

        boolean ans = sol.isCycle(V, adj);

        if (ans)
            System.out.println("The given graph contains a cycle.");
        else
            System.out.println("The given graph does not contain a cycle.");
    }
}

class DetectCycleDFSSolution {
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,-1))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, List<Integer>[] adj, boolean[] visited, int parent){
        visited[node] = true;

        for(int neighbor: adj[node]){
            if(!visited[neighbor]){
                if(dfs(neighbor,adj,visited,node))
                    return true;
            }else if(neighbor != parent){
                return true;
            }
        }
        return false;
    }
}

