import java.util.*;

public class TopView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TopViewSolution solution = new TopViewSolution();
        List<Integer> result = solution.topView(root);

        System.out.println("Top View: " + result);
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

class TopViewSolution {
    class Pair<K,V>{
        private K key;
        private V value;

        public Pair(K key, V v){
            this.value = v;
            this.key = key;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
    public List<Integer> topView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();

        q.add(new Pair<>(root,0));
        while( !q.isEmpty()){
            Pair<TreeNode,Integer> it = q.poll();
            TreeNode node = it.getKey();
            int level = it.getValue();

            map.putIfAbsent(level,node.data);

            if(node.left != null){
                q.add(new Pair<>(node.left, level-1));
            }

            if(node.right != null){
                q.add(new Pair<>(node.right,level+1));
            }
        }

        for(Integer value: map.values()){
            result.add(value);
        }

        return result;
    }
}
