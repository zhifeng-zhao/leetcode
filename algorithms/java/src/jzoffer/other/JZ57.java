package jzoffer.other;

import java.util.ArrayList;

/**
 * 和为S的两个数字
 *
 * @author zzf
 * @date 2022/8/17 6:48 下午
 */
public class JZ57 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int left = 0, right = array.length - 1; left < right; ) {
            int temp = array[left] + array[right];
            if (temp == sum) {
                list.add(array[left]);
                list.add(array[right]);
                return list;
            }
            // 和太大缩小右边
            if (temp > sum) {
                right--;
            } else {
                left++;
            }
        }
        return list;
    }
}
