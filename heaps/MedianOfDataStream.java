import java.util.*;

public class MedianOfDataStream {
    public static void main(String[] args) {
        int[] nums = {1,80,6};

        MedianFinderPQ pq = new MedianFinderPQ();
        MedianFinderList list = new MedianFinderList();

        for(int i: nums){
            pq.addNum(i);
            list.addNum(i);
            System.out.println(pq.findMedian());
            System.out.println(list.findMedian());
        }
    }
}

/// Priority Queue Implementation
class MedianFinderPQ {

    private PriorityQueue<Integer> max;
    private PriorityQueue<Integer> min;

    public MedianFinderPQ() {
        max= new PriorityQueue<>((a,b)-> b-a);
        min= new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(max.isEmpty()|| num <= max.peek())
            max.offer(num);
        else
            min.offer(num);

        if(max.size() > min.size()+1){
            min.offer(max.poll());
        }else if(min.size()>max.size()){
            max.offer(min.poll());
        }

    }

    public double findMedian() {
        if(max.size()==min.size())
            return (max.peek()+min.peek())/2.0;
        return max.peek();
    }
}

/// Brute Force Approach
class MedianFinderList {

    private List<Integer> list;

    public MedianFinderList() {
        list= new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        if(list.isEmpty()){
            return 0.0;
        }
        List<Integer> sorted = new ArrayList<>(list);
        Collections.sort(sorted);
        int n= sorted.size();
        if(n%2==1){
            return (double) sorted.get(n/2);
        }
        return (sorted.get(n/2-1)+sorted.get(n/2))/2.0;

    }
}