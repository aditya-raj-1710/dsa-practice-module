import java.util.*;

public class MajorityElement2 {
    public static void main(String[] args) {
        int[] arr = {11, 33, 33, 11, 33, 11};

        MajorityElement2Solution solution = new MajorityElement2Solution();
        System.out.println("Majority elements are :"+ solution.majorityElementTwo(arr).toString());
    }
}

class MajorityElement2Solution {
    public List<Integer> majorityElementTwo(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int el1=Integer.MIN_VALUE, el2 =Integer.MIN_VALUE, count1=0,count2=0;
        for(int i : nums){
            if(count1 ==0 && el2 != i){
                el1=i;
                count1=1;
            }else if(count2 ==0 && el1 !=i){
                el2=i;
                count2 =1;
            }else if( el1 ==i){
                count1++;
            }else if(el2 ==i){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;

        for(int i:nums){
            if( i ==el1){
                count1++;
            }else if(i==el2){
                count2++;
            }
        }

        if(count1 > nums.length/3){
            result.add(el1);
        }
        if(count2 > nums.length/3){
            result.add(el2);
        }
        return result;

    }
}