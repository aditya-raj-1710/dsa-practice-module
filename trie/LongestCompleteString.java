import java.util.Arrays;
import java.util.List;

public class LongestCompleteString {
    public static void main(String[] args) {
        List<String> testCase1 = Arrays.asList("n", "ni", "nin", "ninj" , "ninja" , "nil");

        LongestCompleteStringSolution sol = new LongestCompleteStringSolution();

        System.out.println("Test Case 1: " + sol.completeString(testCase1));
    }
}


class LongestCompleteStringSolution {
    public String completeString(List<String> nums) {
        Trie3 trie = new Trie3();
        for(String word: nums){
            trie.insert(word);
        }

        String longest = "";

        for(String word: nums){
            if(trie.checkIfAllPrefixExist(word)){
                if(word.length()> longest.length()){
                    longest = word;
                }else if( word.length() == longest.length() && word.compareTo(longest) <  0){
                    longest = word;
                }
            }
        }

        return longest.isEmpty() ? "None": longest;
    }
}

class Trie3{
    NodeTrie root;

    public Trie3(){
        root = new NodeTrie();
    }

    public void insert(String word){
        NodeTrie node = root;
        for(int i=0;i< word.length();i++){
            if(!node.containKey(word.charAt(i))){
                node.put(word.charAt(i), new NodeTrie());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public boolean checkIfAllPrefixExist(String word){
        NodeTrie node = root;
        for(int i=0;i< word.length();i++){
            if(node.containKey(word.charAt(i))){
                node = node.get(word.charAt(i));
                if(!node.isEnd()){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}