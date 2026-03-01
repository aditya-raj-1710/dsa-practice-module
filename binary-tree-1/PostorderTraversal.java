import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        PostorderTraversalSolution sol = new PostorderTraversalSolution();

        List<Integer> result = sol.postorder(root);

        System.out.print("Preorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();

        List<Integer> result2 = sol.postorderUsingStack(root);

        System.out.print("Preorder Traversal: ");
        for (int val : result2) {
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

class PostorderTraversalSolution {
    public List<Integer> postorder(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        traverse(root,list);
        return list;
    }
    private void traverse(TreeNode root, List<Integer> list){
        if( root == null){
            return;
        }
        traverse(root.left,list);
        traverse(root.right,list);
        list.add(root.data);
    }

    public List<Integer> postorderUsingStack(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root != null) st.push(root);

        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            result.add(node.data);
            if(node.left !=null){
                st.push(node.left);
            }
            if(node.right !=null){
                st.push(node.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}