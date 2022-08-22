package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 *
 * @author zzf
 * @date 2022/8/21 11:22 下午
 */
public class hot15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 第一轮遍历
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int third = nums.length - 1;
            int target = -nums[i];
            // 第二轮遍历
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // 左指针永远在右指针左边
                while (j < third && nums[j] + nums[third] > target) {
                    third--;
                }
                if (j == third) {
                    break;
                }
                if (nums[j] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
