package jzoffer.other;

/**
 * 整数中1出现的次数（从1到n整数中1出现的次数）
 *
 * @author zzf
 * @date 2022/8/17 4:44 下午
 */
public class JZ43 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int res = 0;
        //MulBase = 10^i
        long MulBase = 1;
        //每位数按照公式计算
        for (int i = 0; MulBase <= n; i++) {
            //根据公式添加
            res += (n / (MulBase * 10)) * MulBase
                    + Math.min(Math.max(n % (MulBase * 10) - MulBase + 1, (long) 0), MulBase);
            //扩大一位数
            MulBase *= 10;
        }
        return res;
    }

    public int NumberOf1Between1AndN_Solution2(int n) {
        int res = 0;
        //遍历1-n
        for (int i = 1; i <= n; i++) {
            //遍历每个数的每一位
            for (int j = i; j > 0; j = j / 10) {
                //遇到数字1计数
                if (j % 10 == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new JZ43().NumberOf1Between1AndN_Solution(132);
    }
}
