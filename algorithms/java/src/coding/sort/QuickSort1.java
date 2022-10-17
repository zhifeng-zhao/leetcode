package coding.sort;

/**
 * 快速排序
 * @author zzf
 * @date 2022/10/17 2:07 下午
 */
public class QuickSort1 implements IMutableSorter {
    @Override
    public void sort(int[] A) {
        quickSort(A, 0, A.length);
    }

    private void quickSort(int[] A, int l, int r) {
        if ((r - l) <= 1) {
            return;
        }
        // i为x的位置，x = A[i]
        int i = partition(A, l, r);

        // 小于x在左边，大于x在右边
        quickSort(A, l, i);
        quickSort(A, i + 1, r);
    }

    private int partition(int[] A, int l, int r) {
        int x = A[l];
        int i = l + 1;
        int j = r;
        while (i != j) {
            if (A[i] < x) {
                i++;
            } else {
                Utils.swap(A, i, --j);
            }
        }
        Utils.swap(A, i - 1, l);
        return i - 1;
    }
}
