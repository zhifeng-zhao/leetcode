package hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. 字母异位词分组
 *
 * @author zzf
 * @date 2022/9/9 5:19 下午
 */
public class hot49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String code = code(str);
            map.putIfAbsent(code, new ArrayList<>());
            map.get(code).add(str);
        }
        map.forEach((k, v) -> {
            ans.add(new ArrayList<>(v));
        });
        return ans;
    }

    public String code(String str) {
        char[] chars = new char[26];
        for (int i = 0; i < str.length(); i++) {
            int count = str.charAt(i) - 'a';
            chars[count]++;
        }
        return new String(chars);
    }
}
