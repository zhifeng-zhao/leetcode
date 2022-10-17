package coding.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 捅排序
 *
 * @author zzf
 * @date 2022/10/17 4:45 下午
 */
public class BucketSort {
    public List<Integer> sort(List<Integer> A) {
        int k = 100;
        ArrayList<LinkedList<Integer>> buckets = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            buckets.add(new LinkedList<>());
        }
        for (Integer integer : A) {
            buckets.get(integer % 100).add(integer);
        }
        for (LinkedList<Integer> bucket : buckets) {
            res.addAll(bucket);
        }
        return res;
    }
}
