import java.util.Arrays;

public class MinimumPlatform {
    public static void main(String[] args) {
        int[] arr = {900, 945, 955, 1100, 1500, 1800};
        int[] dep = {920, 1200, 1130, 1150, 1900, 2000};

        MinimumPlatformSolution solution = new MinimumPlatformSolution();

        System.out.println(solution.findPlatformBrute(arr,dep));
        System.out.println(solution.findPlatform(arr,dep));
    }
}

class MinimumPlatformSolution {

    /// Optimized approach
    public int findPlatform(int[] Arrival, int[] Departure) {
        int total=1, count=1;
        int n =Arrival.length;
        int arrival=1;
        int departure=0;

        Arrays.sort(Arrival);
        Arrays.sort(Departure);

        while(arrival < n && departure < n){
            if(Arrival[arrival] <= Departure[departure]){
                count++;
                arrival++;
            }else{
                count--;
                departure++;
            }
            total = Math.max(total,count);
        }

        return total;
    }

    /// Brute Force
    public int findPlatformBrute(int[] Arrival, int[] Departure) {
        //your code goes here
        int countP=1;
        int n =Arrival.length;
        for(int i=1;i<n;i++){
            int count =1;
            for(int j=0;j<n;j++){
                if(i != j){
                    if(Arrival[i] >= Arrival[j] && Departure[j] >= Arrival[i]){
                        count++;
                    }
                    countP = Math.max(count,countP);
                }
            }
        }
        return countP;
    }
}