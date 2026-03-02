import java.util.ArrayList;
import java.util.List;

public class MorrisPreorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        MorrisPreorderTraversalSolution sol = new MorrisPreorderTraversalSolution();

        List<Integer> result = sol.preorder(root);

        System.out.print("Preorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
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

class MorrisPreorderTraversalSolution {
    public List<Integer> preorder(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        TreeNode curr = root;

        while(curr != null){
            if(curr.left == null){
                preorder.add(curr.data);
                curr = curr.right;
            }else{
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = curr;
                    preorder.add(curr.data);
                    curr = curr.left;
                }else{
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return preorder;
    }
}
