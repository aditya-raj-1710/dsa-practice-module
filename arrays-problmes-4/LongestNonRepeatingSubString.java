import java.util.Arrays;

public class LongestNonRepeatingSubString {
    public static void main(String[] args) {
        LongestNonRepeatingSubStringSolution solution = new LongestNonRepeatingSubStringSolution();

        String s = "abcddabac";
        System.out.println(solution.longestNonRepeatingSubstring(s));
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}

class LongestNonRepeatingSubStringSolution {

    /// Optimal Approach
    public int longestNonRepeatingSubstring(String s) {
        int n = s.length();
        int maxLen =0;

        int[] hash = new int[256];
        Arrays.fill(hash,-1);

        int l=0,r=0;

        while( r<n){
            if(hash[s.charAt(r)] >=0){
                l= Math.max(hash[s.charAt(r)] +1,l);
            }

            int len = r-l+1;
            maxLen = Math.max(len, maxLen);

            hash[s.charAt(r)] = r;
            r++;
        }

        return maxLen;
    }


    /// Brute Force
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen =0;

        for(int i=0;i<n;i++){
            int[] hash = new int[256];
            Arrays.fill(hash,0);

            for(int j=i;j<n;j++){
                if(hash[s.charAt(j)] ==1){
                    break;
                }

                hash[s.charAt(j)] =1;

                int len = j-i+1;

                maxLen = Math.max(maxLen,len);
            }
        }
        return maxLen;
    }

}
