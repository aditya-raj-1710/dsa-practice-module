import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        StockSpanSolution solution = new StockSpanSolution();

        int[] arr = {120, 100, 60, 80, 90, 110, 115};

        System.out.println(Arrays.toString(solution.stockSpan(arr, arr.length)));
    }
}
class StockSpanSolution {

    public int[] stockSpan(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }

            int count =i -(st.isEmpty() ? -1 : st.peek());

            st.push(i);
            result[i] = count;
        }

        return result;
    }
    public int[] stockSpanBrute(int[] arr, int n) {
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=i;j>=0;j--){
                if(arr[j] <= arr[i]){
                    count++;
                }else{
                    break;
                }
            }
            result[i] = count;
        }

        return result;
    }
}

class StockSpanner {
    Stack<int[]> st;
    int ind;

    public StockSpanner() {
        ind =-1;
        st = new Stack<>();
    }

    public int next(int price) {
        ind++;

        while(!st.isEmpty() && st.peek()[0] <= price){
            st.pop();
        }
        int count = ind - (st.isEmpty()? -1: st.peek()[1]);
        st.push(new int[]{price,ind});
        return count;
    }
}

class StockSpannerBrute {
    List<Integer> prices;

    public StockSpannerBrute() {
        prices = new ArrayList<>();
    }

    public int next(int price) {
        prices.add(price);
        int count=0;
        for(int j= prices.size()-1;j>=0;j--){
            if(prices.get(j) <= price){
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}

