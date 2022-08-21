package hot100;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 12. 整数转罗马数字
 *  贪心思想
 * @author zzf
 * @date 2022/8/21 10:18 下午
 */
public class hot12 {
    public String intToRoman(int num) {
        Map<String, Integer> map = new LinkedHashMap<>();
        StringBuilder ans = new StringBuilder();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (num >= entry.getValue()) {
                int count = num / entry.getValue();
                for (int i = 0; i < count; i++) {
                    ans.append(entry.getKey());
                }
                num %= entry.getValue();
            }
        }
        return ans.toString();
    }
}
