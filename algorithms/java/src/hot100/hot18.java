package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 18. 四数之和
 *
 * @author zzf
 * @date 2022/9/6 1:34 下午
 */
public class hot18 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        backtrack(nums, 0, target);
        return res;
    }

    public void backtrack(int[] nums, int start, int target) {
        if (list.size() > 4) {
            return;
        }
        if (res.contains(list)) {
            return;
        }
        if (sum == target && list.size() == 4) {
            res.add(new LinkedList<>(list));
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            sum += nums[i];
            backtrack(nums, i + 1, target);
            sum -= nums[i];
            list.removeLast();
        }
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ans;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) {
                    continue;
                }
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new hot18().fourSum2(new int[]{0, 0, 0, 1000000000, 1000000000, 1000000000, 1000000000}, 1000000000);
    }
}
