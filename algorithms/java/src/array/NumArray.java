package array;

/**
 * 303. 区域和检索 - 数组不可变
 * 给定一个整数数组nums，处理以下类型的多个查询:
 *
 * 计算索引left和right（包含 left 和 right）之间的 nums 元素的 和 ，其中left <= right
 *
 * 思路：提前构建所需区域元素合，减少for循环调用
 * @author zzf
 * @date 2022/3/10 8:28 下午
 */
class NumArray {

    /**
     * 前缀
     */
    private int[] preSum;

    public NumArray(int[] nums) {
        preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}
