package jzoffer.bit;

/**
 * 数组中只出现一次的两个数字
 *
 * @author zzf
 * @date 2022/8/15 2:41 上午
 */
public class JZ56 {
    public int[] FindNumsAppearOnce(int[] array) {
        if (array.length == 0) {
            return null;
        }
        int num = 0;
        for (int i : array) {
            num ^= i;
        }
        int last = find(num);
        int[] res = new int[2];
        for (int i : array) {
            if (judge(i, last) == 0) {
                res[1] ^= i;
            } else {
                res[0] ^= i;
            }
        }
        return res;
    }


    private int judge(int x, int index) {
        x >>= index - 1;
        return x & 1;
    }

    // 找到分割位
    private int find(int num) {
        int sum = 1;
        int res = 1;
        while ((res & num) == 0) {
            sum++;
            res <<= 1;
        }
        return sum;
    }
}
