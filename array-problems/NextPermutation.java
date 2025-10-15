public class NextPermutation {
    public static void main(String[] args) {
        NextPermutationSolution solution = new NextPermutationSolution();
        int[] nums = {1,2,3};
        solution.printArray(nums);
        solution.nextPermutation(nums);
        solution.printArray(nums);
    }
}
class NextPermutationSolution {
    public void nextPermutation(int[] nums) {
        // Your code goes here
        int index=-1;
        int n = nums.length;
        for(int i =n-2;i>=0;i--){
            if(nums[i] < nums[i+1]){ //find the first dip from right side
                index=i;
                break;
            }
        }

        if(index==-1){// if array is sorted in descending order
            reverse(nums, 0,n-1);
            return;
        }

        for(int i=n-1;i>=0;i--){
            if(nums[i] > nums[index]){//find the just greater element then at the dip
                swap(nums, i,index);
                break;
            }
        }

        // reverse rest of the right side array
        // right side array which is in descending order
        reverse(nums,index+1,n-1);
    }
    void swap(int[] nums, int i, int index){
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }

    void reverse(int[] nums, int start, int end){
        while (start < end){
            swap(nums, start,end);
            start++;
            end--;
        }
    }

    public void printArray(int[] nums){
        for(int i : nums){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}