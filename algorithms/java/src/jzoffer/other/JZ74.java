package jzoffer.other;

import java.util.ArrayList;

/**
 * 和为S的连续正数序列
 *  滑动窗口
 * @author zzf
 * @date 2022/8/17 5:53 下午
 */
public class JZ74 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[] sums = new int[sum];
        for (int i = 0; i < sum; i++) {
            sums[i] = i + 1;
        }
        int left = 0;
        int right = 1;
        int temp = 1;
        while (left < right && right < sum) {
            if (temp == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = left; j < right; j++) {
                    list.add(sums[j]);
                }
                ans.add(list);
            }
            // 判断扩大右区间还是减少左区间
            if (temp < sum) {
                temp += sums[right];
                right++;
            } else {
                temp -= sums[left];
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new JZ74().FindContinuousSequence(9);
    }
}
