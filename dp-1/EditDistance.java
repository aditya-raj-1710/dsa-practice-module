import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";

        EditDistanceSolution sol = new EditDistanceSolution();

        System.out.println("The minimum number of operations required is: " + sol.editDistance(s1, s2));
    }
}

class EditDistanceSolution {

    /// Recursion + memoization
    public int editDistance(String start, String target) {
        int n= start.length();
        int m= target.length();

        int[][] dp = new int[n][m];

        for(int[] it: dp){
            Arrays.fill(it, -1);
        }
        return func(n-1,m-1,start,target,dp);

    }

    private int func(int i,int j, String start, String target,int[][] dp){
        if(i <0) return j+1;
        if(j <0) return i+1;
        if(dp[i][j] != -1) return dp[i][j];

        if(start.charAt(i) == target.charAt(j))
            return dp[i][j] = func(i-1,j-1,start,target,dp);

        return dp[i][j] = 1+Math.min( func(i-1,j,start,target,dp),
                Math.min(func(i,j-1,start,target,dp),
                        func(i-1,j-1,start,target,dp)));
    }
}

