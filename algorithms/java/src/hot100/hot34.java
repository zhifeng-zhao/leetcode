package hot100;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author zzf
 * @date 2022/9/6 9:17 下午
 */
public class hot34 {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{left(nums, target), right(nums, target)};
    }

    public int left(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                // 收缩右边界
                right = mid - 1;
            }
        }
        if (left > nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    public int right(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    public int[] searchRange2(int[] nums, int target) {
        int index = binarySearch(nums, target);
        if (index == -1) {
            return new int[]{-1, -1};
        }
        int left = index;
        int right = index;
        while (left - 1 >= 0 && nums[left - 1] == nums[index]) {
            left--;
        }
        while (right + 1 < nums.length && nums[right + 1] == nums[index]) {
            right++;
        }
        return new int[]{left, right};
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
