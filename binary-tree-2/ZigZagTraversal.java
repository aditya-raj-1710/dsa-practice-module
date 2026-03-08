import java.util.*;

public class ZigZagTraversal {
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

class ZigZagTraversalSolution {

    /// BFS with o(n) reversal technique, fine but can be further optimized
    public List<List<Integer>> zigzagLevelOrderReversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int order = 0;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> row = new ArrayList<>();
            for(int i=0; i<size;i++){
                TreeNode node = q.poll();
                row.add(node.data);

                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            if (order == 0){
                order=1;
            }else{
                order = 0;
                Collections.reverse(row);
            }
            result.add(row);
        }

        return result;
    }

    /// BFS without additional reversal
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> row = new ArrayList<>(Collections.nCopies(size,0));
            for(int i=0; i<size;i++){
                TreeNode node = q.poll();
                int index = leftToRight ? i : size-1-i;

                row.set(index, node.data);

                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            leftToRight = !leftToRight;
            result.add(row);
        }

        return result;
    }
}
