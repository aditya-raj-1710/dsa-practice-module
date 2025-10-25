public class MergeSortInPlace {
    public static void main(String[] args) {
        MergeSortInPlaceSolution solution = new MergeSortInPlaceSolution();
        int[] nums1 = {0,2,7,8,0,0,0};
        int[] nums2 = {-7, -3, -1};
        solution.printArray(nums1);
        solution.printArray(nums2);
        solution.merge(nums1,4,nums2,3);
        solution.printArray(nums1);
    }
}
class MergeSortInPlaceSolution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1 = m-1;
        int n2 = n-1;
        int i = m+n-1;
        while(i >=0 && n1 >= 0 && n2 >= 0){
            if(nums1[n1] > nums2[n2]){
                nums1[i--] = nums1[n1--];
            }else{
                nums1[i--] = nums2[n2--];
            }
        }
        if(n1 >= 0){
            while(n1 >=0){
                nums1[i--] = nums1[n1--];
            }
        }
        if(n2 >= 0){
            while(n2 >=0){
                nums1[i--] = nums2[n2--];
            }
        }

    }

    public void printArray(int[] num){
        for(int i=0;i < num.length;i++){
            System.out.print(num[i]+" ");
        }
        System.out.println();
    }
}
