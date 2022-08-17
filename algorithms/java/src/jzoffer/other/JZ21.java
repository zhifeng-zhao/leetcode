package jzoffer.other;

/**
 * 调整数组顺序使奇数位于偶数前面(一)
 *  双指针
 * @author zzf
 * @date 2022/8/17 3:13 下午
 */
public class JZ21 {
    public int[] reOrderArray(int[] array) {
        int[] ans = new int[array.length];
        int left = 0;
        int right = array.length - 1;
        int ansLeft = 0;
        int ansRight = array.length - 1;
        while (left < array.length && right >= 0) {
            if (array[left] % 2 == 1) {
                ans[ansLeft] = array[left];
                ansLeft++;
            }
            left++;
            if (array[right] % 2 == 0) {
                ans[ansRight] = array[right];
                ansRight--;
            }
            right--;
        }
        return ans;
    }
}
