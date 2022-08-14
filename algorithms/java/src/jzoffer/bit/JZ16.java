package jzoffer.bit;

/**
 * 数值的整数次方
 * @author zzf
 * @date 2022/8/15 2:35 上午
 */
public class JZ16 {
    public double Power(double base, int exponent) {
        // 处理负次方
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        double ans = 1.0;
        for (int i = 0; i < exponent; i++) {
            ans *= base;
        }
        return ans;
    }
}
