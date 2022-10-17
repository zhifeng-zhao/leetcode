package coding.sort;

/**
 * 冒泡排序
 *
 * @author zzf
 * @date 2022/10/16 8:16 下午
 */
public class BubbleSort implements IMutableSorter {
    @Override
    public void sort(int[] A) {
        for (int i = A.length - 1; i >= 0; i--) {
            // 0到i的最大值放到A[i]
            bubble(A, 0, i);
        }
    }

    private void bubble(int[] A, int i, int j) {
        for (int k = 0; k < j - 1; k++) {
            if (A[k] > A[k + 1]) {
                Utils.swap(A, k, k + 1);
            }
        }
    }
}
