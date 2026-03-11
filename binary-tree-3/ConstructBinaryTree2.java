import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree2 {
    public static void main(String[] args) {
        int[] inorder = {40, 20, 50, 10, 60, 30};
        int[] postorder = {40, 50, 20, 60, 30, 10};

        System.out.print("Inorder Array: ");
        printArray(inorder);

        System.out.print("Postorder Array: ");
        printArray(postorder);

        ConstructBinaryTree2Solution sol = new ConstructBinaryTree2Solution();

        TreeNode root = sol.buildTree(inorder, postorder);

        System.out.println("Inorder of Unique Binary Tree Created: ");
        printInorder(root);
        System.out.println();
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
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

class ConstructBinaryTree2Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        Map<Integer,Integer> inMap = new HashMap<>();
        for(int i=0;i<n;i++){
            inMap.put(inorder[i],i);
        }

        return buildTreeNodes(inorder,0,n-1,postorder,0,n-1,inMap);
    }
    private TreeNode buildTreeNodes(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer,Integer> inMap){
        if(inStart>inEnd || postStart>postEnd){
            return null;
        }

        TreeNode node = new TreeNode(postorder[postEnd]);
        int inRoot = inMap.get(node.data);
        int numLeft = inRoot -inStart;

        node.left = buildTreeNodes(inorder,inStart,inRoot-1,postorder,postStart,postStart+numLeft-1,inMap);
        node.right = buildTreeNodes(inorder,inRoot+1,inEnd,postorder,postStart+numLeft,postEnd-1,inMap);

        return node;
    }
}