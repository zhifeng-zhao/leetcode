package twopoint;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. 字符串的排列
 *      给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回true；否则，返回false。
 *      换句话，说s1的排列之一是s2的子串。
 * 思路：滑动窗口
 *      滑动窗口类型有一个t和s，现将t加到target里
 *      像右滑动窗口，向window添加target里包含的数据
 *      当window里包含target所需数据时，收缩左侧窗口
 *      当window里不满足target所需数据时，收缩完成
 *      当len等于s1长度时，s2包含s1
 * @author zzf
 * @date 2022/3/20 9:39 下午
 */
public class Permutation {
    Map<Character, Integer> target = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();

    public boolean checkInclusion(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            target.put(s1.charAt(i), target.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int left = 0, right = -1;
        int len = Integer.MAX_VALUE;
        // 增加右侧窗口
        while (right < s2.length()) {
            right++;
            if (right < s2.length() && target.containsKey(s2.charAt(right))) {
                window.put(s2.charAt(right), window.getOrDefault(s2.charAt(right), 0) + 1);
            }
            // 判断左侧窗口是否收缩
            while (check() && left <= right) {
                if (right - left + 1 < len) {
                    len = right - left + 1;
                }
                if (target.containsKey(s2.charAt(left))) {
                    window.put(s2.charAt(left), window.getOrDefault(s2.charAt(left), 0) - 1);
                }
                // 判断s2是否包含s1
                if (len == s1.length()) {
                    return true;
                }
                left++;
            }
        }
        return false;
    }

    public boolean check() {
        for (Map.Entry<Character, Integer> entry : target.entrySet()) {
            if (window.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Permutation().checkInclusion("ab", "eidbao"));
    }
}
