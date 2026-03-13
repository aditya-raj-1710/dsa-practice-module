public class ChildrenSumProperty {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(2);

        // Check children sum property
        ChildrenSumPropertySolution sol = new ChildrenSumPropertySolution();
        boolean result = sol.checkChildrenSum(root);

        // Print result
        System.out.println(result ? "True" : "False");
    }
}


class ChildrenSumPropertySolution {
    boolean checkChildrenSum(TreeNode root) {
        if(root == null){
            return true;
        }

        if(root.left == null && root.right == null){
            return true;
        }

        int leftVal = (root.left != null)? root.left.data : 0;
        int rightVal = (root.right != null)? root.right.data : 0;


        return (root.data == leftVal + rightVal) && checkChildrenSum(root.left) && checkChildrenSum(root.right);
    }
}

