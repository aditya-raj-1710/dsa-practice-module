import java.util.*;

public class PartitionPalindrome {
    public static void main(String[] args) {
        PartitionPalindromeSolution solution = new PartitionPalindromeSolution();
        String s = "aab";
        List<List<String>> result = solution.partition(s);
        for (List<String> partition : result) {
            System.out.println(partition);
        }
    }
}

class PartitionPalindromeSolution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();

        dfs(0,path,ans,s);
        return ans;
    }

    private void dfs(int ind, List<String> path, List<List<String>> ans, String s){
        if(ind == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i=ind;i< s.length();i++){
            if(isPalindrome(s, ind,i)){
                path.add(s.substring(ind,i+1));
                dfs(i+1,path,ans,s);
                path.remove(path.size()-1);
            }
        }
    }

    boolean isPalindrome(String s, int left, int right){
        while(left <= right){
            if(s.charAt(left++) != s.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}