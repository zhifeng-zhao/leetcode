package jzoffer.dp;

/**
 * 连续子数组的最大和
 *
 * @author zzf
 * @date 2022/8/15 4:43 下午
 */
public class JZ42 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length];
        int max = array[0];
        dp[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            // 动态规划，状态转移方程，确定dp[i]的最大值
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            // 每次比较，保存出现的最大值
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 优化动态规划
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray2(int[] array) {
        int sum = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            sum = Math.max(sum + array[i], array[i]);
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        new JZ42().FindGreatestSumOfSubArray(new int[]{1, -2, 3, 10, -4, 7, 2, -5});
    }
}
