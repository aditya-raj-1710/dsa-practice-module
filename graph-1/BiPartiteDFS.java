import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BiPartiteDFS {
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
        BiPartiteDFSSolution sol = new BiPartiteDFSSolution();

        // Function call to check if the given graph is bipartite
        boolean ans = sol.isBipartite(V, adj);

        // Output
        if (ans)
            System.out.println("The given graph is a bipartite graph.");
        else
            System.out.println("The given graph is not a bipartite graph.");
    }
}

class BiPartiteDFSSolution {
    public boolean isBipartite(int V, List<List<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!dfs(i, adj, color, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int node, List<List<Integer>> adj, int[] color, int col) {
        color[node] = col;

        for (int it : adj.get(node)) {
            if (color[it] == -1) {
                if (!dfs(it, adj, color, 1 - col)) {
                    return false;
                }
            } else if (color[it] == col) {
                return false;
            }
        }
        return true;
    }
}
