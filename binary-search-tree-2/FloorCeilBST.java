import java.util.Arrays;
import java.util.List;

public class FloorCeilBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);

        FloorCeilBSTSolution sol = new FloorCeilBSTSolution();
        int key = 11;  // Key to find floor and ceil for

        // Find and print floor and ceil values
        List<Integer> result = sol.floorCeilOfBST(root, key);
        System.out.println("Floor: " + result.get(0) + ", Ceil: " + result.get(1));
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

class FloorCeilBSTSolution {
    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
        int floor=-1;
        int ceil = -1;

        TreeNode curr = root;
        while(curr != null){
            if(curr.data == key){
                floor = curr.data;
                break;
            }else if(curr.data < key){
                floor = curr.data;
                curr = curr.right;
            }else{
                curr = curr.left;
            }
        }

        curr = root;
        while(curr != null){
            if(curr.data == key){
                ceil = curr.data;
                break;
            }else if(curr.data > key){
                ceil = curr.data;
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
        return Arrays.asList(floor,ceil);
    }
}
