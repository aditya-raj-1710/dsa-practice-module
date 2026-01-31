import java.util.Stack;

public class MinimumStack {
    public static void main(String[] args) {
        //MinStackBrute s= new MinStackBrute();
        MinStackSolution s = new MinStackSolution();
        s.push(-2);
        s.push(0);
        s.push(-3);
        System.out.print(s.getMin() + " ");
        s.pop();
        System.out.print(s.top() + " ");
        s.pop();
        System.out.print(s.getMin());
    }
}

class MinStackSolution {

    int min;
    Stack<Integer> st;

    public MinStackSolution() {
        st = new Stack<>();
    }

    public void push(int val) {
        if (st.isEmpty()) {
            min = val;
            st.push(val);
        } else {
            if (val < min) {
                st.push(2 * val - min);
                min = val;
            } else {
                st.push(val);
            }
        }
    }

    public void pop() {
        int val = st.pop();
        if (val < min) {
            min = 2 * min - val;
        }
    }

    public int top() {
        int val = st.peek();
        if (val < min) {
            return min;
        } else {
            return val;
        }
    }

    public int getMin() {
        return min;
    }
}

/// When edge case of large Int value comes, there is chance of overflow
/// Hence using Long for min variable & stack
/// Apart from storing the arithmetic logic requires explicit Long as value type
/*
class MinStack {

    long min;
    Stack<Long> st;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        if (st.isEmpty()) {
            min = val;
            st.push((long) val);
        } else {
            if (val < min) {
                st.push(2L * val - min); /// keeping 2L as then multiplication happens in Long instead of Int
                min = val;
            } else {
                st.push((long) val);
            }
        }
    }

    public void pop() {
        long val = st.pop();
        if (val < min) {
            min = 2L * min - val; /// keeping 2L as then multiplication happens in Long instead of Int
        }
    }

    public int top() {
        long val = st.peek();
        if (val < min) {
            return (int)min;
        } else {
            return (int)val;
        }
    }

    public int getMin() {
        return (int)min;
    }
}
*/



class MinStackBrute {
    Stack<int[]> st;

    public MinStackBrute() {
        this.st = new Stack<>();
    }

    public void push(int val) {
        if(st.isEmpty()){
            st.push(new int[]{val,val});
        }else{
            st.push(new int[]{val,Math.min(val,st.peek()[1])});
        }
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek()[0];
    }

    public int getMin() {
        return st.peek()[1];
    }
}

