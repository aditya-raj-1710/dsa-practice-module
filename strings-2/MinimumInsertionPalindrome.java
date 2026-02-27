public class MinimumInsertionPalindrome {
    public static void main(String[] args) {
        String s = "abacaa";
        MinimumInsertionPalindromeSolution solution = new MinimumInsertionPalindromeSolution();
        System.out.println(solution.minInsertion(s));
    }
}

class MinimumInsertionPalindromeSolution {
    public int minInsertion(String s) {
        int n = s.length();

        int k = longestPalindromeSubsequence(s);

        return n-k;
    }

    private int longestPalindromeSubsequence(String s){
        String t = new StringBuilder(s).reverse().toString();

        return lcs(s,t);
    }

    private int lcs(String s, String t){
        int n= s.length();
        int m= t.length();

        int[] prev = new int[n+1];
        int[] cur = new int[m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    cur[j] = 1+ prev[j-1];
                }else{
                    cur[j] = Math.max(prev[j],cur[j-1]);
                }
            }
            System.arraycopy(cur,0,prev,0,m+1);
        }

        return prev[m];
    }
}
