import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TwoSumBST {
    public static void main(String[] args) {
        TwoSumBSTSolution solution = new TwoSumBSTSolution();

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);

        int k = 30;
        boolean result = solution.twoSumBSTBrute(root, k);
        System.out.println(result);

        System.out.println(solution.twoSumBST(root,k));
    }
}


class TwoSumBSTSolution {

    /// Better Approach
    public boolean twoSumBST(TreeNode root, int k) {
        if(root == null) return false;

        BSTIterator l = new BSTIterator(root,false);
        BSTIterator r = new BSTIterator(root,true);

        int i= l.next();
        int j= r.next();

        while(i<j){
            if(i+j == k) return true;
            else if ( i+j < k) i = l.next();
            else j= r.next();
        }
        return false;
    }

    /// Brute Approach
    public boolean twoSumBSTBrute(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root,list);
        int low =0;
        int high = list.size()-1;

        while (low<high){
            int sum = list.get(low) + list.get(high);
            if(sum < k){
                low++;
            }else if(sum>k){
                high--;
            }else{
                return true;
            }
        }
        return false;
    }

    private void inOrderTraversal(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }

        inOrderTraversal(node.left,list);
        list.add(node.data);
        inOrderTraversal(node.right,list);
    }
}

class BSTIterator{
    private Stack<TreeNode> stack;
    private boolean reverse;

    public BSTIterator(TreeNode root, boolean isReverse){
        stack = new Stack<>();
        reverse = isReverse;
        pushAll(root);
    }

    private void pushAll(TreeNode root){
        while(root != null){
            stack.push(root);
            root = reverse ? root.right: root.left;
        }
    }

    public boolean hasNext(){
        return!stack.isEmpty();
    }

    public int next(){
        TreeNode node = stack.pop();
        if(!reverse) pushAll(node.right);
        else pushAll(node.left);
        return node.data;
    }
}
