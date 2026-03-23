import java.util.Stack;

class BSTIterator{
    private Stack<TreeNode> stack;
    private boolean reverse;

    public BSTIterator(TreeNode root, boolean isReverse){
        stack = new Stack<>();
        reverse = isReverse;
        pushAll(root);
    }

    public BSTIterator(TreeNode root){
        stack = new Stack<>();
        reverse = false;
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