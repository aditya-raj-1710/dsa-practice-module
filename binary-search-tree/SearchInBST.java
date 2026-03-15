public class SearchInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        SearchInBSTSolution sol = new SearchInBSTSolution();
        TreeNode result = sol.searchBST(root, 2);
        if (result != null) {
            System.out.println("Node found with value: " + result.data);
        } else {
            System.out.println("Node not found");
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

class SearchInBSTSolution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }

        if(root.data == val){
            return root;
        } else if (root.data < val ) {
            return searchBST(root.right, val);
        }else{
            return searchBST(root.left, val);
        }

    }
}
