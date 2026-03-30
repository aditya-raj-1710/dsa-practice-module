import java.util.Arrays;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {{1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}};
        int sr = 1, sc = 1;
        int newColor = 2;

        FloodFillSolution sol = new FloodFillSolution();

        int[][] ans = sol.floodFill(image, sr, sc, newColor);

        System.out.println("Image after performing flood fill algorithm:\n");

        for (int[] row : ans) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}

class FloodFillSolution {
    private int[] delRow = {-1,0,1,0};
    private int[] delCol = {0,1,0,-1};

    private boolean isValid(int i, int j, int n, int m){
        if(i <0 || i>= n) return false;
        if(j<0 || j>= m) return false;

        return true;
    }

    private void dfs(int row, int col, int[][] ans, int[][] image, int newColor, int initColor){
        ans[row][col] = newColor;

        int n = image.length;
        int m = image[0].length;

        for(int i=0; i<4;i++){
            int newRow = row+delRow[i];
            int newCol = col+delCol[i];

            if(isValid(newRow,newCol,n,m) &&
                    image[newRow][newCol] == initColor && ans[newRow][newCol] != newColor){
                dfs(newRow,newCol,ans,image,newColor,initColor);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int initColor = image[sr][sc];
        int[][] ans = new int[image.length][image[0].length];

        for(int i=0;i<image.length;i++){
            ans[i] = Arrays.copyOf(image[i],image[i].length);
        }

        dfs(sr,sc,ans,image,newColor,initColor);

        return ans;
    }
}
