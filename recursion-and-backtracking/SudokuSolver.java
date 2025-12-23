public class SudokuSolver {
    public static void main(String[] args) {
        SudokuSolverSolution solution = new SudokuSolverSolution();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solution.solveSudoku(board);
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + "   ");
            }
            System.out.println();
        }
    }
}

class SudokuSolverSolution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        int n = 9;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    for (char digit = '1'; digit <= '9'; digit++) {
                        if (areRulesMet(board, i, j, digit)) {
                            board[i][j] = digit;

                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean areRulesMet(char[][] board, int row, int col, char digit) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digit || board[row][i] == digit) {
                return false;
            }
        }
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }
}

