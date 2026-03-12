public class SymmetricBinaryTree {
    public static void main(String[] args) {
        SymmetricBinaryTreeSolution solution = new SymmetricBinaryTreeSolution();

        // Create a sample tree: 1, 2, 2, 3, 4, 4, 3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        // Test the symmetric tree
        System.out.println(solution.isSymmetric(root));
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

class SymmetricBinaryTreeSolution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return symmetric(root.left,root.right);
    }

    private boolean symmetric(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }


        if(left == null || right == null){
            return false;
        }

        if(left.data != right.data){
            return false;
        }

        return symmetric(left.left, right.right) && symmetric(left.right, right.left);
    }
}
