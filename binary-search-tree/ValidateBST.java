public class ValidateBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(5);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(15);

        ValidateBSTSolution solution = new ValidateBSTSolution();
        System.out.println(solution.isBST(root)); // Output: false
    }
}

class ValidateBSTSolution {
    public boolean isBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max){
        if(node == null){
            return true;
        }

        if(node.data <= min || node.data >= max){
            return false;
        }

        return validate(node.left,min,node.data) && validate(node.right,node.data,max);
    }

}