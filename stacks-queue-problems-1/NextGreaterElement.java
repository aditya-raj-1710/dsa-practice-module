import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4};
        NextGreaterElementSolution solution = new NextGreaterElementSolution();
        int[] result = solution.nextLargerElement(arr);

        for(int i: result){
            System.out.print(i+" ");
        }
        System.out.println();
        result = solution.nextLargerElementUsingStack(arr);

        for(int i: result){
            System.out.print(i+" ");
        }

        var nums1 = new int[]{4, 1, 2};
        var nums2 = new int[]{1,3,4,2};
        System.out.println();
        result = solution.nextGreaterElement(nums1,nums2);

        for(int i: result){
            System.out.print(i+" ");
        }

    }
}

class NextGreaterElementSolution {
    /// Bruteforce Approach
    public int[] nextLargerElement(int[] arr) {
        int n= arr.length;
        int[] result = new int[n];
        Arrays.fill(result,-1);

        for(int i=0;i<n;i++){
            for(int j= i+1;j<n;j++){
                if(arr[j]>arr[i]){
                    result[i]= arr[j];
                    break;
                }
            }
        }
        return  result;
    }

    /// Monotonic Stack Approach
    public int[] nextLargerElementUsingStack(int[] arr) {
        int n= arr.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            int crrEl = arr[i];
            while(!st.isEmpty() && st.peek() <= crrEl){
                st.pop();
            }
            if(st.isEmpty()){
                result[i]=-1;
            }else{
                result[i] = st.peek();
            }
            st.push(crrEl);

        }
        return result;
    }

    /// Leetcode problem
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n= nums1.length;
        int[] result = new int[n];
        Arrays.fill(result,-1);

        Map<Integer,Integer> temp = actualGreaterElement(nums2);


        for(int i=0;i<n;i++){
            result[i] = temp.get(nums1[i]);
        }
        return  result;
    }
    public Map<Integer,Integer> actualGreaterElement(int[] arr) {
        int n= arr.length;
        Map<Integer,Integer> result = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            int crrEl = arr[i];
            while(!st.isEmpty() && st.peek() <= crrEl){
                st.pop();
            }
            if(st.isEmpty()){
                result.put(arr[i],-1);
            }else{
                result.put(arr[i],st.peek());
            }
            st.push(crrEl);

        }
        return result;
    }
}