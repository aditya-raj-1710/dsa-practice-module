import java.util.*;

public class DetectCycleBFS {
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

        DetectCycleBFSSolution sol = new DetectCycleBFSSolution();

        boolean ans = sol.isCycle(V, adj);

        if (ans)
            System.out.println("The given graph contains a cycle.");
        else
            System.out.println("The given graph does not contain a cycle.");
    }
}

class DetectCycleBFSSolution {
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];
        boolean ans = false;
        for(int i=0;i<V;i++){
            if(!visited[i]){
                ans = bfs(i,adj,visited);
                if(ans) break;
            }
        }
        return ans;
    }

    private boolean bfs(int node, List<Integer>[] adj, boolean[] visited){
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{node,-1});
        visited[node] = true;

        while(!q.isEmpty()){
            int[] current = q.poll();
            int currNode = current[0];
            int parent = current[1];

            for(int neighbor: adj[currNode]){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    q.add(new int[]{neighbor,currNode});
                }else if( neighbor != parent){
                    return true;
                }
            }
        }
        return false;
    }
}
