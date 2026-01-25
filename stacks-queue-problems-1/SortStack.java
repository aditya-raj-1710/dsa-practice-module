import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(4); st.push(1); st.push(3); st.push(2);
        // Sort
        new SortStackSolution().sortStack(st);
        // Print top -> bottom
        System.out.print("Sorted stack (top->bottom): ");
        while (!st.isEmpty()) System.out.print(st.pop() + " ");
        System.out.println();
    }
}

class SortStackSolution{
    public void sortStack(Stack<Integer> st){
        if(st.size() <= 1){
            return;
        }
        int x= st.pop();
        sortStack(st);
        insertSorted(st,x);
    }

    private void insertSorted(Stack<Integer> st, int x){
        if(st.isEmpty() || st.peek() <= x){
            st.push(x);
            return;
        }
        int t = st.pop();
        insertSorted(st,x);
        st.push(t);
    }
}
