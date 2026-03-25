import java.util.*;

public class MedianInStream {
    public static void main(String[] args) {
        int[] arr = {5, 15, 1, 3, 2, 8};
        System.out.println(new MedianInStreamSolution().getMedian(arr));
    }
}


class MedianInStreamSolution {
    public List<Double> getMedianBrute(int[] arr) {
        List<Integer> sortedArr = new ArrayList<>();
        List<Double> median = new ArrayList<>();

        for (int num : arr) {
            int pos = Collections.binarySearch(sortedArr, num);
            if (pos < 0) {
                pos = -(pos + 1);
            }
            sortedArr.add(pos, num);
            int n = sortedArr.size();
            if (n % 2 == 0) {
                median.add((sortedArr.get(n / 2) + sortedArr.get(n / 2 - 1)) / 2.0);
            } else {
                median.add((double) sortedArr.get(n / 2));
            }
        }

        return median;
    }

    public List<Double> getMedian(int[] arr) {
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b) -> b-a);
        PriorityQueue<Integer> min = new PriorityQueue<>();
        List<Double> medians = new ArrayList<>();

        for(int num: arr){
            if(max.isEmpty() || num <= max.peek()){
                max.offer(num);
            }else{
                min.offer(num);
            }

            if(max.size() > min.size() +1){
                min.offer(max.poll());
            }else if (min.size() > max.size()){
                max.offer(min.poll());
            }

            if(max.size() == min.size()){
                medians.add((max.peek()+min.peek())/2.0);
            }else{
                medians.add((double)max.peek());
            }
        }
        return medians;
    }
}

/// Leetcode Optimal implementation
class MedianFinder {

    private PriorityQueue<Integer> max;
    private PriorityQueue<Integer> min;

    public MedianFinder() {
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

/// Leetcode Brute implementation
class MedianFinderBrute {

    private List<Integer> sortedArr;

    public MedianFinderBrute() {
        sortedArr= new ArrayList<>();
    }

    public void addNum(int num) {
        int pos = Collections.binarySearch(sortedArr,num);
        if(pos <0){
            pos= - (pos+1);
        }
        sortedArr.add(pos,num);
    }

    public double findMedian() {
        int n = sortedArr.size();

        if(n%2 == 1){
            return (double) sortedArr.get(n/2);
        }else{
            return (sortedArr.get(n/2-1)+sortedArr.get(n/2))/2.0;
        }
    }
}