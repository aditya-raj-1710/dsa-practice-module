import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervalSolution solution = new MergeIntervalSolution();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        solution.displayIntervals(intervals);
        int[][] result = solution.merge(intervals);
        solution.displayIntervals(result);

        List<List<Integer>> intervalsV2 = new ArrayList<>();
        for(int[] interval: intervals){
            List<Integer> listInterval = new ArrayList<>();
            listInterval.add(0,interval[0]);
            listInterval.add(1,interval[1]);
            intervalsV2.add(listInterval);
        }
        System.out.println(intervalsV2);
        List<List<Integer>> results = solution.mergeOverlap(intervalsV2);
        System.out.println(results);

    }
}

class MergeIntervalSolution {
    public List<List<Integer>> mergeOverlap(List<List<Integer>> intervals) {
        // Your code goes here
        List<List<Integer>> mergedIntervals = new ArrayList<>();
        if(intervals.isEmpty()){
            return mergedIntervals;
        }
        intervals.sort(Comparator.comparingInt(a -> a.get(0)));
        mergedIntervals.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            int intervalStart = intervals.get(i).get(0);
            int intervalEnd = intervals.get(i).get(1);
            if(intervalStart <= mergedIntervals.get(mergedIntervals.size()-1).get(1)){
                mergedIntervals.get(mergedIntervals.size()-1)
                        .set(1,Math.max(intervalEnd,mergedIntervals.get(mergedIntervals.size()-1).get(1)));
            }else{
                mergedIntervals.add(intervals.get(i));
            }
        }

        return mergedIntervals;
    }

    public int[][] merge(int[][] intervals) {
        if(intervals.length ==0){
            return new int[0][0];
        }
        List<int[]> mergedIntervals = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        mergedIntervals.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int intervalStart = intervals[i][0];
            int intervalEnd = intervals[i][1];
            if(intervalStart <= mergedIntervals.get(mergedIntervals.size()-1)[1]){
                mergedIntervals.get(mergedIntervals.size()-1)[1]=
                        Math.max(intervalEnd,
                                mergedIntervals.get(mergedIntervals.size()-1)[1]);
            }else{
                mergedIntervals.add(intervals[i]);
            }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public void displayIntervals(int[][] intervals){
        for (int[] interval : intervals) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
        System.out.println();
    }

}

