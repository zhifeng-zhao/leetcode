package jzoffer.other;

/**
 * @author 剪绳子
 * @date 2022/8/17 9:01 下午
 */
public class JZ14 {
    public int cutRope(int n) {
        //不超过3直接计算
        if (n <= 3) {
            return n - 1;
        }
        // dp[i]表示长度为i的绳子可以被剪出来的最大乘积
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        // 遍历后续每一个长度
        for (int i = 5; i <= n; i++) {
            // 可以被分成两份
            for (int j = 1; j < i; j++) {
                // 取最大值
                dp[i] = Math.max(dp[i], j * dp[i - j]);
            }
        }
        return dp[n];
    }

    public int cutRope2(int target) {
        //不超过3直接计算
        if (target <= 3) {
            return target - 1;
        }
        int res = 1;
        while (target > 4) {
            //连续乘3
            res *= 3;
            target -= 3;
        }
        return res * target;
    }
}
