package hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. 串联所有单词的子串
 *
 * @author zzf
 * @date 2022/8/25 3:43 下午
 */
public class hot30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        int wordNum = words.length;
        int wordLen = words[0].length();
        for (int i = 0; i < s.length() - wordNum * wordLen + 1; i++) {
            // 单词出现的次数
            Map<String, Integer> map = new HashMap<>();
            int num = 0;
            while (num < wordNum) {
                String str = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                if (wordMap.containsKey(str)) {
                    map.put(str, map.getOrDefault(str, 0) + 1);
                    if (map.get(str) > wordMap.get(str)) {
                        break;
                    }
                } else {
                    break;
                }
                num++;
            }
            if (num == wordNum) {
                res.add(i);
            }
        }
        return res;
    }
}
