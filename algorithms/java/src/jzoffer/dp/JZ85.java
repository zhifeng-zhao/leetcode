package jzoffer.dp;

/**
 * 连续子数组的最大和(二)
 *
 * @author zzf
 * @date 2022/8/15 5:03 下午
 */
public class JZ85 {
    public int[] FindGreatestSumOfSubArray(int[] array) {
        int sum = array[0];
        int max = array[0];
        int left = 0;
        int right = 0;
        int rl = 0;
        for (int i = 1; i < array.length; i++) {
            // 确认区间起点
            if (sum + array[i] < array[i]) {
                left = i;
            }
            // 状态转移
            sum = Math.max(sum + array[i], array[i]);
            // 更新区间
            if (sum >= max) {
                right = i;
                rl = left;
            }
            max = Math.max(sum, max);
        }
        int[] ans = new int[right - rl + 1];
        for (int i = rl; i <= right; i++) {
            ans[i - rl] = array[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        new JZ85().FindGreatestSumOfSubArray(new int[]{1, -2, 3, 10, -4, 7, 2, -5});
        //new JZ85().FindGreatestSumOfSubArray(new int[]{-2, -8, -1, -5, -9});
        //new JZ85().FindGreatestSumOfSubArray(new int[]{1});
    }
}
