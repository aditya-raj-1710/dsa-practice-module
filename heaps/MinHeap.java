public class MinHeap {
    public static void main(String[] args) {
        // Example array representing a min-heap
        int[] nums = {1, 4, 5, 5, 7, 6};
        int ind = 5, val = 2;

        // Print input array
        System.out.print("Input Min Heap array: ");
        for (int it : nums) {
            System.out.print(it + " ");
        }

        // Create an object of the Solution class
        MinHeapSolution sol = new MinHeapSolution();

        // Function call to heapify the array
        sol.heapify(nums, ind, val);

        // Print modified array
        System.out.print("\nModified array after heapifying: ");
        for (int it : nums) {
            System.out.print(it + " ");
        }
        System.out.println();
    }
}

class MinHeapSolution {
    public void heapify(int[] nums, int ind, int val) {
        int indValue = nums[ind];

        if(indValue<val){
            //heapify_down
            nums[ind]=val;
            heapifyDown(nums,ind);
        }else{
            //heapify_up
            nums[ind]=val;
            heapifyUp(nums,ind);
        }
    }

    private void heapifyDown(int[] nums, int parent){
        int left = (2*parent+1);
        int right = (2*parent+2);
        int smallest = parent;

        if(left < nums.length && nums[smallest] > nums[left]){
            smallest = left;
        }
        if(right < nums.length && nums[smallest] > nums[right]){
            smallest = right;
        }

        if(smallest != parent){
            swap(nums,parent,smallest);
            heapifyDown(nums,smallest);
        }
    }

    private void heapifyUp(int[] nums, int ind){
        int parent = (ind-1)/2;

        if(parent >= 0 && nums[parent] > nums[ind]){
            swap(nums,parent,ind);
            heapifyUp(nums,parent);
        }
    }

    private void swap(int[] nums, int ind1, int ind2){
        int temp = nums[ind1];
        nums[ind1]= nums[ind2];
        nums[ind2]= temp;
    }
}