package jzoffer.bit;

/**
 * 求1+2+3+...+n
 *
 * @author zzf
 * @date 2022/8/15 4:26 下午
 */
public class JZ64 {
    public int Sum_Solution(int n) {
        if (n > 1) {
            n += Sum_Solution(n - 1);
        }
        return n;
    }
}
