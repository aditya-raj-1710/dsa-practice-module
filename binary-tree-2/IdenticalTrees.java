public class IdenticalTrees {
    public static void main(String[] args) {
        IdenticalTreesSolution solution = new IdenticalTreesSolution();

        // Creating two sample trees
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);

        // Checking if the trees are identical
        boolean result = solution.isSameTree(tree1, tree2);
        System.out.println("Are the trees identical? " + result);
    }
}

/**
 * Definition for a binary tree node. public class TreeNode { int data; TreeNode left; TreeNode
 * right; TreeNode(int val) { data = val; left = null, right = null } }
 */
class IdenticalTreesSolution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (q.data != p.data) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

