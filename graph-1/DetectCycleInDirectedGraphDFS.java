import java.util.ArrayList;
import java.util.List;

public class DetectCycleInDirectedGraphDFS {
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

        DetectCycleInDirectedGraphDFSSolution sol = new DetectCycleInDirectedGraphDFSSolution();

        boolean ans = sol.isCyclic(V, adj);

        if(ans)
            System.out.println("The given directed graph contains a cycle.");
        else
            System.out.println("The given directed graph does not contain a cycle.");
    }
}

class DetectCycleInDirectedGraphDFSSolution {
    public boolean isCyclic(int N, List<List<Integer>> adj) {
        boolean[] visted = new boolean[N];
        boolean[] pathVisited = new boolean[N];

        for(int i=0;i<N;i++){
            if(!visted[i]){
                if(dfs(i,adj,visted,pathVisited)){
                    return true;
                }
            }
        }
        return false;

    }

    private boolean dfs(int node, List<List<Integer>> adj, boolean[] visted, boolean[] pathVisited){
        visted[node] = true;
        pathVisited[node] = true;

        for(int neighbor: adj.get(node)){
            if(!visted[neighbor]){
                if(dfs(neighbor,adj,visted,pathVisited)){
                    return true;
                }
            }else if(pathVisited[neighbor]){
                return true;
            }
        }

        pathVisited[node] = false;
        return false;
    }
}

