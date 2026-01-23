import java.util.Stack;

public class StackQueueImplementation {
    public static void main(String[] args) {
        StackQueuePopHeavy q = new StackQueuePopHeavy();

        // List of commands
        String[] commands = {"StackQueue", "push", "push",
                "pop", "peek", "isEmpty"};
        // List of inputs
        int[][] inputs = {{}, {4}, {8}, {}, {}, {}};

        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals("push")) {
                q.push(inputs[i][0]);
                System.out.print("null ");
            } else if (commands[i].equals("pop")) {
                System.out.print(q.pop() + " ");
            } else if (commands[i].equals("peek")) {
                System.out.print(q.peek() + " ");
            } else if (commands[i].equals("isEmpty")) {
                System.out.print((q.isEmpty() ? "true" : "false") + " ");
            } else if (commands[i].equals("StackQueue")) {
                System.out.print("null ");
            }
        }
        System.out.println();

        StackQueuePushHeavy q2 = new StackQueuePushHeavy();
        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals("push")) {
                q2.push(inputs[i][0]);
                System.out.print("null ");
            } else if (commands[i].equals("pop")) {
                System.out.print(q2.pop() + " ");
            } else if (commands[i].equals("peek")) {
                System.out.print(q2.peek() + " ");
            } else if (commands[i].equals("isEmpty")) {
                System.out.print((q2.isEmpty() ? "true" : "false") + " ");
            } else if (commands[i].equals("StackQueue")) {
                System.out.print("null ");
            }
        }
    }

}


/// Queue Implemented using stack - Approach 1
/// good for implementations where pop and top operations are heavily used
class StackQueuePopHeavy {
    private Stack<Integer> s1, s2;

    public StackQueuePopHeavy() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    public void push(int x) {

        while (!isEmpty()) {
            s2.push(s1.pop());
        }

        s1.push(x);

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return s1.pop();
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return s1.peek();
    }

    public boolean isEmpty() {
        return s1.isEmpty();
    }
}

/// Queue Implemented using stack - Approach 1
/// good for implementations where pop and top operations are heavily used
class StackQueuePushHeavy {
    private Stack<Integer> s1, s2;

    public StackQueuePushHeavy() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if (s2.isEmpty()) {
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }

        if(s2.isEmpty()){
            return -1;
        }
        return s2.pop();
    }

    public int peek() {
        if (s2.isEmpty()) {
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }

        if(s2.isEmpty()){
            return -1;
        }
        return s2.peek();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
