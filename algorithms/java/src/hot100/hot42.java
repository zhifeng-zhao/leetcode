package hot100;

/**
 * 42. 接雨水
 *
 * @author zzf
 * @date 2022/8/27 6:57 下午
 */
public class hot42 {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int lMax = 0;
        int rMax = 0;
        int res = 0;
        while (left < right) {
            lMax = Math.max(lMax, height[left]);
            rMax = Math.max(rMax, height[right]);
            if (lMax < rMax) {
                res += lMax - height[left];
                left++;
            } else {
                res += rMax - height[right];
                right--;
            }
        }
        return res;
    }
}
