import java.util.ArrayList;
import java.util.List;

public class MorrisInorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        MorrisInorderTraversalSolution sol = new MorrisInorderTraversalSolution();

        List<Integer> result = sol.getInorder(root);

        System.out.print("Morris Inorder Traversal: ");
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

class MorrisInorderTraversalSolution {
    public List<Integer> getInorder(TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>();

        TreeNode curr = root;

        while(curr != null){
            if(curr.left == null){
                inorder.add(curr.data);
                curr = curr.right;
            }else{
                TreeNode prev = curr.left;
                while( prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                }else{
                    prev.right = null;
                    inorder.add(curr.data);
                    curr = curr.right;
                }
            }
        }
        return inorder;
    }
}