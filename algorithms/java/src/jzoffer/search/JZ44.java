package jzoffer.search;

/**
 * 数字序列中某一位的数字
 * 添0补齐法
 *
 * @author zzf
 * @date 2022/8/14 12:21 下午
 */
public class JZ44 {
    public int findNthDigit(int n) {
        // 记录n是几位数
        int i = 1;
        while (i * Math.pow(10, i) < n) {
            // 前面添0增加的位
            n += Math.pow(10, i);
            i++;
        }
        // n所在的数字
        String num = "" + (n / i);
        // n % i n所在数字第几位
        return Integer.parseInt(String.valueOf(num.charAt(n % i)));
    }

    public static void main(String[] args) {
        System.out.println(new JZ44().findNthDigit(13));
    }
}
