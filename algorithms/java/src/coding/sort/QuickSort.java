package coding.sort;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 快速排序
 * @author zzf
 * @date 2022/10/17 1:53 下午
 */
public class QuickSort implements IImutableSorter{
    @Override
    public List<Integer> sort(List<Integer> A) {
        return this.quickSort(A);
    }

    private List<Integer> quickSort(List<Integer> A) {
        if (A.size() <= 1) {
            return A;
        }
        int x = A.get(0);
        List<Integer> left = A.stream().filter(a -> a < x).collect(Collectors.toList());
        List<Integer> mid = A.stream().filter(a -> a == x).collect(Collectors.toList());
        List<Integer> right = A.stream().filter(a -> a > x).collect(Collectors.toList());
        quickSort(left);
        quickSort(right);
        left.addAll(mid);
        left.addAll(right);
        return left;
    }
}
