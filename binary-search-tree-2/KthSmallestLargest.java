import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthSmallestLargest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        KthSmallestLargestSolution solution = new KthSmallestLargestSolution();
        int k = 1;
        List<Integer> result = solution.kLargesSmall(root, k);

        System.out.println(result);

        result = solution.kLargesSmall(root, k);

        System.out.println(result);
    }
}

class KthSmallestLargestSolution {
    int k;
    int result;
    public List<Integer> kLargesSmall(TreeNode root, int k) {

        int kSmall = kThSmall(root,k);
        int kLarge = kThLarge(root,k);

        return Arrays.asList(kSmall,kLarge);
    }

    private int kThSmall(TreeNode root, int k ){
        this.k = k;
        this.result = -1;

        inOrder(root);
        return result;
    }

    private void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        if(--k ==0){
            this.result = node.data;
        }
        inOrder(node.right);
    }

    private int kThLarge(TreeNode root, int k ){
        this.k = k;
        this.result = -1;

        inOrderReverse(root);
        return result;
    }

    private void inOrderReverse(TreeNode node){
        if(node == null){
            return;
        }
        inOrderReverse(node.right);
        if(--k ==0){
            this.result = node.data;
        }
        inOrderReverse(node.left);
    }


    public List<Integer> kLargesSmallBrute(TreeNode root, int k) {
        List<Integer> treeList = new ArrayList<>();
        inOrderTraversal(root,treeList);

        int kSmall = treeList.get(k-1);
        int kLarge = treeList.get(treeList.size()-k);

        return Arrays.asList(kSmall,kLarge);
    }

    private void inOrderTraversal(TreeNode node, List<Integer> treeList){
        if (node == null){
            return;
        }

        inOrderTraversal(node.left,treeList);
        treeList.add(node.data);
        inOrderTraversal(node.right,treeList);
    }
}