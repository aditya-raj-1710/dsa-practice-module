public class NthRoot {
    public static void main(String[] args) {
        int n = 3, m = 27;

        // Create an object of the Solution class
        NthRootSolution sol = new NthRootSolution();

        int ans = sol.NthRoot(n, m);

        // Print the result
        System.out.println("The answer is: " + ans);

        ans = sol.NthRootLinearSearch(n,m);
        // Print the result
        System.out.println("The answer is: " + ans);

    }
}

class NthRootSolution {
    /// Binary Search Approach
    public int NthRoot(int N, int M) {
        int low=1, high = M;

        while(low <= high){
            int mid= (low+high)/2;

            int midN = helperFunc(mid,N,M);

            if(midN == 1){
                return mid;
            }else if(midN ==0){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;

    }

    private int helperFunc(int mid, int n,int m){
        long ans = 1;
        long base =mid;

        while(n>0){
            if(n%2 == 1){
                ans *= base;
                if(ans > m){
                    return 2;
                }
                n--;
            }else{
                n /=2;
                base *= base;
                if(base>m){
                    return 2;
                }
            }
        }

        if(ans == m){
            return 1;
        }

        return 0;
    }

    /// Linear Search Approach
    public int NthRootLinearSearch(int N, int M) {
        for(int i=1;i<=M;i++){
            long val = pow(i,N);

            if(val == M){
                return i;
            }else if(val >M){
                break;
            }
        }
        return -1;

    }

    private long pow(int b, int exp){
        long ans = 1;
        long base =b;

        while(exp>0){
            if(exp%2 == 1){
                exp--;
                ans *= base;
            }else{
                exp /=2;
                base *= base;
            }
        }

        return ans;
    }
}

