package jzoffer.other;

/**
 * 打印从1到最大的n位数
 *
 * @author zzf
 * @date 2022/8/17 9:55 下午
 */
public class JZ17 {
    public int[] printNumbers(int n) {
        int end = 1;
        for (int i = 1; i <= n; i++) {
            end *= 10;
        }
        int[] res = new int[end - 1];
        for (int i = 1; i < end; i++) {
            res[i - 1] = i;
        }
        return res;
    }
}
