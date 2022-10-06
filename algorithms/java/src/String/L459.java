package String;

/**
 * 459. 重复的子字符串
 *
 * @author zzf
 * @date 2022/10/7 2:52 上午
 */
public class L459 {
    public boolean repeatedSubstringPattern(String s) {
        if (s.isEmpty()) {
            return false;
        }
        int len = s.length();
        // 使下标从1开始，j从0开始，不用初始化
        s = " " + s;
        char[] chars = s.toCharArray();
        int[] next = new int[len + 1];
        for (int i = 2, j = 0; i <= len; i++) {
            while (j > 0 && chars[i] != chars[j + 1]) {
                j = next[j];
            }
            if (chars[i] == chars[j + 1]) {
                j++;
            }
            next[i] = j;
        }
        // next[len] 即代表next数组末尾的值，字符串重复时j会一直加
        if (next[len] > 0 && len % (len - next[len]) == 0) {
            return true;
        }
        return false;
    }
}
