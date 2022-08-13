package jzoffer.search;

/**
 * 数字在升序数组中出现的次数
 *
 * @author zzf
 * @date 2022/8/12 9:47 下午
 */
public class JZ53 {
    public int GetNumberOfK(int[] array, int k) {
        int first = binarySearch(array, k);
        int last = binarySearch(array, k + 1);
        // [],0
        return (first == array.length || array[first] != k) ? 0 : last - first;
    }

    /**
     * 二分查找获取k的第一个位置
     *
     * @param nums
     * @param k
     * @return
     */
    private int binarySearch(int[] nums, int k) {
        int low = 0;
        int height = nums.length;
        while (low < height) {
            int m = low + (height - low) / 2;
            if (nums[m] >= k) {
                height = m;
            } else {
                low = m + 1;
            }
        }
        return low;
    }
}
