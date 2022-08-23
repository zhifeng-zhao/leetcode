package hot100;

/**
 * 26. 删除有序数组中的重复项
 * 快慢指针
 *
 * @author zzf
 * @date 2022/8/23 5:20 下午
 */
public class hot26 {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 1;
        int k = 1;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                k++;
                nums[++left] = nums[right];
            }
            right++;
        }
        return k;
    }
}
