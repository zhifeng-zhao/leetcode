package hot100;

/**
 * 59. 螺旋矩阵 II
 *
 * @author zzf
 * @date 2022/8/29 6:32 下午
 */
public class hot59 {
    public int[][] generateMatrix(int n) {
        int r1 = 0, r2 = n - 1;
        int c1 = 0, c2 = n - 1;
        int num = 1;
        int[][] res = new int[n][n];
        while (r1 <= r2 && c1 <= c2) {
            for (int i = c1; i <= c2; i++) {
                res[r1][i] = num++;
            }
            for (int i = r1 + 1; i <= r2; i++) {
                res[i][c2] = num++;
            }
            if (r1 != r2) {
                for (int i = c2 - 1; i >= c1; i--) {
                    res[r2][i] = num++;
                }
            }
            if (c1 != c2) {
                for (int i = r2 - 1; i > r1; i--) {
                    res[i][c1] = num++;
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return res;
    }
}
