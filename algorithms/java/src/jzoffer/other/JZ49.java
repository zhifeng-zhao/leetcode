package jzoffer.other;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 丑数
 *
 * @author zzf
 * @date 2022/8/17 5:31 下午
 */
public class JZ49 {
    public int GetUglyNumber_Solution(int index) {
        if (index == 0) {
            return 0;
        }
        // 要乘的因数
        int[] factors = {2, 3, 5};
        HashMap<Long, Integer> map = new HashMap<>();
        // 小堆顶
        PriorityQueue<Long> queue = new PriorityQueue<>();
        map.put(1L, 1);
        queue.offer(1L);
        long res = 0;
        for (int i = 0; i < index; i++) {
            res = queue.poll();
            for (int factor : factors) {
                long next = res * factor;
                if (map.containsKey(next)) {
                    continue;
                }
                map.put(next, 1);
                queue.offer(next);
            }
        }
        return (int) res;
    }
}
