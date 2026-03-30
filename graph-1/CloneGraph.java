import java.util.*;

public class CloneGraph {
    public static GraphNode buildGraph(int[][] adj) {
        GraphNode[] nodes = new GraphNode[adj.length];
        for (int i = 0; i < adj.length; i++) nodes[i] = new GraphNode(i + 1);
        for (int i = 0; i < adj.length; i++)
            for (int nbr : adj[i])
                nodes[i].neighbors.add(nodes[nbr - 1]);
        return nodes[0];
    }

    // BFS print
    public static void printGraph(GraphNode root) {
        if (root == null) return;
        Set<Integer> visited = new HashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root.val);
        while (!queue.isEmpty()) {
            GraphNode cur = queue.poll();
            System.out.print(cur.val + ": ");
            for (GraphNode nbr : cur.neighbors) {
                System.out.print(nbr.val + " ");
                if (!visited.contains(nbr.val)) {
                    visited.add(nbr.val);
                    queue.add(nbr);
                }
            }
            System.out.println();
        }
    }

    // Main driver
    public static void main(String[] args) {
        int[][] adjList = {{2,4},{1,3},{2,4},{1,3}};
        GraphNode root = buildGraph(adjList);
        CloneGraphSolution sol = new CloneGraphSolution();
        GraphNode cloned = sol.cloneGraph(root);
        System.out.println("Original Graph:");
        printGraph(root);
        System.out.println("Cloned Graph:");
        printGraph(cloned);
    }
}


class CloneGraphSolution {
    public GraphNode cloneGraph(GraphNode GraphNode) {
        if(GraphNode == null){
            return null;
        }

        return dfs(GraphNode, new HashMap<>());
    }

    private GraphNode dfs(GraphNode GraphNode, Map<Integer, GraphNode> visited){
        if(visited.containsKey(GraphNode.val))
            return visited.get(GraphNode.val);

        GraphNode clone = new GraphNode(GraphNode.val);

        visited.put(GraphNode.val, clone);

        for(GraphNode nbr: GraphNode.neighbors){
            clone.neighbors.add(dfs(nbr, visited));
        }

        return clone;
    }
}
