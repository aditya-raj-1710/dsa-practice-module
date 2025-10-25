class RotateMatrix{
    public static void main(String[] args) {
        RotateMatrixSolution solution = new RotateMatrixSolution();
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        solution.printMatrix(matrix);
        solution.rotateMatrix(matrix);
        System.out.println();
        solution.printMatrix(matrix);
    }
}
class RotateMatrixSolution {
    public void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i<n;i++){
            for(int j=0;j<i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }

    public void printMatrix(int[][] matrix){
        for(int i=0; i< matrix.length; i++){
            for(int j=0; j< matrix.length; j++){
                System.out.print(matrix[i][j] +"  ");
            }
            System.out.println();
        }
    }

}