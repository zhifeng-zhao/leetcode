package hot100;

/**
 * 37. 解数独
 *
 * @author zzf
 * @date 2022/9/6 10:19 下午
 */
public class hot37 {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    public boolean backtrack(char[][] board, int r, int c) {
        if (c == 9) {
            return backtrack(board, r + 1, 0);
        }
        if (r == 9) {
            return true;
        }
        if (board[r][c] != '.') {
            return backtrack(board, r, c + 1);
        }
        for (char i = '1'; i <= '9'; i++) {
            if (!isValid(board, r, c, i)) {
                continue;
            }
            board[r][c] = i;
            if (backtrack(board, r, c + 1)) {
                return true;
            }
            board[r][c] = '.';
        }
        return false;
    }

    public boolean isValid(char[][] board, int r, int c, char n) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == n) {
                return false;
            }
            if (board[i][c] == n) {
                return false;
            }
            if (board[(r / 3) * 3 + i / 3][(c / 3) * 3 + i % 3] == n) {
                return false;
            }
        }
        return true;
    }
}
