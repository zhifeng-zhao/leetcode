package coding.sort;

/**
 * 插入排序
 * @author zzf
 * @date 2022/10/16 6:50 下午
 */
public class InsertionSort implements IMutableSorter {
    @Override
    public void sort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int c = A[i];
            int j = i;
            for (; j > 0 && c < A[j - 1]; j--) {
                A[j] = A[j - 1];
            }
            A[j] = c;
        }
    }
}
