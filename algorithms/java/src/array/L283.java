package array;

/**
 * 283. 移动零
 *
 * @author zzf
 * @date 2022/9/28 5:02 下午
 */
public class L283 {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }
}
