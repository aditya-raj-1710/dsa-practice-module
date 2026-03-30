import java.util.*;

public class GraphTraversal {
    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).addAll(Arrays.asList(2, 3, 1));
        adj.get(1).add(0);
        adj.get(2).addAll(Arrays.asList(0, 4));
        adj.get(3).add(0);
        adj.get(4).add(2);

        GraphTraversalSolution sol = new GraphTraversalSolution();

        List<Integer> bfs = sol.bfsOfGraph(V, adj);
        List<Integer> dfs = sol.dfsOfGraph(V, adj);

        System.out.println("The BFS traversal of the given graph is: " + bfs);
        System.out.println("The DFS traversal of the given graph is: " + dfs);
    }
}

class GraphTraversalSolution {
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        List<Integer> ans = new ArrayList<>();
        dfs(0,adj,visited,ans);
        return ans;
    }
    private void dfs(int node,List<List<Integer>> adj, boolean[] visited, List<Integer> ans){
        visited[node] = true;
        ans.add(node);

        for(int neighbor: adj.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor, adj, visited, ans);
            }
        }
    }

    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        List<Integer> ans = new ArrayList<>();
        bfs(0,adj,visited,ans);
        return ans;
    }



    private void bfs(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> ans){
        visited[node] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            int curr = q.poll();
            ans.add(curr);

            for(int neighbor: adj.get(curr)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }
    }
}


