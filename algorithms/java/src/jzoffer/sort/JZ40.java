package jzoffer.sort;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 最小的K个数
 * @author zzf
 * @date 2022/8/14 7:18 下午
 */
public class JZ40 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (input.length < k || k <= 0) {
            return ans;
        }
        // 大堆顶
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int i : input) {
            queue.add(i);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        ans.addAll(queue);
        return ans;
    }
}
