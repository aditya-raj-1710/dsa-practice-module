public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.right = new TreeNode(7);

        // Creating an instance of the Solution class
        BalancedBinaryTreeSolution solution = new BalancedBinaryTreeSolution();

        // Checking if the tree is balanced
        if (solution.isBalanced(root)) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }
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

class BalancedBinaryTreeSolution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = dfs(root.left);
        if(left == -1){
            return -1;
        }

        int right = dfs(root.right);
        if(right == -1){
            return  -1;
        }

        if(Math.abs(left-right)>1){
            return  -1;
        }

        return Math.max(left,right)+1;
    }
}
