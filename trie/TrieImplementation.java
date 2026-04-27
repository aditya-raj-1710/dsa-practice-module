import java.util.ArrayList;
import java.util.List;

public class TrieImplementation {
    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] operations = {"Trie", "insert", "search", "search", "startsWith", "insert", "search"};
        String[][] arguments = {{}, {"apple"}, {"apple"}, {"app"}, {"app"}, {"app"}, {"app"}};

        List<String> output = new ArrayList<>();
        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "Trie":
                    output.add("null");
                    break;
                case "insert":
                    trie.insert(arguments[i][0]);
                    output.add("null");
                    break;
                case "search":
                    output.add(trie.search(arguments[i][0]) ? "true" : "false");
                    break;
                case "startsWith":
                    output.add(trie.startsWith(arguments[i][0]) ? "true" : "false");
                    break;
            }
        }

        for (String res : output) {
            System.out.println(res);
        }
    }
}

class Trie {
    private NodeTrie root;

    Trie() {
        root = new NodeTrie();
    }

    void insert(String word) {
        NodeTrie node = root;
        for(char ch: word.toCharArray()){
            if(!node.containKey(ch)){
                node.put(ch,new NodeTrie());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    boolean search(String word) {
        NodeTrie node = root;

        for(char ch: word.toCharArray()){
            if(!node.containKey(ch)){
                return false;
            }
            node = node.get(ch);
        }
        return node.isEnd();
    }

    boolean startsWith(String prefix) {
        NodeTrie node = root;
        for(char ch: prefix.toCharArray()){
            if(!node.containKey(ch)){
                return false;
            }
            node = node.get(ch);
        }
        return true;
    }
}


class NodeTrie{
    NodeTrie[] links = new NodeTrie[26];
    boolean flag = false;

    boolean containKey(char ch){
        return links[ch-'a'] != null;
    }

    void put(char ch, NodeTrie node){
        links[ch-'a'] = node;
    }

    NodeTrie get(char ch){
        return links[ch-'a'];
    }

    void setEnd(){
        flag= true;
    }

    boolean isEnd(){
        return flag;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */