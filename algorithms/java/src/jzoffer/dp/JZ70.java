package jzoffer.dp;

/**
 *  矩形覆盖
 * @author zzf
 * @date 2022/8/16 3:02 上午
 */
public class JZ70 {
    public int rectCover(int target) {
        if (target == 0) {
            return 0;
        }
        int sum = 0;
        int a = 0;
        int b = 1;
        for (int i = 1; i <= target; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }
}
