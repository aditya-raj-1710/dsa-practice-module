import java.util.HashMap;

public class LongestSubArrayXor {
    public static void main(String[] args) {
        LongestSubArrayXorSolution solution = new LongestSubArrayXorSolution();

        int[] nums = {4, 2, 2, 6, 4};
        int k=6;
        System.out.println(solution.subarraysWithXorKBrute(nums,k));
        System.out.println(solution.subarraysWithXorKBetter(nums,k));
        System.out.println(solution.subarraysWithXorK(nums,k));
    }
}

class LongestSubArrayXorSolution {

    /// Optimal approach of prefix usage
    public int subarraysWithXorK(int[] nums, int k) {
        int n = nums.length;
        int count =0;
        int xr=0;

        HashMap<Integer, Integer> prefixXor = new HashMap<>();
        prefixXor.put(xr,1);

        for(int i=0;i<n;i++){
            xr = xr ^ nums[i];

            int x = xr ^ k;

            count += prefixXor.getOrDefault(x,0);

            prefixXor.put(xr, prefixXor.getOrDefault(xr,0)+1);
        }
        return count;
    }

    /// Better approach of prefix usage
    public int subarraysWithXorKBetter(int[] nums, int k) {
        int n = nums.length;
        int count =0;

        for(int i=0;i<n;i++){
            int xor=0;
            for(int j=i;j<n;j++){
                xor = xor ^ nums[j];
                if(xor == k){
                    count++;
                }
            }
        }
        return count;
    }

    /// Brute force approach
    public int subarraysWithXorKBrute(int[] nums, int k) {
        int n = nums.length;
        int count =0;

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int xor =0;
                for(int t=i;t<=j;t++){
                    xor = xor ^ nums[t];
                }
                if(xor == k){
                    count++;
                }
            }
        }
        return count;
    }
}