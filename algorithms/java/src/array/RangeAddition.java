package array;

import java.util.Arrays;

/**
 * 370. 区间加法
 * 假设你有一个长度为 n 的数组，初始情况下所有的数字均为 0，你将会被给出 k 个更新的操作。
 * 其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，
 * 你需要将子数组 A[startIndex ... endIndex]（包括 startIndex 和 endIndex）增加 inc。
 * 请你返回 k 次操作后的数组。
 * 思路：差分数组
 * diff数据为原始数组两数之间的差，通过对diff[i]+num和对diff[j+1]-num实现对i到j之间的增减，
 * 再通过对diff数组相加还原出所求数组。
 *
 * @author zzf
 * @date 2022/3/12 10:59 下午
 */
public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length];
        for (int[] update : updates) {
            diff[update[0]] += update[2];
            if (update[1] + 1 < diff.length) {
                diff[update[1] + 1] -= update[2];
            }
        }
        int[] res = new int[length];
        res[0] = diff[0];
        for (int i = 1; i < length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] updates = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
        System.out.println(Arrays.toString(new RangeAddition().getModifiedArray(5, updates)));
    }
}
