import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserialize {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        SerializeAndDeserializeSolution solution = new SerializeAndDeserializeSolution();

        String serialized = solution.serialize(root);
        inorder(root);
        System.out.println();
        System.out.println("Serialized: " + serialized);

        TreeNode deserialized = solution.deserialize(serialized);
        System.out.print("Tree after deserialization: ");
        inorder(deserialized);
        System.out.println();
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

class SerializeAndDeserializeSolution {
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                str.append("#,");
            }else{
                str.append(node.data).append(",");
                q.add(node.left);
                q.add(node.right);
            }
        }

        return str.toString();
    }

    public TreeNode deserialize(String data) {
        if(data.isEmpty()){
            return  null;
        }
        StringBuilder s = new StringBuilder(data);
        int commaIdx = s.indexOf(",");
        String str = s.substring(0,commaIdx);
        s.delete(0,commaIdx+1);
        TreeNode root = new TreeNode(Integer.parseInt(str));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            commaIdx = s.indexOf(",");
            str = s.substring(0,commaIdx);
            s.delete(0,commaIdx+1);
            if(!str.equals("#")){
                node.left = new TreeNode(Integer.parseInt(str));
                q.offer(node.left);
            }

            commaIdx = s.indexOf(",");
            str = s.substring(0,commaIdx);
            s.delete(0,commaIdx+1);
            if(!str.equals("#")){
                node.right = new TreeNode(Integer.parseInt(str));
                q.offer(node.right);
            }
        }
        return  root;
    }
}