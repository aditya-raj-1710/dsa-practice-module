public class CountInversion {
    public static void main(String[] args) {
        CountInversionSolution solution = new CountInversionSolution();

        int[] nums = {2, 3, 7, 1, 3, 5};
        solution.displayArray(nums);
        long inversionCount = solution.numberOfInversions(nums);
        System.out.println("inversion count :"+inversionCount);
        solution.displayArray(nums);

        int[] nums1 = {2, 3, 7, 1, 3, 5};
        solution.displayArray(nums);
        long inversionCount1 = solution.numberOfInversionsInPlace(nums1);
        System.out.println("inversion count :"+inversionCount1);
        solution.displayArray(nums1);
    }
}
class CountInversionSolution {
    public long numberOfInversions(int[] nums) {
        int n = nums.length;

        return mergeSort(nums,0,n-1);

    }

    public long mergeSort(int[] nums, int low, int high){
        long count = 0;
        if(low < high){
            int mid = low + (high-low)/2;

            count += mergeSort(nums,low,mid);

            count += mergeSort(nums,mid+1,high);

            count += merge(nums,low,mid,high);
        }

        return count;
    }

    public long merge(int[] nums, int low, int mid, int high){
        int left = low, right = mid+1;
        int index =0;

        long count =0;

        int[] temp = new int[high-low+1];

        while(left <=mid && right <= high){
            if(nums[left] <= nums[right]){
                temp[index++] = nums[left++];
            }else{
                temp[index++] = nums[right++];

                count += mid-left+1;
            }
        }

        while(left <=mid){
            temp[index++] = nums[left++];
        }
        while(right <= high){
            temp[index++] = nums[right++];
        }

        System.arraycopy(temp, 0, nums,low, high-low+1);

        return count;
    }

    public long numberOfInversionsInPlace(int[] nums) {
        long count=0;
        for(int i=0;i<nums.length;i++){
            for(int j= i+1;j<nums.length;j++){
                if(nums[i]>nums[j]){
                    count++;
                }
            }
        }
        return count;
    }

    public void displayArray(int[] nums){
        for(int i : nums){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}