import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatrixMedian {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}
        };
        MatrixMedianSolution sol = new MatrixMedianSolution();
        System.out.println(sol.findMedian(matrix));  // Output: 5

        System.out.println(sol.findMedianBrute(matrix));  // Output: 5

    }
}

class MatrixMedianSolution {
    /// Binary Search Approach
    public int findMedian(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int high = Integer.MIN_VALUE, low = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][m-1]);
        }

        int req = (n*m)/2;

        while(low<=high){
            int mid = low + (high-low)/2;

            int smallEqual = countSmallEqual(matrix,n,m,mid);

            if(smallEqual <=req){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }

    private int countSmallEqual(int[][] matrix, int n, int m, int x){
        int count =0;
        for(int i=0;i<n;i++){
            count += upperBound(matrix[i],x,m);
        }

        return count;
    }

    private int upperBound(int[] arr, int x, int m){
        int low =0, high =m-1;
        int ans =m;

        while(low<=high){
            int mid = (low+high)/2;

            if(arr[mid] > x){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    /// Brute Force Approach
    public int findMedianBrute(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();

        for(int[] row: matrix){
            for(int i: row){
                result.add(i);
            }
        }
        Collections.sort(result);
        int n= result.size();
        return result.get(n/2);
    }
}
