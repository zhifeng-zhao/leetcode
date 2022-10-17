package coding.sort;

import java.util.Arrays;

/**
 * @author zzf
 * @date 2022/10/16 11:23 下午
 */
public class MergeSort implements IMutableSorter {
    @Override
    public void sort(int[] A) {
        mergeSort(A, 0, A.length);
    }

    private void merge(int[] A, int l, int mid, int r) {
        int[] B = Arrays.copyOfRange(A, l, mid + 1);
        int[] C = Arrays.copyOfRange(A, mid, r + 1);
        B[B.length - 1] = C[C.length - 1] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (l < r) {
            if (B[i] < C[j]) {
                A[l] = B[i];
                i++;
            } else {
                A[l] = C[j];
                j++;
            }
            l++;
        }
    }

    private void mergeSort(int[] A, int l, int r) {
        if (r - l <= 1) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(A, l, mid);
        mergeSort(A, mid, r);
        merge(A, l, mid, r);
    }
}
