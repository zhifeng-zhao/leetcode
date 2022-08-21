package hot100;

/**
 * 10. 正则表达式匹配
 *
 * @author zzf
 * @date 2022/8/21 4:54 下午
 */
public class hot10 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] t = new boolean[m + 1][n + 1];
        t[0][0] = true;
        for (int i = 0; i <= s.length(); ++i) {
            for (int j = 1; j <= p.length(); ++j) {
                if (p.charAt(j - 1) == '*') {
                    t[i][j] = t[i][j - 2];
                    if (match(s, p, i, j - 1)) {
                        t[i][j] = t[i][j] || t[i - 1][j];
                    }
                } else {
                    if (match(s, p, i, j)) {
                        t[i][j] = t[i - 1][j - 1];
                    }
                }
            }
        }
        return t[m][n];
    }

    private boolean match(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {
        new hot10().isMatch("aa","a*");
    }
}
