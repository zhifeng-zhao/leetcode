package jzoffer.other;

import java.util.HashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符
 * @author zzf
 * @date 2022/8/16 8:33 下午
 */
public class JZ50 {
    public int FirstNotRepeatingChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < str.toCharArray().length; i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
