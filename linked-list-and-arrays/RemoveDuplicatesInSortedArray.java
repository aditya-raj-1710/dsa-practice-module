public class RemoveDuplicatesInSortedArray {
    public static void main(String[] args) {
        int[] nums = {0,0,3,4,5,6,6,7};

        RemoveDuplicatesInSortedArraySolution solution = new RemoveDuplicatesInSortedArraySolution();
        solution.printArray(nums);
        int end = solution.removeDuplicates(nums);
        solution.printArray(nums);
        System.out.println(end);
    }
}

class RemoveDuplicatesInSortedArraySolution {
    public int removeDuplicates(int[] nums) {
        int j=0;
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i] != nums[j]){
                j++;
                nums[j] = nums[i];
            }
        }
        return j+1;
    }

    public void printArray(int[] nums){
        for(int i: nums){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
