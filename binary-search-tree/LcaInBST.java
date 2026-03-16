import java.util.ArrayList;
import java.util.List;

public class LcaInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(8);

        LcaInBSTSolution sol = new LcaInBSTSolution();

        // Find the LCA of nodes with values 5 and 8
        TreeNode ans = sol.lca(root, 5, 8);
        if (ans != null) {
            System.out.println("LCA(5, 8) = " + ans.data);
        } else {
            System.out.println("LCA(5, 8) is not present in the tree");
        }
    }
}


class LcaInBSTSolution {

    /// Optimal
    public TreeNode lca(TreeNode root, int p, int q) {
        if(root == null){
            return null;
        }

        int curr = root.data;

        if(curr < p && curr < q){
            return lca(root.right,p,q);
        }

        if(curr > p && curr > q){
            return lca(root.left,p,q);
        }

        return root;
    }

    /// Brute
    public TreeNode lcaBrute(TreeNode root, int p, int q) {
        List<Integer> path1 = new ArrayList<>();
        List<Integer> path2 = new ArrayList<>();

        if(!getPath(root, path1,p) || !getPath(root, path2,q)){
            return null;
        }

        int i=0;
        while(i <path1.size() && i < path2.size() && path1.get(i).equals(path2.get(i))){
            i++;
        }

        return new TreeNode(path1.get(i-1));
    }

    private boolean getPath(TreeNode root, List<Integer> path, int x){
        if(root == null){
            return false;
        }

        path.add(root.data);

        if(root.data == x){
            return true;
        }

        if(getPath(root.left,path,x) || getPath(root.right,path,x)){
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }
}
