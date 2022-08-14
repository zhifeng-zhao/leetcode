package jzoffer.bit;

/**
 * 不用加减乘除做加法
 *
 * @author zzf
 * @date 2022/8/14 10:38 下午
 */
public class JZ65 {
    public int Add(int num1, int num2) {
        int sum1, sum2;
        do {
            // 将每轮的无进位和与进位值做异或求和
            sum1 = num1 ^ num2;
            // 进位值是用与运算产生的
            sum2 = (num1 & num2) << 1;
            num1 = sum1;
            num2 = sum2;
        } while (num2 != 0);
        return num1;
    }
}
