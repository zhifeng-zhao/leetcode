package jzoffer.dp;

import java.util.Arrays;

/**
 * 把数字翻译成字符串
 *
 * @author zzf
 * @date 2022/8/16 12:18 下午
 */
public class JZ46 {
    public int solve(String nums) {
        //排除0
        if ("0".equals(nums)) {
            return 0;
        }
        //排除只有一种可能的10 和 20
        if ("10".equals(nums) || "20".equals(nums)) {
            return 1;
        }
        //当0的前面不是1或2时，无法译码，0种
        for (int i = 1; i < nums.length(); i++) {
            if (nums.charAt(i) == '0') {
                if (nums.charAt(i - 1) != '1' && nums.charAt(i - 1) != '2') {
                    return 0;
                }
            }
        }
        int[] dp = new int[nums.length() + 1];
        //辅助数组初始化为1
        Arrays.fill(dp, 1);
        for (int i = 2; i <= nums.length(); i++) {
            //在11-19，21-26之间的情况
            if ((nums.charAt(i - 2) == '1' && nums.charAt(i - 1) != '0')
                    || (nums.charAt(i - 2) == '2' && nums.charAt(i - 1) > '0' && nums.charAt(i - 1) < '7')) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[nums.length()];
    }
}
