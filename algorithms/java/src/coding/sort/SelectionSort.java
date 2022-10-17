package coding.sort;

/**
 * 选择排序
 * @author zzf
 * @date 2022/10/16 8:03 下午
 */
public class SelectionSort implements IMutableSorter {
    @Override
    public void sort(int[] A) {
        for (int i = A.length - 1; i >= 0; i--) {
            // A[0] - A[i] 的最大值
            int j = MaxIndex(A, 0, i + 1);
            Utils.swap(A, i, j);
        }
    }



    private int MaxIndex(int[] A, int i, int j) {
        int max = Integer.MIN_VALUE;
        int maxIndex = j - 1;
        // 排序稳定性:同值顺序在排序过程不会调换
        for (int k = j - 1; k >= i; k--) {
            if (A[k] > max) {
                max = A[k];
                maxIndex = k;
            }
        }
        return maxIndex;
    }
}
