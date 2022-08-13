package jzoffer.search;

/**
 * 二维数组中的查找
 * 二分查找
 * @author zzf
 * @date 2022/8/13 7:10 下午
 */
public class JZ4 {
    public boolean Find(int target, int[][] array) {
        for (int[] ints : array) {
            if (Find(target, ints)) {
                return true;
            }
        }
        return false;
    }

    public boolean Find(int target, int[] array) {
        int l = 0;
        int h = array.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (array[m] == target) {
                return true;
            }
            if (array[m] > target) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}
