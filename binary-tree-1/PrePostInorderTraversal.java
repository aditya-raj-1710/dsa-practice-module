import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrePostInorderTraversal {

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        PrePostInorderTraversalSolution sol = new PrePostInorderTraversalSolution();
        List<List<Integer>> traversals = sol.treeTraversal(root);

        // Print Preorder traversal
        System.out.print("Preorder traversal: ");
        for (int val : traversals.get(0)) System.out.print(val + " ");
        System.out.println();

        // Print Inorder traversal
        System.out.print("Inorder traversal: ");
        for (int val : traversals.get(1)) System.out.print(val + " ");
        System.out.println();

        // Print Postorder traversal
        System.out.print("Postorder traversal: ");
        for (int val : traversals.get(2)) System.out.print(val + " ");
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

class PrePostInorderTraversalSolution {
    class Pair<K,V>{
        private K key;
        private V value;

        public Pair(K k,V v){
            this.key = k;
            this.value =v;
        }

        public V getValue() {
            return value;
        }

        public K getKey() {
            return key;
        }
    }
    List<List<Integer>> treeTraversal(TreeNode root) {
        Stack<Pair<TreeNode,Integer>> st = new Stack<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        if(root == null){
            return new ArrayList<>();
        }

        st.push(new Pair<>(root,1));

        while(!st.isEmpty()){
            Pair<TreeNode, Integer> it =st.pop();
            int type = it.getValue();
            TreeNode node = it.getKey();

            if(type==1){
                preOrder.add(node.data);
                type++;
                st.push(new Pair<>(node,type));
                if(node.left != null){
                    st.push(new Pair<>(node.left,1));
                }
            }else if(type==2){
                inOrder.add(node.data);
                type++;
                st.push(new Pair<>(node,type));
                if(node.right != null){
                    st.push(new Pair<>(node.right,1));
                }
            }else{
                postOrder.add(node.data);
            }
        }
        return List.of(preOrder,inOrder,postOrder);
    }
}