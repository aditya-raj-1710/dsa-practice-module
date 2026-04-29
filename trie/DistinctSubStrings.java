import java.util.HashSet;
import java.util.Set;

public class DistinctSubStrings {
    public static void main(String[] args) {
        DistinctSubStringsSolution solution = new DistinctSubStringsSolution();
        String input = "abc";
        System.out.println("Number of distinct substrings: " + solution.countDistinctSubstring(input));
        System.out.println("Number of distinct substrings: " + solution.countDistinctSubstring2(input));
    }
}


class DistinctSubStringsSolution {
    /// Optimal
    public int countDistinctSubstring2(String s) {
        NodeTrie root = new NodeTrie();
        int count=0;

        for(int i=0;i<s.length();i++){
            NodeTrie node = root;
            for(int j=i;j<s.length();j++){
                if(!node.containKey(s.charAt(j))){
                    count++;
                    node.put(s.charAt(j), new NodeTrie());
                }
                node = node.get(s.charAt(j));
            }
        }
        return count+1;
    }

    /// Brute
    public int countDistinctSubstring(String s) {
        Set<String> subStrings = new HashSet<>();

        for(int i=0;i<s.length();i++){
            String subString="";
            for(int j=i;j<s.length();j++){
                subString +=s.charAt(j);
                subStrings.add(subString);
            }
        }
        subStrings.add("");
        return subStrings.size();
    }
}