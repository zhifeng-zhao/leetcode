package queue;

import java.util.ArrayDeque;

/**
 * 1047. 删除字符串中的所有相邻重复项
 * @author zzf
 * @date 2022/10/7 6:25 下午
 */
public class L1047 {
    public String removeDuplicates(String s) {
        ArrayDeque<Character> que = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (que.isEmpty() || chars[i] != que.peek()) {
                que.push(chars[i]);
            } else {
                que.pop();
            }
        }
        String str = "";
        while (!que.isEmpty()) {
            str = que.poll() + str;
        }
        return str;
    }
}
