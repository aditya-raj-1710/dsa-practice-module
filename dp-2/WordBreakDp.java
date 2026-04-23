import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakDp {
    public static void main(String[] args) {
        WordBreakDpSolution sol = new WordBreakDpSolution();
        String s = "applepenapple";
        List<String> dict = Arrays.asList("apple", "pen");

        System.out.println(sol.wordBreak(s, dict));
    }
}
class WordBreakDpSolution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> dict = new HashSet<>(wordDict);

        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        int maxLen=0;
        for(String word: wordDict){
            maxLen = Math.max(maxLen,word.length());
        }

        for(int i=0;i<n;i++){
            if(!dp[i]){
                continue;
            }
            for(int len=1;len <= maxLen && i+len <=n;len++){
                if(dict.contains(s.substring(i,i+len))){
                    dp[i+len] = true;
                }
            }
        }

        return dp[n];
    }
}