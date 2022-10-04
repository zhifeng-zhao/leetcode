package String;

/**
 * 151. 反转字符串中的单词
 *
 * @author zzf
 * @date 2022/10/4 4:31 下午
 */
public class L151 {
    public String reverseWords(String s) {
        // 去除多余空格
        StringBuilder sb = removeSpace(s);
        // 反转字符串
        reverse(sb, 0, sb.length() - 1);
        // 反转单词
        reverseWord(sb);
        return sb.toString();
    }

    private StringBuilder removeSpace(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') {
            start++;
        }
        while (s.charAt(end) == ' ') {
            end--;
        }
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        return sb;
    }

    private void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    private void reverseWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        while (start < sb.length()) {
            while (end < sb.length() && sb.charAt(end) != ' ') {
                end++;
            }
            reverse(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }
}
