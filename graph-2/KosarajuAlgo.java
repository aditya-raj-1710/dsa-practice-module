import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgo {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(1).add(0);
        adj.get(2).add(1);
        adj.get(3).add(4);

        KosarajuAlgoSolution sol = new KosarajuAlgoSolution();
        int count = sol.kosaraju(V, adj);
        System.out.println("Number of strongly connected components: " + count);
    }
}

class KosarajuAlgoSolution {
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];

        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,adj,visited,st);
            }
        }

        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();

        for(int i=0;i<V;i++){
            adjT.add(new ArrayList<>());
        }

        for(int i=0;i<V;i++){
            visited[i] = false;
            for(int it: adj.get(i)){
                adjT.get(it).add(i);
            }
        }

        int count =0;

        while(!st.isEmpty()){
            int node = st.pop();

            if(!visited[node]){
                count++;
                dfs(node, adjT,visited);
            }
        }

        return count;
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adjT, boolean[] visited){
        visited[node] = true;

        for(int it: adjT.get(node)){
            if(!visited[it]){
                dfs(it, adjT, visited);
            }
        }
    }
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st){
        visited[node] = true;

        for(int it: adj.get(node)){
            if(!visited[it]){
                dfs(it, adj, visited,st);
            }
        }
        st.push(node);
    }

}

