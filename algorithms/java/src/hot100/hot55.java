package hot100;

/**
 * @author zzf
 * @date 2022/9/10 12:39 下午
 */
public class hot55 {
    public boolean canJump(int[] nums) {
        int jumpNum = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            jumpNum = Math.max(jumpNum, i + nums[i]);
            if (i == end) {
                end = jumpNum;
                if (end >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
