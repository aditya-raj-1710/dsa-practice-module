import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepth {
    public static void main(String[] args) {
        MaximumDepthSolution solution = new MaximumDepthSolution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Maximum Depth: " + solution.maxDepthBFS(root));
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int data) { data = data; left = null, right = null }
 * }
 **/

class MaximumDepthSolution {
    /// recursive approach
    public int maxDepth(TreeNode root) {
        if(root== null){
            return  0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        return 1+Math.max(leftMax,rightMax);
    }

    /// BFS approach
    public int maxDepthBFS(TreeNode root) {
        int level =0;
        if(root == null){
            return level;
        }

        Queue<TreeNode>  q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                TreeNode node = q.poll();

                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }

            level++;
        }
        return level;
    }
}