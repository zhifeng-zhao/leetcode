package array;

/**
 * 209. 长度最小的子数组
 * <p>
 * 窗口就是 满足其和 ≥ s 的长度最小的 连续 子数组。
 * <p>
 * 窗口的起始位置如何移动：如果当前窗口的值大于s了，窗口就要向前移动了（也就是该缩小了）。
 * <p>
 * 窗口的结束位置如何移动：窗口的结束位置就是遍历数组的指针，也就是for循环里的索引。
 * @author zzf
 * @date 2022/9/28 5:43 下午
 */
public class L209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
