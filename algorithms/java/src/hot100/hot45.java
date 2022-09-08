package hot100;

/**
 * 45. 跳跃游戏 II
 * @author zzf
 * @date 2022/9/9 2:57 上午
 */
public class hot45 {
    public int jump(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int jump = 0;
        int max = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(nums[i] + i, max);
            if (i == end) {
                jump++;
                end = max;
            }
        }
        return jump;
    }
}
