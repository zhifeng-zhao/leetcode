package array;

import java.util.HashMap;

/**
 * 560. 和为 K 的子数组
 *      给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数
 * 思路：前缀和➕哈希map优化
 *      map记录前缀和和出现的次数，key为前缀和，value为次数
 *      sum0_j == sum0_i - k  当sum0_j等于前缀和时，res+1
 *
 * @author zzf
 * @date 2022/3/11 2:13 下午
 */
public class Solution {
    HashMap<Integer, Integer> preSum = new HashMap<>();
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum0I = 0;
        preSum.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum0I += nums[i];
            int sum0J = sum0I - k;
            if (preSum.containsKey(sum0J)) {
                res += preSum.get(sum0J);
            }
            preSum.put(sum0I, preSum.getOrDefault(sum0I, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num1 = {1,1,1};
        int[] num2 = {1,2,3};
        System.out.println(new Solution().subarraySum(num2, 3));
    }
}
