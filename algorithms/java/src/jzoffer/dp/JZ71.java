package jzoffer.dp;

/**
 * 跳台阶扩展问题
 *
 * @author zzf
 * @date 2022/8/16 2:52 上午
 */
public class JZ71 {
    public int jumpFloorII(int target) {
        if (target == 1) {
            return 1;
        }
        int res = 0;
        int a = 1;
        for (int i = 2; i <= target; i++) {
            // 后一个数是前一个数的两倍
            res = 2 * a;
            a = res;
        }
        return res;
    }
}
