public class LargestBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        LargestBSTSolutionBrute sol = new LargestBSTSolutionBrute();
        System.out.println(sol.largestBST(root));  // Output: 3
        System.out.println(sol.maxSumBST(root));

        // Additional test case
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(15);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(8);
        root2.right.right = new TreeNode(7);

        System.out.println(sol.largestBST(root2));
        System.out.println(sol.maxSumBST(root2));
    }
}


/// Brute Solution - TUF
class LargestBSTSolutionBrute {
    private int maxSum;
    static class BSTInfo{
        int size;
        boolean isBST;
        int max;
        int min;
        int sum;

        BSTInfo(int size, int min,int max, boolean isBST, int sum){
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST= isBST;
            this.sum = sum;
        }
    }

    public int largestBST(TreeNode root) {
        return  isNodeBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE).size;
    }

    public int maxSumBST(TreeNode root) {
        maxSum=0;
        int sum = isNodeBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE).sum;
        return  maxSum;
    }

    private BSTInfo isNodeBST(TreeNode root,int max, int min){
        if(root == null){
            return new BSTInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true,0);
        }

        BSTInfo l = isNodeBST(root.left,root.data,min);
        BSTInfo r = isNodeBST(root.right,max,root.data);

        if(l.isBST && r.isBST && l.max < root.data && r.min > root.data){
            int size = l.size + r.size +1;
            int sum = l.sum + r.sum + root.data;
            maxSum = Math.max(sum,maxSum);
            return new BSTInfo(size, Math.min(l.min, root.data), Math.max(r.max, root.data), true,sum);
        }else{
            return new BSTInfo(Math.max(l.size, r.size), Integer.MAX_VALUE, Integer.MIN_VALUE, false,Math.max(l.sum,r.sum));
        }
    }
}
