package hot100;


/**
 * 5. 最长回文子串
 * 中间扩散法
 *
 * @author zzf
 * @date 2022/8/19 6:30 下午
 */
public class hot05 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                end = i + len / 2;
                start = i - (len - 1) / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 循环结束后r-l为外层长度，需要减1
        return right - left - 1;
    }

    public static void main(String[] args) {
        new hot05().longestPalindrome("babad");
    }
}
