public class BookAllocationProblem {
    public static void main(String[] args) {
        int[] arr = {25, 46, 28, 49, 24};
        int m = 4;

        // Create an instance of the Solution class
        BookAllocationSolution sol = new BookAllocationSolution();

        int ans = sol.findPages(arr, m);

        // Output the result
        System.out.println("The answer is: " + ans);
    }
}

class BookAllocationSolution{

    public int findPages(int[] nums, int m) {
        int n = nums.length;

        if(m>n){
            return -1;
        }

        int low= Integer.MIN_VALUE;
        int high=0;

        for(int i: nums){
            low = Math.max(i,low);
            high += i;
        }

        while(low <=high){
            int mid= (low+high)/2;
            int cnt = countStudents(nums,mid);

            if(cnt <=m){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;

    }

    private int countStudents(int[] nums, int pages){
        int pagesStudent = 0;
        int studentCount=1;

        for(int i: nums){
            if(pagesStudent+i <= pages){
                pagesStudent+=i;
            }else{
                studentCount++;
                pagesStudent=i;
            }
        }
        return studentCount;
    }
}
