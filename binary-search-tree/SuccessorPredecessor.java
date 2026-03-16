import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuccessorPredecessor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(12);

        SuccessorPredecessorSolution sol = new SuccessorPredecessorSolution();
        System.out.println(sol.succPredBSTBrute(root, 10));
        System.out.println(sol.succPredBSTBetter(root, 10));
        System.out.println(sol.succPredBST(root, 10));
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

class SuccessorPredecessorSolution {

    /// Optimal
    List<Integer> succPredBST(TreeNode root, int key) {
        TreeNode predecessor = null;
        TreeNode successor = null;
        TreeNode curr = root;

        while (curr != null) {
            if (curr.data < key) {
                predecessor = curr;
                curr = curr.right;
            } else if (curr.data > key) {
                successor = curr;
                curr = curr.left;
            } else {
                if (curr.left != null) {
                    TreeNode temp = curr.left;

                    while (temp.right != null) {
                        temp = temp.right;
                    }
                    predecessor = temp;
                }
                if(curr.right != null){
                    TreeNode temp = curr.right;
                    while(temp.left != null){
                        temp = temp.left;
                    }

                    successor= temp;
                }
                break;
            }
        }

        int predVal = ( predecessor != null)? predecessor.data: -1;
        int succVal = (successor != null)? successor.data : -1;

        return Arrays.asList(predVal,succVal);
    }

    /// Better
    List<Integer> succPredBSTBetter(TreeNode root, int key) {
        TreeNode[] prev = {null};
        int[] result= {-1,-1};

        inorderTraversal(root,prev,result,key);

        return Arrays.asList(result[0],result[1]);
    }

    private void inorderTraversal(TreeNode root, TreeNode[] prev, int[] result, int key){
        if(root==null){
            return;
        }

        inorderTraversal(root.left,prev,result,key);

        if(prev[0] != null && prev[0].data < key){
            result[0] = prev[0].data;
        }

        if(result[1] == -1 && root.data > key){
            result[1] = root.data;
        }

        prev[0] = root;

        inorderTraversal(root.right,prev,result,key);
    }

    /// Brute
    List<Integer> succPredBSTBrute(TreeNode root, int key) {
        List<Integer> list = new ArrayList<>();

        inorderTraversal(root,list);
        int index = binarySearch(list,key);
        int predecessor =-1;
        int successor =-1;

        if(index>0 ) predecessor = list.get(index-1);
        if(index < list.size()-1) successor = list.get(index+1);

        return Arrays.asList(predecessor,successor);


    }

    private int binarySearch(List<Integer> list, int key){
        int low=0,mid=0,high=list.size()-1;

        while(low <= high){
            mid = low + (high-low)/2;

            if(list.get(mid) == key) return mid;
            else if(list.get(mid) < key ) low = mid+1;
            else high = mid-1;
        }

        return -1;
    }

    private void inorderTraversal(TreeNode root, List<Integer> list){
        if(root==null){
            return;
        }

        inorderTraversal(root.left,list);
        list.add(root.data);
        inorderTraversal(root.right,list);
    }
}
