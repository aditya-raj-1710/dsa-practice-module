import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '0', '1'},
                {'1', '0', '0', '0', '0'},
                {'1', '1', '1', '0', '1'},
                {'0', '0', '0', '1', '1'}
        };

        NumberOfIslandsSolution sol = new NumberOfIslandsSolution();

        int ans = sol.numIslands(grid);

        System.out.println("The total islands in given grids are: " + ans);
    }
}

class NumberOfIslandsSolution {
    public int numIslands(char[][] grid) {
        int n= grid.length;
        int m=grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int count=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    count++;
                    bfs(i,j,grid,visited);
                }
            }
        }
        return count;
    }

    private void bfs(int row, int col, char[][] grid, boolean[][] visited){
        visited[row][col] = true;
        int n= grid.length;
        int m= grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row,col});

        while(!q.isEmpty()){
            int r =q.peek()[0];
            int c =q.peek()[1];
            q.poll();

            //traverse neighbor all 8 directions, can be modified or interchanged with only 4 neighbors
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int nRow =r+i;
                    int nCol = c+j;

                    if(isValid(nRow, nCol, n,m) && grid[nRow][nCol] == '1' && !visited[nRow][nCol] ){
                        visited[nRow][nCol] = true;
                        q.offer(new int[]{nRow,nCol});
                    }
                }
            }
        }
    }

    private boolean isValid(int nRow,int nCol, int n, int m){
        if(nRow < 0 || nRow >= n){
            return false;
        }

        if(nCol <0 || nCol >= m){
            return false;
        }
        return true;
    }
}


