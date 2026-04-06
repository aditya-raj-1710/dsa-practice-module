import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraAlgo {
    public static void main(String[] args) {
        int V = 2, S = 0;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> node0 = new ArrayList<>(Arrays.asList(0,1, 9));
        adj.add(node0);

        ArrayList<Integer> node1 = new ArrayList<>(Arrays.asList(1,0, 9));
        adj.add(node1);

        DijkstraAlgoSolution sol = new DijkstraAlgoSolution();

        int[] ans = sol.dijkstraPriorityQueue(V, adj, S);

        System.out.print("The shortest distance of nodes from the source node is: ");
        for (int i = 0; i < V; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();

    }
}

class DijkstraAlgoSolution{
    public  int[] dijkstraPriorityQueue(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0), v = edge.get(1), w = edge.get(2);
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }


        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        int[] dist = new int[V];
        Arrays.fill(dist,(int)1e9);
        dist[S] = 0;
        pq.add(new int[]{0,S});

        while(!pq.isEmpty()){
            int dis = pq.peek()[0];
            int node = pq.peek()[1];
            pq.poll();

            for(int[] it: adj.get(node)){
                int adjNode = it[0];
                int edgeWt = it[1];

                if(dis + edgeWt < dist[adjNode]){
                    dist[adjNode] = dis+edgeWt;
                    pq.add(new int[]{dist[adjNode],adjNode});
                }
            }
        }
        return dist;
    }
}
