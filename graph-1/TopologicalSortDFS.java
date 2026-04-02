import java.util.*;

public class TopologicalSortDFS {
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

        TopologicalSortDFSSolution sol = new TopologicalSortDFSSolution();

        int[] ans = sol.topoSort(V, adj);

        System.out.println("The topological sorting of the given graph is:");
        for (int i = 0; i < V; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}

class TopologicalSortDFSSolution {
    public int[] topoSort(int V, List<List<Integer>> adj) {
        int[] visited = new int[V];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<V;i++){
            if(visited[i] ==0){
                dfs(i,adj,visited,st);
            }
        }

        int[] ans = new int[V];
        for(int i=0; i<V;i++){
            ans[i] = st.pop();
        }

        return ans;
    }

    private void dfs(int node, List<List<Integer>> adj, int[] visited, Stack<Integer> st){
        visited[node] = 1;

        for(int it: adj.get(node)){
            if(visited[it] == 0){
                dfs(it,adj,visited,st);
            }
        }
        st.push(node);
    }
}