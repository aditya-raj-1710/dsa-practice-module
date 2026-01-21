import java.util.Arrays;
import java.util.List;

public class ArrayStackImplementation {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        List<String> commands = Arrays.asList("ArrayStack", "push", "push", "top", "pop", "isEmpty");
        List<List<Integer>> inputs = Arrays.asList(Arrays.asList(), Arrays.asList(5), Arrays.asList(10), Arrays.asList(), Arrays.asList(), Arrays.asList());

        for (int i = 0; i < commands.size(); ++i) {
            switch (commands.get(i)) {
                case "push":
                    stack.push(inputs.get(i).get(0));
                    System.out.print("null ");
                    break;
                case "pop":
                    System.out.print(stack.pop() + " ");
                    break;
                case "top":
                    System.out.print(stack.top() + " ");
                    break;
                case "isEmpty":
                    System.out.print((stack.isEmpty() ? "true" : "false") + " ");
                    break;
                case "ArrayStack":
                    System.out.print("null ");
                    break;
            }
        }
    }
}
class ArrayStack {
    int top;
    int size=100;
    int[] stack;

    public ArrayStack() {
        this.top=-1;
        this.stack= new int[size];
        //System.out.println("Initialized the stack");
    }

    public void push(int x) {
        if(top+1 >= size){
            System.out.println("Stack is full");///Overflow
            return;
        }
        stack[++top]=x;
    }

    public int pop() {
        if(isEmpty()){
            System.out.println("Stack is Empty"); /// Underflow
            return -1;
        }
        return stack[top--];
    }

    public int top() {
        if(isEmpty()){
            System.out.println("Stack is Empty"); ///Underflow
            return -1;
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
