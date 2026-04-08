import java.util.*;

public class MSTUsingPrim {
    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> edges = Arrays.asList(
                Arrays.asList(0, 1, 1),
                Arrays.asList(1, 2, 2),
                Arrays.asList(2, 3, 3),
                Arrays.asList(0, 3, 4)
        );

        // Forming the adjacency list from edges
        List<List<List<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);

            adj.get(u).add(Arrays.asList(v, wt));
            adj.get(v).add(Arrays.asList(u, wt));
        }

        // Creating instance of Solution class
        MSTUsingPrimSolution sol = new MSTUsingPrimSolution();

        /* Function call to get the sum
        of weights of edges in MST */
        int ans = sol.spanningTreePrim(V, adj);

        System.out.println("The sum of weights of edges in MST is: " + ans);
    }
}

class MSTUsingPrimSolution {
    public int spanningTreePrim(int V, List<List<List<Integer>>> adj) {
        boolean[] visited = new boolean[V];

        int sum =0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        pq.add(new int[]{0,0});

        while(!pq.isEmpty()){
            int[] p = pq.poll();

            int node = p[1];
            int wt = p[0];

            if(visited[node]){
                continue;
            }
            visited[node] = true;

            sum += wt;

            for(List<Integer> it : adj.get(node)){
                int adjNode = it.get(0);
                int adjWt = it.get(1);

                if(!visited[adjNode]){
                    pq.add(new int[]{adjWt,adjNode});
                }
            }
        }

        return sum;
    }
}