package hot100;

/**
 * 11. 盛最多水的容器
 * 双指针
 * @author zzf
 * @date 2022/8/21 10:09 下午
 */
public class hot11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, area);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}