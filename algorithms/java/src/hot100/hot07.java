package hot100;

/**
 * 7. 整数反转
 *
 * @author zzf
 * @date 2022/8/21 1:21 上午
 */
public class hot07 {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
}
