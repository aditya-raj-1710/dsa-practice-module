public class DoubleLinkedListFromBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        // Convert tree to DLL
        DoubleLinkedListFromBTSolution sol = new DoubleLinkedListFromBTSolution();
        TreeNode head = sol.bToDLL(root);

        // Print DLL
        TreeNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
        System.out.println();
    }
}

class DoubleLinkedListFromBTSolution {
    TreeNode prev;
    TreeNode head;

    TreeNode bToDLL(TreeNode root) {
        prev=null;
        head= null;

        inOrder(root);
        return head;
    }

    private void inOrder(TreeNode root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        if(prev== null){
            head = root;
        }else{
            prev.right=root;
            root.left=prev;
        }
        prev = root;
        inOrder(root.right);
    }
}