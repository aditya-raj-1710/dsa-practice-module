import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(10);
        root.right.left = new TreeNode(9);

        RightSideViewSolution solution = new RightSideViewSolution();

        // Get the Right View traversal
        List<Integer> rightView = solution.rightSideView(root);

        // Print the result for Right View
        System.out.print("Right View Traversal: ");
        for (int node : rightView) {
            System.out.print(node + " ");
        }
        System.out.println();
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

class RightSideViewSolution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverseRight(root,0,result);
        return result;
    }

    private void traverseRight(TreeNode root, int level, List<Integer> result) {
        if(root == null){
            return;
        }
        if(result.size()== level){
            result.add(root.data);
        }

        traverseRight(root.right,level+1,result);
        traverseRight(root.left,level+1,result);

        /// For left side view change the order of visiting children nodes
        // traverseRight(root.left,level+1,result);
        // traverseRight(root.right,level+1,result);
    }
}
