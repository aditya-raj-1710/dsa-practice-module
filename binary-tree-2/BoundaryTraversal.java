import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        BoundaryTraversalSolution solution = new BoundaryTraversalSolution();

        // Get the boundary traversal
        List<Integer> result = solution.boundary(root);

        // Print the result
        System.out.print("Boundary Traversal: "+ result);
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

class BoundaryTraversalSolution {
    public List<Integer> boundary(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        if(!isLeaf(root)){
            ans.add(root.data);
        }

        leftBoundary(root,ans);
        leafBoundary(root,ans);
        rightBoundary(root,ans);
        return ans;
    }

    private void leftBoundary(TreeNode node, List<Integer> ans){
        TreeNode currNode = node.left;
        while(currNode != null){
            if(!isLeaf(currNode)){
                ans.add(currNode.data);
            }
            if(currNode.left != null){
                currNode = currNode.left;
            }else{
                currNode = currNode.right;
            }
        }
    }

    private void rightBoundary(TreeNode node, List<Integer> ans){
        TreeNode currNode = node.right;
        List<Integer> temp = new ArrayList<>();
        while(currNode != null){
            if(!isLeaf(currNode)){
                temp.add(currNode.data);
            }
            if(currNode.right != null){
                currNode = currNode.right;
            }else{
                currNode = currNode.left;
            }
        }

        for(int i= temp.size()-1;i>=0;--i){
            ans.add(temp.get(i));
        }
    }

    private void leafBoundary(TreeNode node, List<Integer> ans){
        if(isLeaf(node)){
            ans.add(node.data);
        }
        if(node.left != null){
            leafBoundary(node.left,ans);
        }
        if(node.right != null){
            leafBoundary(node.right,ans);
        }
    }

    private boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
}
