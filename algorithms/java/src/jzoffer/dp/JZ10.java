package jzoffer.dp;

/**
 * 斐波那契数列
 *
 * @author zzf
 * @date 2022/8/15 4:31 下午
 */
public class JZ10 {
    /**
     * 递归
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int Fibonacci2(int n) {
        if (n < 2){
            return n;
        }
        int res = 0;
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            // 第三项开始是前两项的和,然后保留最新的两项，更新数据相加
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}
