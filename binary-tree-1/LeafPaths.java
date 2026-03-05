import java.util.ArrayList;
import java.util.List;

public class LeafPaths {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        LeafPathsSolution solution = new LeafPathsSolution();
        System.out.println(solution.allRootToLeaf(root));
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class LeafPathsSolution {
    public List<List<Integer>> allRootToLeaf(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> allPaths = new ArrayList<>();

        dfs(root, path, allPaths);
        return allPaths;
    }

    private void dfs(TreeNode node, List<Integer> path, List<List<Integer>> allPaths){
        if(node==null){
            return;
        }
        path.add(node.data);

        if(node.left == null && node.right == null){
            allPaths.add(new ArrayList<>(path));
        }else{
            dfs(node.left, path,allPaths);
            dfs(node.right,path,allPaths);
        }
        path.remove(path.size()-1);
    }
}
