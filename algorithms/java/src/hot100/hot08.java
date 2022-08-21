package hot100;

/**
 * 8. 字符串转换整数 (atoi)
 *
 * @author zzf
 * @date 2022/8/21 3:50 下午
 */
public class hot08 {
    public int myAtoi(String s) {
        int sign = 1, ans = 0, index = 0;
        char[] chars = s.toCharArray();
        // 溢出开头空格
        while (index < chars.length && chars[index] == ' ') {
            index++;
        }
        // 确定正负数
        if (index < chars.length && chars[index] == '+' || chars[index] == '-') {
            sign = chars[index++] == '+' ? 1 : -1;
        }
        while (index < chars.length && chars[index] <= '9' && chars[index] >= '0') {
            int dight = chars[index++] - '0';
            // 校验是否溢出
            if (ans > (Integer.MIN_VALUE - dight) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + dight;
        }
        return ans * sign;
    }
}
