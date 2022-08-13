package jzoffer.search;

/**
 * 旋转数组的最小数字
 *
 * @author zzf
 * @date 2022/8/13 9:57 下午
 */
public class JZ11 {
    public int minNumberInRotateArray(int[] array) {
        int l = 0;
        int h = array.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            // 对于数组 {1,1,1,0,1}，l、m 和 h 指向的数都为 1，此时无法知道最小数字 0 在哪个区间
            if (array[l] == array[m] && array[m] == array[h]) {
                return minNumber(array, l, h);
            }
            // 旋转数组一半为非递减区间，一半为旋转区间
            if (array[m] <= array[h]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return array[l];
    }

    private int minNumber(int[] array, int l, int h) {
        for (int i = l; i < h; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }
        return array[l];
    }

    public static void main(String[] args) {
        int[] i = {3,4,5,1,2};
//        int[] i = {2,2,2,1,2};
        System.out.println(new JZ11().minNumberInRotateArray(i));
    }
}
