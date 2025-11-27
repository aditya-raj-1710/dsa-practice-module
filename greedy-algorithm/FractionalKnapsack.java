import java.util.Arrays;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        long capacity = 50;

        FractionalKnapsackSolution s = new FractionalKnapsackSolution();
        System.out.println(s.fractionalKnapsack(val,wt,capacity));
        System.out.printf("%.6f", s.fractionalKnapsack(val, wt, capacity));
    }
}
class FractionalKnapsackSolution {

    /// TUF Knapsack problem solution
    public double fractionalKnapsack(int[] val, int[] wt, long cap) {
        int n = val.length;
        double[][] ratio = new double[n][2];

        for (int i = 0; i < n; i++) {
            ratio[i] = new double[] {(double) val[i] / wt[i], i};
        }

        Arrays.sort(ratio, (a, b) -> Double.compare(b[0], a[0]));

        double totalValue = 0.0;

        for (double[] r : ratio) {
            int i = (int) r[1];

            if (wt[i] <= cap) {
                totalValue += val[i];
                cap -= wt[i];
            } else {
                totalValue += val[i] * ((double) cap / wt[i]);
                break;
            }
        }

        return Math.round(totalValue * 1e6) / 1e6;
    }
}

