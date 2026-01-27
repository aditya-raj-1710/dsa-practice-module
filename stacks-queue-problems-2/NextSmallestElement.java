import java.util.Arrays;
import java.util.Stack;

public class NextSmallestElement {
    public static void main(String[] args) {
        int[] arr = {4, 8, 5, 2, 25};
        NextSmallestElementSolution solution = new NextSmallestElementSolution();
        int[] result = solution.nextSmallerElements(arr);

        for(int i: result){
            System.out.print(i+" ");
        }
        System.out.println();
        result = solution.nextSmallerElementsBrute(arr);

        for(int i: result){
            System.out.print(i+" ");
        }
    }
}

class NextSmallestElementSolution {
    public int[] nextSmallerElements(int[] arr) {
        int n= arr.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--){
            int crrEl = arr[i];
            while(!st.isEmpty() && st.peek() >= crrEl){
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

    public int[] nextSmallerElementsBrute(int[] arr) {
        int n= arr.length;
        int[] result = new int[n];
        Arrays.fill(result,-1);

        for(int i=0;i<n;i++){
            for(int j= i+1;j<n;j++){
                if(arr[j]<=arr[i]){
                    result[i]= arr[j];
                    break;
                }
            }
        }
        return  result;
    }
}
