public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        DiameterOfBinaryTreeSolution sol = new DiameterOfBinaryTreeSolution();
        System.out.println("Diameter of the binary tree is: " + sol.diameterOfBinaryTree(root));
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

class DiameterOfBinaryTreeSolution {
    /// Optimal approach - by keeping track of value of maximum at
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        diameter[0] =0;
        height(root, diameter);

        return diameter[0];
    }

    private int height(TreeNode root, int[] diameter) {
        if(root== null){
            return  0;
        }

        int lh = height(root.left,diameter);
        int rh = height(root.right,diameter);

        diameter[0] = Math.max(diameter[0], lh+rh);

        return 1+Math.max(lh,rh);
    }

    /// Non-optimal approach - as height is recalculated every time for different level
    public int diameterOfBinaryTreeBrute(TreeNode root) {
        if(root == null){
            return 0;
        }

        int lHeight = heightBrute(root.left);
        int rHeight = heightBrute(root.right);

        int currDiameter = lHeight + rHeight;

        int lDiameter = diameterOfBinaryTreeBrute(root.left);
        int rDiameter = diameterOfBinaryTreeBrute(root.right);

        return Math.max(currDiameter, Math.max(lDiameter,rDiameter));
    }

    public int heightBrute(TreeNode root) {
        if(root== null){
            return  0;
        }
        int leftMax = heightBrute(root.left);
        int rightMax = heightBrute(root.right);

        return 1+Math.max(leftMax,rightMax);
    }
}