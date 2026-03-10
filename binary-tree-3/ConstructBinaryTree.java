import java.util.HashMap;

public class ConstructBinaryTree {
    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] preorder = {3, 9, 20, 15, 7};

        ConstructBinaryTreeSolution sol = new ConstructBinaryTreeSolution();

        System.out.print("Inorder Array: ");
        sol.printArray(inorder);

        System.out.print("Preorder Array: ");
        sol.printArray(preorder);

        TreeNode root = sol.buildTree(preorder, inorder);

        System.out.println("Inorder of Unique Binary Tree Created:");
        sol.printInorder(root);
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

class ConstructBinaryTreeSolution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> inOrderMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inOrderMap.put(inorder[i],i);
        }

        TreeNode root = buildTreeNodes(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inOrderMap);
        return root;
    }

    private TreeNode buildTreeNodes(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer,Integer> inOrderMap){
        if(preStart>preEnd || inStart>inEnd){
            return null;
        }
        TreeNode node = new TreeNode(preorder[preStart]);
        int inRoot = inOrderMap.get(node.data);
        int numsLeft = inRoot - inStart;

        node.left = buildTreeNodes(preorder,preStart+1, preStart+numsLeft, inorder,inStart, inRoot -1, inOrderMap);
        node.right = buildTreeNodes(preorder,preStart+numsLeft+1,preEnd,inorder,inRoot+1,inEnd,inOrderMap);

        return node;
    }

    public void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
        }
    }
}