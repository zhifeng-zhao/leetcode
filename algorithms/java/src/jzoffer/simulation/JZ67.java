package jzoffer.simulation;

/**
 * 把字符串转换成整数(atoi)
 *
 * @author zzf
 * @date 2022/8/16 5:41 下午
 */
public class JZ67 {
    public int StrToInt(String s) {
        int res = 0;
        // 除去多余空格
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        // 处理标记位
        int sign = 1;
        if (s.charAt(0) == '-') {
            sign = -1;
            s = s.substring(1);
        } else if (s.charAt(0) == '+') {
            s = s.substring(1);
        }
        if (s.length() == 0) {
            return 0;
        }
        for (char c : s.toCharArray()) {
            if (c < '0' || c > '9') {
                break;
            }
            //处理越界
            if (res > Integer.MAX_VALUE / 10
                    || (res == Integer.MAX_VALUE / 10 && (c - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10
                    || (res == Integer.MIN_VALUE / 10 && (c - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + sign * (c - '0');
        }
        return res;
    }
}
