package hot100;

/**
 * 回文数
 *
 * @author zzf
 * @date 2022/8/21 4:44 下午
 */
public class hot09 {
    public boolean isPalindrome(int x) {
        // 负数不是回文数
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        }
        int revertNum = 0;
        while (x > revertNum) {
            revertNum = revertNum * 10 + x % 10;
            x /= 10;
        }
        // 偶数或奇数
        return x == revertNum || x == revertNum / 10;
    }
}
