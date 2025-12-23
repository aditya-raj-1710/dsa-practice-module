import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {
    public static void main(String[] args) {
        NQueenProblemSolution solution = new NQueenProblemSolution();
        int n = 4; // Example with 4 queens
        List<List<String>> solutions = solution.solveNQueens(n);

        // Print all solutions
        for (List<String> sol : solutions) {
            for (String row : sol) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}

class NQueenProblemSolution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();
        for(int i=0;i<n;i++){
            board.add(".".repeat(n));
        }

        func(0,ans,board);

        return ans;
    }

    private void func(int row, List<List<String>> ans, List<String> board){
        if(row == board.size()){
            ans.add(new ArrayList<>(board));
            return;
        }

        for(int col=0; col < board.get(0).length();col++){
            if(isSafe(board,row,col)){
                char[] rowArr = board.get(row).toCharArray();
                rowArr[col] = 'Q';
                board.set(row, new String(rowArr));

                func(row+1,ans,board);

                rowArr[col] ='.';
                board.set(row, new String(rowArr));
            }
        }
    }

    private boolean isSafe(List<String> board, int row, int col){
        int r=row, c=col;

        while(r>=0 && c>=0){
            if(board.get(r).charAt(c) == 'Q'){
                return false;
            }
            c--;
            r--;
        }

        r=row;
        c=col;

        while(r>=0){
            if(board.get(r).charAt(c) == 'Q'){
                return false;
            }
            r--;
        }

        r=row;
        c=col;

        while(r>=0 && c< board.get(0).length()){
            if(board.get(r).charAt(c) == 'Q'){
                return false;
            }
            r--;
            c++;
        }

        return true;

    }
}
