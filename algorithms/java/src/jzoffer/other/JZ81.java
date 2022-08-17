package jzoffer.other;

/**
 * 调整数组顺序使奇数位于偶数前面(二)
 * 双指针碰撞
 *
 * @author zzf
 * @date 2022/8/17 9:41 下午
 */
public class JZ81 {
    public int[] reOrderArrayTwo(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            // 左奇右奇
            if (array[left] % 2 == 1 && array[right] % 2 == 1) {
                left++;
            }
            // 左奇右偶数
            else if (array[left] % 2 == 1 && array[right] % 2 == 0) {
                left++;
                right--;
            }
            // 左偶右奇 交换
            else if (array[left] % 2 == 0 && array[right] % 2 == 1) {
                int temp = array[right];
                array[right] = array[left];
                array[left] = temp;
            }
            // 左偶右偶
            else if (array[left] % 2 == 0 && array[right] % 2 == 0) {
                right--;
            }
        }
        return array;
    }
}
