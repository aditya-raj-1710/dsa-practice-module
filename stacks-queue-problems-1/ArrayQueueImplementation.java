public class ArrayQueueImplementation {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();

        String[] commands = {"ArrayQueue", "push", "push",
                "peek", "pop", "isEmpty"};
        int[][] inputs = {{}, {5}, {10}, {}, {}, {}};

        for (int i = 0; i < commands.length; ++i) {
            switch (commands[i]) {
                case "push":
                    queue.push(inputs[i][0]);
                    System.out.print("null ");
                    break;
                case "pop":
                    System.out.print(queue.pop() + " ");
                    break;
                case "peek":
                    System.out.print(queue.peek() + " ");
                    break;
                case "isEmpty":
                    System.out.print(queue.isEmpty() ? "true " : "false ");
                    break;
                case "ArrayQueue":
                    System.out.print("null ");
                    break;
            }
        }
    }
}

class ArrayQueue {
    int start;
    int end;
    int size=100;
    int currentSize;
    int[] queue;

    public ArrayQueue() {
        this.start=-1;
        this.end=-1;
        this.queue= new int[size];
        this.currentSize=0;
    }

    public void push(int x) {
        if(currentSize>=size){
            System.out.println("Queue is full");
        }else if(isEmpty()){
            start=0;
            end=0;
        }else{
            end = (end+1)%size;
        }
        queue[end]=x;
        currentSize+=1;
    }

    public int pop() {
        if (isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }else if(currentSize==1){
            int val = queue[start];
            start=-1;
            end=-1;
            currentSize-=1;
            return val;
        }else{
            currentSize-=1;
            int val = queue[start];
            start= (start+1)%size;
            return val;
        }

    }

    public int peek() {
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[start];

    }

    public boolean isEmpty() {
        return currentSize==0;
    }
}
