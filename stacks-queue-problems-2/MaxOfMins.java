import java.util.Arrays;
import java.util.Stack;

public class MaxOfMins {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 50, 10, 70, 30};

        MaxOfMinsSolution solution= new MaxOfMinsSolution();

        System.out.println(Arrays.toString(solution.maxOfMin(arr)));
    }
}

class MaxOfMinsSolution {
    public int[] maxOfMin(int[] arr) {
        // Your code goes here
        int n=arr.length;

        int[] left = pse(arr);
        int[] right = nse(arr);

        int[] ans = new int[n+1];
        Arrays.fill(ans, Integer.MIN_VALUE);

        for(int i=0;i<n;i++){
            int len = right[i]-left[i]-1;
            ans[len] = Math.max(ans[len],arr[i]);
        }

        for(int i=n-1;i>=1;i--){
            ans[i] = Math.max(ans[i],ans[i+1]);
        }

        int[] result = new int[n];
        for(int i=1;i<=n;i++){
            result[i-1]=ans[i];
        }

        return result;
    }

    private int[] pse(int[] arr){
        int n= arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            ans[i] = (st.isEmpty() ? -1: st.peek());
            st.push(i);
        }

        return ans;
    }

    private int[] nse(int[] arr){
        int n= arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }

            ans[i] = (st.isEmpty() ? n: st.peek());
            st.push(i);
        }

        return ans;
    }
}