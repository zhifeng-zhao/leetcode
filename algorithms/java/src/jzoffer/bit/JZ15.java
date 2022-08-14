package jzoffer.bit;

/**
 * 二进制中1的个数
 * @author zzf
 * @date 2022/8/15 1:52 上午
 */
public class JZ15 {
    public int NumberOf1(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            // 按位比较，数字与1与
            if ((n & (1 << i)) != 0) {
                ans++;
            }
        }
        return ans;
    }
}
