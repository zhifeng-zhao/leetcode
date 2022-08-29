package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.两数之和
 *
 * @author zzf
 * @date 2022/8/18 12:38 下午
 */
public class hot01 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
