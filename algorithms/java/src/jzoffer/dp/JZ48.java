package jzoffer.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长不含重复字符的子字符串
 * 滑动窗口
 *
 * @author zzf
 * @date 2022/8/16 12:18 下午
 */
public class JZ48 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            // 统计窗口里出现的次数
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            // 出现重复
            while (map.get(s.charAt(right)) > 1) {
                // 窗口左移，直到无重复字母
                map.put(s.charAt(left), map.get(s.charAt(left++)) - 1);
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    /**
     * 动态规划➕哈希表
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        // 存放所有字母及位置
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int[] dp = new int[s.length() + 1];
        dp[1] = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (!map.containsKey(s.charAt(i - 1))) {
                // 不重复距离加1
                dp[i] = dp[i - 1] + 1;
            } else {
                // 取重复长度与当前长度最小值
                dp[i] = Math.min(dp[i - 1] + 1, i - map.get(s.charAt(i - 1)));
            }
            // 更新字母位置
            map.put(s.charAt(i - 1), i);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        new JZ48().lengthOfLongestSubstring2("abcabcbb");
    }
}
