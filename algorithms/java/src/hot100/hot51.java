package hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 51. N 皇后
 *
 * @author zzf
 * @date 2022/9/9 6:14 下午
 */
public class hot51 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        String[][] board = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ".";
            }
        }
        backtrack(n, 0, board);
        return res;
    }

    public void backtrack(int n, int row, String[][] board) {
        if (row == n) {
            LinkedList<String> track = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(board[i][j]);
                }
                track.add(sb.toString());
            }
            res.add(track);
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(i, row, board)) {
                continue;
            }
            board[row][i] = "Q";
            backtrack(n, row + 1, board);
            board[row][i] = ".";
        }
    }

    public boolean isValid(int col, int row, String[][] board) {
        int n = board.length;
        for (int i = 0; i < row; i++) {
            if ("Q".equals(board[i][col])) {
                return false;
            }
        }
        // 检查右上方
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if ("Q".equals(board[i][j])) {
                return false;
            }
        }
        // 检查左上方
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if ("Q".equals(board[i][j])) {
                return false;
            }
        }
        return true;
    }
}
