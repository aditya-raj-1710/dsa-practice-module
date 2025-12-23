import java.util.ArrayList;
import java.util.List;

public class RatInMaze {
    public static void main(String[] args) {
        RatInMazeSolution sol = new RatInMazeSolution();
        int[][] grid = {
                {1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1},
                {0, 1, 0, 0, 1},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 1}
        };

        List<String> paths = sol.findPath(grid);

        for (String path : paths) {
            System.out.println(path+"  ");
        }
    }
}

class RatInMazeSolution {
    private List<String> result = new ArrayList<>();

    public List<String> findPath(int[][] grid) {
        int n = grid.length;

        result.clear();

        if(grid[0][0] == 0 || grid[n-1][n-1] ==0){
            return result;
        }

        path(grid,0,0,"",n);
        return result;
    }

    private void path(int[][] m, int x, int y, String dir, int n){
        if(x==n-1 && y==n-1){
            result.add(dir);
            return;
        }

        if(m[x][y] ==0){
            return;
        }

        m[x][y] =0;

        if(x>0){
            path(m,x-1,y,dir+"U",n);
        }
        if(y>0){
            path(m,x,y-1,dir+"L",n);
        }
        if(x<n-1){
            path(m,x+1,y,dir+"D",n);
        }
        if(y<n-1){
            path(m,x,y+1,dir+"R",n);
        }

        m[x][y] =1;
    }
}
