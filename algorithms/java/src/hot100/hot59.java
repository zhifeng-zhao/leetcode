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

    public int[][] generateMatrix2(int n) {
        int[][] res = new int[n][n];
        // 循环次数
        int loop = 0;
        // 循环开始位置
        int start = 0;
        int count = 1;
        int i, j;
        while (loop++ < n / 2) {
            for (j = start; j < n - loop; j++) {
                res[start][j] = count++;
            }
            for (i = start; i < n - loop; i++) {
                res[i][j] = count++;
            }
            for (; j >= loop; j--) {
                res[i][j] = count++;
            }
            for (; i >= loop; i--) {
                res[i][j] = count++;
            }
            start++;
        }
        // 如果n为奇数，单独给矩阵中间位置赋值
        if (n % 2 == 1) {
            res[start][start] = count;
        }
        return res;
    }
}
