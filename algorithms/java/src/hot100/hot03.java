package hot100;

import java.util.HashMap;

/**
 * 3. 无重复字符的最长子串
 *  滑动窗口
 * @author zzf
 * @date 2022/8/18 1:24 下午
 */
public class hot03 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, res = 0;
        while (right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            while (map.get(s.charAt(right)) > 1) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        new hot03().lengthOfLongestSubstring(
                "abcabcbb");
    }
}
