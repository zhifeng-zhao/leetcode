package twopoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. 找到字符串中所有字母异位词
 * 给定两个字符串s和p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词:指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * @author zzf
 * @date 2022/3/21 11:37 下午
 */
public class FindAllAnagrams {
    Map<Character, Integer> target = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();
    List<Integer> ans = new ArrayList<>();

    public List<Integer> findAnagrams(String s, String p) {
        for (int i = 0; i < p.length(); i++) {
            target.put(p.charAt(i), target.getOrDefault(p.charAt(i), 0) + 1);
        }
        int left = 0, right = -1, len;
        while (right < s.length()) {
            right++;
            if (right < s.length() && target.containsKey(s.charAt(right))) {
                window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
            }
            while (check() && left <= right) {
                len = right - left + 1;
                if (target.containsKey(s.charAt(left))) {
                    window.put(s.charAt(left), window.getOrDefault(s.charAt(left), 0) - 1);
                }
                if (len == p.length()) {
                    ans.add(left);
                }
                left++;
            }
        }
        return ans;
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
        System.out.println(new FindAllAnagrams().findAnagrams("cbaebabacd", "abc"));
    }
}
