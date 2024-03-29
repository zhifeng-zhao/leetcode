package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 *
 * @author zzf
 * @date 2022/9/10 12:19 下午
 */
public class hot54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int r1 = 0;
        int r2 = matrix.length - 1;
        int c1 = 0;
        int c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int i = c1; i <= c2; i++) {
                res.add(matrix[r1][i]);
            }
            for (int i = r1 + 1; i <= r2; i++) {
                res.add(matrix[i][c2]);
            }
            if (r1 != r2) {
                for (int i = c2 - 1; i >= c1; i--) {
                    res.add(matrix[r2][i]);
                }
            }
            if (c1 != c2) {
                for (int i = r2 - 1; i > r1; i--) {
                    res.add(matrix[i][c1]);
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
