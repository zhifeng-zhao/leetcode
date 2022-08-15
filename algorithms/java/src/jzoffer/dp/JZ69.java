package jzoffer.dp;

/**
 * 跳台阶
 *
 * @author zzf
 * @date 2022/8/16 12:00 上午
 */
public class JZ69 {
    /**
     * 递归
     *
     * @param target
     * @return
     */
    public int jumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }

    /**
     * 动态规划
     * @param target
     * @return
     */
    public int jumpFloor2(int target) {
        if (target < 1) {
            return 1;
        }
        int res;
        int a = 0;
        int b = 1;
        for (int i = 1; i < target; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return b;
    }


}
