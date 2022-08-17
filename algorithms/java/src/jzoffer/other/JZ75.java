package jzoffer.other;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符流中第一个不重复的字符
 *
 * @author zzf
 * @date 2022/8/17 8:52 下午
 */
public class JZ75 {
    private StringBuffer str = new StringBuffer();
    private Map<Character, Integer> map = new HashMap<>();

    public void Insert(char ch) {
        str.append(ch);
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    public char FirstAppearingOnce() {
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                return str.charAt(i);
            }
        }
        return '#';
    }
}
