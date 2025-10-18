import java.util.*;

class SetMatrix{

    static public void setZeroesUsingMarkerArrays(int[][] matrix) {
        // Your code goes here
        int rows = matrix.length;
        int columns = matrix[0].length;
        List<Integer> zeroElementRows = new ArrayList<>();
        List<Integer> zeroElementColumns = new ArrayList<>();
        for(int i=0; i<rows; i++){
            for(int j=0; j< columns; j++){
                if(matrix[i][j] == 0){
                    zeroElementRows.add(i);
                    zeroElementColumns.add(j);
                }
            }
        }
        for(int i=0; i<rows; i++){
            for(int j=0; j< columns; j++){
                if(zeroElementRows.contains(i)||zeroElementColumns.contains(j)){
                    matrix[i][j]=0;
                }
            }
        }


    }

    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        for(int i=0;i<rows;i++){
            if(matrix[i][0] ==0){
                firstColZero = true;
                break;
            }
        }
        for(int j=0;j<columns;j++){
            if(matrix[0][j] == 0){
                firstRowZero = true;
                break;
            }
        }
        for(int i=1; i<rows; i++){
            for(int j=1; j< columns; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i=1; i<rows; i++){
            for(int j=1; j< columns; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j]=0;
                }
            }
        }

        if(firstRowZero){
            for(int j=0;j<columns;j++){
                matrix[0][j] =0;
            }
        }
        if(firstColZero){
            for(int i=0;i<rows;i++){
                matrix[i][0] =0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[2][3];

        for(int i=0; i<2; i++){
            for(int j=0; j< 3; j++){
                matrix[i][j] = (int)(10 * Math.random());
            }
        }
        matrix[1][2]=0;
        printMatrix(matrix);
        setZeroes(matrix);

        System.out.println();
        printMatrix(matrix);

    }


    public static void printMatrix(int[][] matrix){
        for(int i=0; i<2; i++){
            for(int j=0; j< 3; j++){
                System.out.print(matrix[i][j] +"  ");
            }
            System.out.println();
        }
    }

}