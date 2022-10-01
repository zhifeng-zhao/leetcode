package hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 *
 * @author zzf
 * @date 2022/10/1 5:11 下午
 */
public class L202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = nextNum(n);
        }
        return n == 1;
    }

    private int nextNum(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
}
