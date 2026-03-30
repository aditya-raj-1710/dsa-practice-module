import java.util.ArrayList;
import java.util.List;

class GraphNode {
    // Node value
    public int val;
    // List of neighbors
    public List<GraphNode> neighbors;
    // Constructor
    public GraphNode(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }
}