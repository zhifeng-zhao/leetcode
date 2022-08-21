package hot100;

/**
 * 13. 罗马数字转整数
 *
 * @author zzf
 * @date 2022/8/21 10:54 下午
 */
public class hot13 {
    public int romanToInt(String s) {
        int ans = 0;
        int pre = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            // 左边数字小于右边数字时减去左边数字
            if (pre < num) {
                ans -= pre;
            } else {
                ans += pre;
            }
            pre = num;
        }
        // 补全最后一位
        ans += pre;
        return ans;
    }

    private int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
