import java.util.Arrays;
import java.util.Comparator;

public class MaximumProfitJobScheduling {
    public static void main(String[] args) {
        int[] start={1,2,3,3};
        int[] end={3,4,5,6};
        int[] prof={50,10,40,70};

        MaximumProfitJobSchedulingSolution sol=new MaximumProfitJobSchedulingSolution();
        System.out.println(sol.jobScheduling(start,end,prof)); // 120
        System.out.println(sol.jobScheduling2(start,end,prof)); // 120
    }
}

class MaximumProfitJobSchedulingSolution {
    /// Tabulation
    public int jobScheduling2(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for(int i=0;i<n;i++){
            jobs[i] = new Job(startTime[i], endTime[i],profit[i]);
        }

        Arrays.sort(jobs, (a,b) -> a.end-b.end);

        int[] dp = new int[n];
        dp[0] = jobs[0].profit;

        for(int i=1;i<n;i++){
            int include = jobs[i].profit;

            int l = latestNonConflict(jobs,i);
            if(l !=-1) include += dp[l];
            dp[i] = Math.max(include,dp[i-1]);
        }

        return dp[n-1];
    }

    private int latestNonConflict(Job[] jobs, int i){
        int low=0;
        int high = i-1;
        int ans =-1;

        while(low <= high){
            int mid = (low+high)/2;
            if(jobs[mid].end <=jobs[i].start){
                low = mid+1;
                ans = mid;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }


    ///  Recursive + memoization
    Job[] jobs;
    Integer[] dp;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        jobs = new Job[n];
        for(int i=0;i<n;i++){
            jobs[i] = new Job(startTime[i], endTime[i],profit[i]);
        }

        Arrays.sort(jobs, Comparator.comparingInt(a -> a.start));

        dp = new Integer[n];

        return solve(0);
    }

    private int solve(int ind){
        if(ind >= jobs.length) return 0;
        if(dp[ind] != null) return dp[ind];

        int l = ind+1, r = jobs.length-1, next = jobs.length;

        while(l <= r){
            int m = l + (r-l)/2;

            if(jobs[m].start >= jobs[ind].end){
                r= m-1;
                next = m;
            }else{
                l=m+1;
            }
        }

        int include = jobs[ind].profit+ solve(next);
        int exclude = solve(ind+1);

        return dp[ind] = Math.max(include,exclude);
    }
}

class Job {
    int start, end, profit;
    Job(int s,int e,int p){
        start=s;
        end=e;
        profit=p;
    }
}
