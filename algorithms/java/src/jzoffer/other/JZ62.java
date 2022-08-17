package jzoffer.other;

/**
 * 孩子们的游戏(圆圈中最后剩下的数)
 *
 * @author zzf
 * @date 2022/8/17 8:27 下午
 */
public class JZ62 {
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }
        return fund(n, m);
    }

    private int fund(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = fund(n - 1, m);
        return (m + x) % n;
    }
}
