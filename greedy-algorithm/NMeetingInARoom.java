import java.util.*;

public class NMeetingInARoom {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        NMeetingInARoomSolution solution = new NMeetingInARoomSolution();
        int maxMeetings = solution.maxMeetings(start,end);
        System.out.println(maxMeetings);
    }
}

class NMeetingInARoomSolution {
    public int maxMeetings(int[] start, int[] end) {
        int n= start.length;

        List<int[]> meetings = new ArrayList<>();

        for(int i=0;i< n;i++){
            meetings.add(new int[]{start[i],end[i]});
        }

        Collections.sort(meetings, new MeetingComparator());
        //Collections.sort(meetings, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        int limit = meetings.get(0)[1];
        int counter=1;
        for(int i=1;i<n;i++){
            if(meetings.get(i)[0] > limit){
                counter++;
                limit=meetings.get(i)[1];
            }
        }

        return counter;
    }
    /*static class MeetingComparator implements Comparator<int []>{
        public int compare(int[] a, int[] b){
            return Integer.compare(a[1],b[1]);
        }
    }*/
}
class MeetingComparator implements Comparator<int []>{
    public int compare(int[] a, int[] b){
        return Integer.compare(a[1],b[1]);
    }
}