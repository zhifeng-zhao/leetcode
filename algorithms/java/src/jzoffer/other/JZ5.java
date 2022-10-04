package jzoffer.other;

/**
 * 替换空格
 *
 * @author zzf
 * @date 2022/8/17 2:44 下午
 */
public class JZ5 {
    public String replaceSpace(String s) {
        StringBuffer str = new StringBuffer();
        for (char c : s.toCharArray()) {
            if (' ' == c) {
                str.append("%20");
                continue;
            }
            str.append(c);
        }
        return str.toString();
    }

    public String replaceSpace2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        if (str.length() == 0) {
            return s;
        }
        int left = s.length() - 1;
        s += str;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left >= 0) {
            if (chars[left] == ' ') {
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right] = '%';
            } else {
                chars[right] = chars[left];
            }
            right--;
            left--;
        }
        return new String(chars);
    }
}
