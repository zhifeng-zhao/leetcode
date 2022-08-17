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
}
