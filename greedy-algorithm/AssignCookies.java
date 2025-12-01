import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        int[] Student = {1, 2};
        int[] Cookie = {1, 2, 3};

        AssignCookiesSolution solution = new AssignCookiesSolution();

        System.out.println(solution.findMaximumCookieStudents(Student,Cookie));
    }
}

class AssignCookiesSolution {
    public int findMaximumCookieStudents(int[] Student, int[] Cookie) {
        //your code goes here
        Arrays.sort(Student);
        Arrays.sort(Cookie);

        int m= Student.length;
        int n= Cookie.length;

        int l=0, r=0;

        while(l <m && r <n){
            if(Cookie[r] >= Student[l]){
                l++;
            }
            r++;
        }
        return l;
    }
}
