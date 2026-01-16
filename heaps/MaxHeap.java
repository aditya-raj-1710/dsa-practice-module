import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    public static void main(String[] args) {
        MaxHeapSolution heap = new MaxHeapSolution();

        // Initializing a max heap data structure
        heap.initializeHeap();

        // Performing different operations
        heap.insert(4); System.out.println("Inserting 4 in the max-heap");
        heap.insert(1); System.out.println("Inserting 1 in the max-heap");
        heap.insert(10); System.out.println("Inserting 10 in the max-heap");
        heap.printHeap();
        System.out.println("Maximum value in the heap is: " + heap.getMax());
        System.out.println("Size of max-heap is: " + heap.heapSize());
        System.out.println("Is heap empty: " + heap.isEmpty());
        System.out.println("Extracting maximum value from the heap");
        heap.extractMax();
        heap.printHeap();
        System.out.println("Changing value at index 0 to 16");
        heap.changeKey(0, 16);
        System.out.println("Maximum value in the heap is: " + heap.getMax());
        heap.printHeap();
    }
}


class MaxHeapSolution {
    private List<Integer> arr;
    private int count;

    public MaxHeapSolution(){
        arr = new ArrayList<>();
        count=0;
    }

    public void initializeHeap() {
        count=0;
        arr.clear();

    }

    public void insert(int key) {
        arr.add(key);
        heapifyUp(count);
        count +=1;
    }

    public void changeKey(int index, int newVal) {
        if(arr.get(index) < newVal){
            arr.set(index,newVal);
            heapifyUp(index);
        }else{
            arr.set(index,newVal);
            heapifyDown(index);
        }
    }

    public void extractMax() {
        int ele = arr.get(0);

        int temp = arr.get(count-1);
        arr.set(count-1,ele);
        arr.set(0,temp);

        arr.remove(count-1);
        count -=1;

        if(count>0){
            heapifyDown(0);
        }


    }

    public boolean isEmpty() {
        return (count==0);
    }

    public int getMax() {
        return arr.get(0);
    }

    public int heapSize() {
        return count;
    }

    private void heapifyDown(int index){
        int n= arr.size();

        int largest= index;
        int left=2*index+1;
        int right=2*index+2;

        if(left < n && arr.get(largest) < arr.get(left)){
            largest = left;
        }
        if(right < n && arr.get(largest) < arr.get(right)){
            largest = right;
        }

        if(largest != index){
            int temp = arr.get(largest);
            arr.set(largest,arr.get(index));
            arr.set(index,temp);
            heapifyDown(largest);
        }
    }

    private void heapifyUp(int index){
        int parent = (index-1)/2;

        if(parent >=0 && arr.get(parent) < arr.get(index)){
            int temp = arr.get(parent);
            arr.set(parent,arr.get(index));
            arr.set(index,temp);
            heapifyUp(parent);
        }
    }

    public void printHeap(){
        System.out.println("Current Heap State");
        System.out.println(arr.toString());
    }
}