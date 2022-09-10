package hot100;

import java.util.*;

/**
 * 56. 合并区间
 *
 * @author zzf
 * @date 2022/9/10 1:36 下午
 */
public class hot56 {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int[] last = res.getLast();
            if (cur[0] <= last[1]) {
                last[1] = Math.max(cur[1], last[1]);
            } else {
                res.add(cur);
            }
        }
        return res.toArray(new int[0][0]);
    }
}
