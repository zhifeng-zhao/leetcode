package twopoint;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 *      给你一个字符串s、一个字符串t。返回s中涵盖t所有字符的最小子串。如果s中不存在涵盖t所有字符的子串，则返回空字符串"" 。
 * 思路：滑动窗口
 *      source存储所需要覆盖的字符串，window存储当前窗口下存在source的字符串数量。
 *      right++增加窗口的长度，当窗口里存在所需字符的数量全部大于source所需数量时，
 *      left++减少窗口长度，增加到window里字符数量不满足source所需数量且right等于left时，即为最小长度（len = right - left + 1）。
 *      len = right - left + 1
 * @author zzf
 * @date 2022/3/17 11:29 下午
 */
public class MinimumWindow {
    Map<Character, Integer> source = new HashMap();
    Map<Character, Integer> window = new HashMap();

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            source.put(c, source.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = -1;
        int ansL = -1, ansR = -1;
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            ++right;
            if (right < s.length() && source.containsKey(s.charAt(right))) {
                window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
            }
            while (check() && left <= right) {
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    ansL = left;
                    ansR = left + len;
                }
                if (source.containsKey(s.charAt(left))) {
                    window.put(s.charAt(left), window.getOrDefault(s.charAt(left), 0) - 1);
                }
                ++left;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        for (Map.Entry<Character, Integer> entry : source.entrySet()) {
            if (window.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumWindow().minWindow("a", "a"));
    }
}
