public class PopulateNodeNext {
    public static void main(String[] args) {
        BSTNode root = new BSTNode(1);
        root.left = new BSTNode(2);
        root.right = new BSTNode(3);
        root.left.left = new BSTNode(4);
        root.left.right = new BSTNode(5);
        root.right.left = new BSTNode(6);
        root.right.right = new BSTNode(7);

        PopulateNodeNextSolution sol = new PopulateNodeNextSolution();
        sol.connect(root);

        printNext(root);
    }

    static void printNext(BSTNode root) {
        BSTNode levelStart = root;
        while(levelStart != null) {
            BSTNode curr = levelStart;
            while(curr != null) {
                System.out.print(curr.val + "->");
                if(curr.next != null) System.out.print(curr.next.val + " ");
                else System.out.print("NULL ");
                curr = curr.next;
            }
            System.out.println();
            levelStart = levelStart.left;
        }
    }
}

class PopulateNodeNextSolution {
    public BSTNode connect(BSTNode root) {
        if(root == null){
            return null;
        }

        BSTNode levelStart = root;

        while(levelStart.left != null){
            BSTNode curr = levelStart;

            while(curr != null){
                curr.left.next = curr.right;

                if(curr.next != null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }

            levelStart = levelStart.left;
        }

        return root;
    }
}


class BSTNode {
    int val;
    BSTNode left, right, next;

    // Constructor to initialize node
    BSTNode(int val) {
        this.val = val;
        left = null;
        right = null;
        next = null;
    }
}