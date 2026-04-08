public class FloydWarshallAlgo {
    public static void main(String[] args) {

        int[][] matrix = {
                {0, 2, -1, -1},
                {1, 0, 3, -1},
                {-1, -1, 0, -1},
                {3, 5, 4, 0}
        };

        FloydWarshallAlgoSolution sol = new FloydWarshallAlgoSolution();

        sol.shortestDistance(matrix);

        // Output
        int n = matrix.length;
        System.out.println("The shortest distance matrix is:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class FloydWarshallAlgoSolution {
    public void shortestDistance(int[][] matrix) {
        int n = matrix.length;

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(matrix[i][k] == -1 || matrix[k][j] == -1){
                        continue;
                    }

                    if(matrix[i][j] == -1){
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }else{
                        matrix[i][j] = Math.min(matrix[i][j],matrix[i][k] + matrix[k][j]);
                    }
                }
            }
        }

    }
}

