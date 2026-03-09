public class MaximumSumPath {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.right = new TreeNode(7);

        MaximumSumPathSolution solution = new MaximumSumPathSolution();

        int maxPathSum = solution.maxPathSum(root);
        System.out.println("Maximum Path Sum: " + maxPathSum);
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

class MaximumSumPathSolution {
    public int maxPathSum(TreeNode root) {
        int[] maximum = {Integer.MIN_VALUE};

        findMaximumPath(root, maximum);

        return maximum[0];
    }

    private int findMaximumPath(TreeNode root, int[] maximum){
        if(root == null){
            return 0;
        }

        int leftMax = Math.max(0, findMaximumPath(root.left,maximum));
        int rightMax = Math.max(0, findMaximumPath(root.right,maximum));

        maximum[0] = Math.max(maximum[0],leftMax+rightMax+root.data);

        return Math.max(leftMax,rightMax)+root.data;
    }
}
