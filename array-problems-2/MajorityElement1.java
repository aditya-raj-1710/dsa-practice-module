public class MajorityElement1 {
    public static void main(String[] args) {
        MajorityElement1Solution solution = new MajorityElement1Solution();
        int[] nums = {7, 0, 0, 1, 7, 7, 2, 7, 7};
        int majorElement = solution.majorityElement(nums);
        System.out.println(majorElement);
    }
}
class MajorityElement1Solution {
    public int majorityElement(int[] nums) {
        int count=0;
        int candidate = 0;
        for(int i : nums){
            if(count == 0){
                candidate = i;
                count++;
            }else if(candidate == i){
                count++;
            }else{
                count--;
            }
        }

        return candidate;
    }
}
