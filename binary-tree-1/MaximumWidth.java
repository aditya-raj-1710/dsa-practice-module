import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        MaximumWidthSolution sol = new MaximumWidthSolution();

        int maxWidth = sol.widthOfBinaryTree(root);

        System.out.println("Maximum width of the binary tree is: " + maxWidth);
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
class Pair<K,V>{
    private K key;
    private V value;

    public Pair(K _k,V _v) {
        this.key = _k;
        this.value = _v;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
class MaximumWidthSolution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        int ans =0;
        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();

        q.offer(new Pair<>(root,0));

        while(!q.isEmpty()){
            int size = q.size();
            int mmin = q.peek().getValue();

            int first =0, last=0;

            for(int i=0;i<size;i++){
                int curN = q.peek().getValue()-mmin;
                TreeNode node = q.peek().getKey();

                q.poll();

                if(i==0){
                    first= curN;
                }

                if(i== size-1){
                    last = curN;
                }

                if(node.left != null){
                    q.offer(new Pair<>(node.left,2*curN+1));
                }
                if(node.right != null){
                    q.offer(new Pair<>(node.right,2*curN+2));
                }

                ans= Math.max(ans, last-first+1);
            }
        }
        return ans;
    }
}