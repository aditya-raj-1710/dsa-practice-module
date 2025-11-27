import java.util.Arrays;

public class JobSequencing {
    public static void main(String[] args) {
        int[][] Jobs = {{1, 4, 20}, {2, 1, 10}, {3, 1, 40}, {4, 1, 30}};

        JobSequencingSolution solution = new JobSequencingSolution();
        int[] result = solution.JobScheduling(Jobs);
        System.out.println(result[0]+" "+result[1]);
    }
}
class JobSequencingSolution {
    public int[] JobScheduling(int[][] Jobs) {
        // your code goes here
        Arrays.sort(Jobs, (a, b) -> b[2] - a[2]);
        int n = Jobs.length;

        int maxDeadline = -1;

        for (int[] i : Jobs) {
            maxDeadline = Math.max(maxDeadline, i[1]);
        }

        int[] hash = new int[maxDeadline + 1];
        for (int i = 0; i < maxDeadline + 1; i++) {
            hash[i] = -1;
        }

        int profit = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = Jobs[i][1] - 1; j >= 0; j--) {
                if (hash[j] == -1) {
                    count++;
                    profit += Jobs[i][2];
                    hash[j] = Jobs[i][0];
                    break;
                }
            }
        }

        return new int[] {count, profit};
    }
}

