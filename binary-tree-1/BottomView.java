import java.util.*;

public class BottomView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(10);
        root.right.left = new TreeNode(9);

        BottomViewSolution solution = new BottomViewSolution();

        // Get the Bottom View traversal
        List<Integer> bottomView = solution.bottomView(root);

        // Print the result
        System.out.println("Bottom View Traversal: ");
        for (int node : bottomView) {
            System.out.print(node + " ");
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

class BottomViewSolution {
    public List<Integer> bottomView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Map.Entry<TreeNode,Integer>> q = new LinkedList<>();

        q.add(new AbstractMap.SimpleEntry<>(root,0));

        while(!q.isEmpty()){
            Map.Entry<TreeNode,Integer> item = q.poll();
            TreeNode node = item.getKey();
            int level = item.getValue();

            map.put(level,node.data);

            if(node.left != null){
                q.add(new AbstractMap.SimpleEntry<>(node.left,level-1));
            }
            if(node.right != null){
                q.add(new AbstractMap.SimpleEntry<>(node.right,level+1));
            }
        }

        for( Map.Entry<Integer,Integer> t: map.entrySet()){
            result.add(t.getValue());
        }
        return result;
    }
}
