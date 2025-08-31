class Solution {
    private boolean[][] rowUsed = new boolean[9][9];
    private boolean[][] colUsed = new boolean[9][9];
    private boolean[][] boxUsed = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        // Pre-fill usage trackers
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    rowUsed[i][num] = true;
                    colUsed[j][num] = true;
                    boxUsed[boxIndex(i, j)][num] = true;
                }
            }
        }
        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int row, int col) {
        if (row == 9) return true; // finished

        int nextRow = (col == 8) ? row + 1 : row;
        int nextCol = (col + 1) % 9;

        if (board[row][col] != '.')
            return dfs(board, nextRow, nextCol);

        for (int num = 0; num < 9; num++) {
            if (!rowUsed[row][num] && !colUsed[col][num] && !boxUsed[boxIndex(row, col)][num]) {
                // place number
                board[row][col] = (char) (num + '1');
                rowUsed[row][num] = colUsed[col][num] = boxUsed[boxIndex(row, col)][num] = true;

                if (dfs(board, nextRow, nextCol))
                    return true;

                // backtrack
                board[row][col] = '.';
                rowUsed[row][num] = colUsed[col][num] = boxUsed[boxIndex(row, col)][num] = false;
            }
        }

        return false;
    }

    private int boxIndex(int row, int col) {
        return (row / 3) * 3 + (col / 3);
    }
}
