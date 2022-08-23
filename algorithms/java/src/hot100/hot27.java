package hot100;

/**
 * 27. 移除元素
 * 快慢指针
 * @author zzf
 * @date 2022/8/23 6:08 下午
 */
public class hot27 {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != val) {
                nums[left++] = nums[right];
            }
            right++;
        }
        return left;
    }
}