import java.util.ArrayList;
import java.util.List;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] a = {1, 4, 7, 10, 12};
        int[] b = {2, 3, 6, 15};

        // Create an instance of the Solution class
        MedianOfTwoSortedArraysSolution sol = new MedianOfTwoSortedArraysSolution();

        // Print the median of the two sorted arrays
        System.out.println("The median of two sorted arrays is " + sol.median(a, b));

        System.out.println("The median of two sorted arrays is " + sol.medianOptimal(a, b));

        System.out.println("The median of two sorted arrays is " + sol.medianMerge(a, b));
    }
}

class MedianOfTwoSortedArraysSolution {

    /// Binary Search Approach
    public double median(int[] arr1, int[] arr2) {

        int n1 = arr1.length;
        int n2 = arr2.length;
        int n = n1 + n2;

        if(n1>n2){
            return median(arr2,arr1);
        }

        int left = (n1+n2+1) / 2;
        int low=0,high=n1;

        while(low <= high) {
            int mid1 = (low+high) >>> 1;
            int mid2 = left-mid1;

            int l1 = (mid1 > 0) ? arr1[mid1-1]: Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? arr1[mid1]: Integer.MAX_VALUE;
            int l2 = (mid2 > 0) ? arr2[mid2-1]: Integer.MIN_VALUE;
            int r2 = (mid2 < n2) ? arr2[mid2]: Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1){
                if(n%2 == 1){
                    return (double)Math.max(l1,l2);
                }else{
                    return (double)(Math.max(l1,l2)+ Math.min(r1,r2))/2;
                }
            }else if(l1>r2){
                high = mid1-1;
            }else{
                low = mid1+1;
            }
        }

        return 0;
    }

    /// Optimal Brute Approach
    public double medianOptimal(int[] arr1, int[] arr2) {

        int n1 = arr1.length;
        int n2 = arr2.length;
        int n = n1 + n2;

        int ind2 = n / 2;
        int ind1 = ind2 - 1;
        int count = 0;

        int indel1 = -1, indel2 = -1;

        int i = 0, j = 0;

        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                if (count == ind1) {
                    indel1 = arr1[i];
                }
                if (count == ind2) {
                    indel2 = arr1[i];
                }
                count++;
                i++;
            } else {
                if (count == ind1) {
                    indel1 = arr2[j];
                }
                if (count == ind2) {
                    indel2 = arr2[j];
                }
                count++;
                j++;
            }
        }

        while (i < n1) {
            if (count == ind1) {
                indel1 = arr1[i];
            }
            if (count == ind2) {
                indel2 = arr1[i];
            }
            count++;
            i++;
        }

        while (j < n2) {
            if (count == ind1) {
                indel1 = arr2[j];
            }
            if (count == ind2) {
                indel2 = arr2[j];
            }
            count++;
            j++;
        }

        if (n % 2 == 1) {
            return (double) indel2;
        }

        return (double) (indel1 + indel2) / 2;
    }

    /// Brute Approach
    public double medianMerge(int[] arr1, int[] arr2) {
        List<Integer> merged = new ArrayList<>();

        merge(arr1, arr2, merged);
        int median = merged.size() / 2;

        if (merged.size() % 2 == 0) {
            return (double) (merged.get(median) + merged.get(median - 1)) / 2;
        } else {
            return merged.get(median);
        }
    }

    private void merge(int[] arr1, int[] arr2, List<Integer> merged) {
        int m = arr1.length;
        int n = arr2.length;

        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (arr1[i] <= arr2[j]) {
                merged.add(k++, arr1[i++]);
            } else {
                merged.add(k++, arr2[j++]);
            }
        }

        while (i < m) {
            merged.add(k++, arr1[i++]);
        }

        while (j < n) {
            merged.add(k++, arr2[j++]);
        }
    }
}

