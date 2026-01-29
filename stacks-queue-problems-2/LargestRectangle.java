import java.util.Stack;

public class LargestRectangle {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        LargestRectangleSolution solution = new LargestRectangleSolution();

        System.out.println(solution.largestRectangleArea(heights));
    }
}

class LargestRectangleSolution {
    /// Optimal Approach
    public int largestRectangleArea(int[] heights) {
        int n= heights.length;

        Stack<Integer> st = new Stack<>();
        int largestArea = 0;
        int area=0;
        int nse,pse;

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]){
                int ind = st.pop();

                pse = st.isEmpty()? -1 : st.peek();
                nse = i;

                area = heights[ind] * (nse-pse-1);
                largestArea = Math.max(largestArea,area);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            nse = n;
            int ind = st.pop();
            pse = st.isEmpty()? -1: st.peek();

            area = heights[ind] * (nse-pse-1);
            largestArea = Math.max(largestArea,area);
        }

        return largestArea;
    }

    /// Brute Force Approach
    public int largestRectangleAreaBrute(int[] heights) {

        int[] nse = findNSE(heights);
        int[] pse = findPSE(heights);
        int largestArea = 0;

        for(int i=0;i<heights.length;i++){
            int area = heights[i] * (nse[i]-pse[i]-1);

            largestArea = Math.max(largestArea,area);
        }

        return largestArea;
    }

    private int[] findNSE(int[] arr){
        int n= arr.length;

        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            int currE = arr[i];

            while( !st.isEmpty() &&  currE<=arr[st.peek()]){
                st.pop();
            }

            result[i] = !st.isEmpty()? st.peek() : n;

            st.push(i);
        }

        return result;
    }

    private int[] findPSE(int[] arr){
        int n= arr.length;

        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++){
            int currE = arr[i];

            while( !st.isEmpty() &&  currE<=arr[st.peek()]){
                st.pop();
            }

            result[i] = !st.isEmpty()? st.peek() : -1;

            st.push(i);
        }

        return result;
    }
}
