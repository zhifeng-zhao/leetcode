package hot100;

/**
 * 36. 有效的数独
 *
 * @author zzf
 * @date 2022/8/27 2:24 下午
 */
public class hot36 {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] column = new int[9][9];
        int[][][] box = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    row[i][index]++;
                    column[j][index]++;
                    box[i / 3][j / 3][index]++;
                    if (row[i][index] > 1 || column[j][index] > 1 || box[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
