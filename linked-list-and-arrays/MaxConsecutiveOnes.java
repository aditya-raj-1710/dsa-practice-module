public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 0, 1, 1, 1, 0,1,1,1,1,1,0};
        MaxConsecutiveOnesSolution solution = new MaxConsecutiveOnesSolution();
        System.out.println(solution.findMaxConsecutiveOnes(nums));
    }
}

class MaxConsecutiveOnesSolution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount =0;
        int currentCount =0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                currentCount++;
            }else{
                currentCount=0;
            }
            maxCount = Math.max(maxCount,currentCount);
        }
        return maxCount;
    }
}
