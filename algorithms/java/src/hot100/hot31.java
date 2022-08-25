package hot100;

/**
 * 31. 下一个排列
 *
 * @author zzf
 * @date 2022/8/25 9:55 下午
 */
public class hot31 {
    public void nextPermutation(int[] nums) {
        // 寻找第一个升序
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // i小于0说明序列为降序序列，直接进行反转
        if (i >= 0) {
            // 从后查找第一个大于num[i]的值
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        // 使序列升序
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
