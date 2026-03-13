public class FlattenTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        FlattenTreeSolution sol = new FlattenTreeSolution();
        sol.flatten(root);

        // Print flattened tree
        TreeNode curr = root;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }
}

/* class TreeNode {
       int val;
       TreeNode left, right;
       TreeNode(int x) { val = x; }
   }
*/

class FlattenTreeSolution {
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        prev=null;
        flattenHelper(root);
    }

    private void flattenHelper(TreeNode node){
        if(node == null){
            return;
        }

        flattenHelper(node.right);
        flattenHelper(node.left);

        node.right = prev;
        node.left = null;
        prev = node;
    }
}
