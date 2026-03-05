import java.util.*;

public class VerticalOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        VerticalOrderTraversalSolution solution = new VerticalOrderTraversalSolution();
        List<List<Integer>> result = solution.verticalTraversal(root);

        System.out.println("Vertical Traversal:");
        for (List column : result) {
            System.out.println(column);
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

class VerticalOrderTraversalSolution {
    class Touple{
        TreeNode node;
        int x;
        int y;

        Touple(TreeNode node, int x, int y){
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Touple> q = new LinkedList<>();

        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        if(root == null){
            return new ArrayList<>();
        }
        q.offer(new Touple(root,0,0));

        while (!q.isEmpty()){
            Touple touple = q.poll();
            TreeNode node = touple.node;
            int x= touple.x;
            int y = touple.y;

            map.putIfAbsent(x, new TreeMap<>());
            map.get(x).putIfAbsent(y, new PriorityQueue<>());
            map.get(x).get(y).offer(node.data);

            if(node.left != null){
                q.offer(new Touple(node.left,x-1,y+1));
            }
            if(node.right != null){
                q.offer(new Touple(node.right,x+1, y+1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for(TreeMap<Integer,PriorityQueue<Integer>> columns: map.values()){
            List<Integer> column = new ArrayList<>();
            for(PriorityQueue<Integer> values: columns.values()){
                while (!values.isEmpty()){
                    column.add(values.poll());
                }
            }
            result.add(column);
        }
        return result;
    }
}