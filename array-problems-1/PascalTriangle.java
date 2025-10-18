import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        PascalTriangleSolution solution = new PascalTriangleSolution();
        System.out.println(solution.generate(5));
    }
}
class PascalTriangleSolution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> finalArray = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> rowArray = new ArrayList<>();
            rowArray.add(0, 1);
            for (int j = 1; j < i; j++) {
                rowArray.add(j, (rowArray.get(j - 1) * (i - j)) / (j));
            }
            finalArray.add(rowArray);
        }
        return finalArray;
    }
}