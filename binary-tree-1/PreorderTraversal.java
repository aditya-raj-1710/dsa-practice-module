import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        PreorderTraversalSolution sol = new PreorderTraversalSolution();

        List<Integer> result = sol.preorder(root);

        System.out.print("Preorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();

        List<Integer> result2 = sol.preorderUsingStack(root);

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

class PreorderTraversalSolution {
    public List<Integer> preorder(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        traverse(root,list);
        return list;
    }
    private void traverse(TreeNode root, List<Integer> list){
        if( root == null){
            return;
        }
        list.add(root.data);
        traverse(root.left,list);
        traverse(root.right,list);
    }

    public List<Integer> preorderUsingStack(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        List<Integer> inorder = new ArrayList<>();

        while (true) {
            if (node != null) {
                st.push(node);
                inorder.add(node.data);
                node = node.left;
            } else {
                if (st.isEmpty()) {
                    break;
                }
                node = st.pop();
                node = node.right;
            }
        }
        return inorder;
    }
}