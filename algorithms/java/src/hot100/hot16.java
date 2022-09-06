package hot100;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 *
 * @author zzf
 * @date 2022/8/22 12:56 下午
 */
public class hot16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int len = nums.length - 1;
            while (j < len) {
                int sum = nums[i] + nums[j] + nums[len];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum > target) {
                    int len0 = len - 1;
                    while (len0 > j && nums[len] == nums[len0]) {
                        len0--;
                    }
                    len = len0;
                } else {
                    int j0 = j + 1;
                    while (j0 < len && nums[j] == nums[j0]) {
                        j0++;
                    }
                    j = j0;
                }
            }
        }
        return res;
    }
}
