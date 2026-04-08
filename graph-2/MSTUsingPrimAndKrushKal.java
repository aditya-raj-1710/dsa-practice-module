import java.util.*;

public class MSTUsingPrimAndKrushKal {
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
        MSTUsingPrimAndKrushKalSolution sol = new MSTUsingPrimAndKrushKalSolution();

        /* Function call to get the sum
        of weights of edges in MST */
        int ans = sol.spanningTreePrim(V, adj);

        System.out.println("The sum of weights of edges in MST is: " + ans);

        int ans2 = sol.spanningTreeKrushkal(V, adj);

        System.out.println("The sum of weights of edges in MST is: " + ans2);
    }
}

class MSTUsingPrimAndKrushKalSolution {
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

    public int spanningTreeKrushkal(int V, List<List<List<Integer>>> adj) {
        List<int[]> edges = new ArrayList<>();

        for(int i=0;i<V;i++){
            for(List<Integer> it: adj.get(i)){
                int v= it.get(0);
                int wt = it.get(1);
                int u=i;
                edges.add(new int[]{wt,u,v});
            }
        }

        DisjointSet ds = new DisjointSet(V);
        edges.sort(Comparator.comparingInt(a ->a[0]));

        int sum=0;

        for(int[] it: edges){
            int wt = it[0];
            int u=it[1];
            int v= it[2];

            if(ds.findUPar(u) != ds.findUPar(v)){
                sum += wt;
                ds.unionBySize(u,v);
            }
        }
        return sum;
    }
}

class DisjointSet {
    /* To store the ranks, parents and
    sizes of different set of vertices */
    List<Integer> rank, parent, size;

    // Constructor
    public DisjointSet(int n) {
        rank = new ArrayList<>(n + 1);
        Collections.fill(rank, 0);
        parent = new ArrayList<>(n + 1);
        size = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    // Function to find ultimate parent
    public int findUPar(int node) {
        if (node == parent.get(node))
            return node;
        parent.set(node, findUPar(parent.get(node)));
        return parent.get(node);
    }

    // Function to implement union by rank
    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        }
        else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        }
        else {
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u) + 1);
        }
    }

    // Function to implement union by size
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }
        else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}