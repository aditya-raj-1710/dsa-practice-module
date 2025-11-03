import java.util.Arrays;
import java.util.HashSet;

public class LongestSubSequence {
    public static void main(String[] args) {
        LongestSubSequenceSolution solution = new LongestSubSequenceSolution();

        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(solution.longestConsecutiveUsingSet(nums));
        System.out.println(solution.longestConsecutive(nums));

    }
}

class LongestSubSequenceSolution {

    /// Using Arrays.sort leading to O(N*logN) complexity
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int finalSeq =1;
        int count =1;

        for(int i =1; i< nums.length;i++){
            if( nums[i] == nums[i-1]+1){
                count++;
            } else if( nums[i] == nums[i-1]){
                continue;
            }else{
                finalSeq = Math.max(finalSeq,count);
                count=1;
            }
        }
        finalSeq = Math.max(finalSeq,count);
        return finalSeq;
    }

    /// Using HashSet leading to O(N)+O(N) complexity : O(N) for set insertions, second O(N) for traversing the set
    public int longestConsecutiveUsingSet(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int finalSeq = 1;
        int count = 1;
        HashSet<Integer> numsSet = new HashSet<>();

        for (int i : nums) {
            numsSet.add(i);
        }

        for (int setI : numsSet) {
            if (!numsSet.contains(setI - 1)) {
                count = 1;
                int x = setI;

                while (numsSet.contains(x + 1)) {
                    count++;
                    x++;
                }
            }
            finalSeq = Math.max(count, finalSeq);
        }

        return finalSeq;
    }
}

