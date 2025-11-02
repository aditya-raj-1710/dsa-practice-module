public class Search2dMatrix {
    public static void main(String[] args) {
        Search2dMatrixSolution solution = new Search2dMatrixSolution();
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int target = 90;
        System.out.println(solution.searchMatrix(matrix,target));
    }
}

class Search2dMatrixSolution {
    public boolean searchMatrix(int[][] mat, int target) {
        for(int[] row : mat){
            if(target >= row[0] && target <= row[row.length-1]){
                for(int item: row){
                    if(item == target){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}