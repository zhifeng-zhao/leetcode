package jzoffer.dp;

/**
 * 礼物的最大价值
 *
 * @author zzf
 * @date 2022/8/16 3:32 上午
 */
public class JZ47 {
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid[0].length;
        int dp[] = new int[n];
        for (int[] ints : grid) {
            dp[0] += ints[0];
            // 逐层遍历，比较向下或向右的的值
            for (int i = 1; i < ints.length; i++) {
                dp[i] = Math.max(dp[i], dp[i - 1]) + ints[i];
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{9,1,4,8}};
        new JZ47().maxValue(a);
    }
}
