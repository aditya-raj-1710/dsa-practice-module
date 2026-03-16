public class ConstructBST {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5};
        ConstructBSTSolution solution = new ConstructBSTSolution();
        TreeNode root = solution.sortedArrayToBST(nums);
        solution.printBST(root);
    }
}

class ConstructBSTSolution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums,0, nums.length-1);
    }

    private TreeNode buildBST(int[] nums, int start, int end){
        if(start>end){
            return null;
        }

        int mid=start+(end-start)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildBST(nums,start,mid-1);
        node.right=buildBST(nums,mid+1,end);

        return node;
    }

    public void printBST(TreeNode root){
        if (root==null){
            return;
        }

        printBST(root.left);
        System.out.print(" -> "+ root.data);
        printBST(root.right);
    }

}
