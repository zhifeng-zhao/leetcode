package jzoffer.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 滑动窗口的最大值
 *
 * @author zzf
 * @date 2022/8/9 1:09 上午
 */
public class JZ59 {
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (size > num.length || size < 1) {
            return ret;
        }
        /* 大顶堆 */
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < size; i++) {
            heap.add(num[i]);
        }
        ret.add(heap.peek());
        /* 维护一个大小为 size 的大顶堆 */
        for (int i = 0, j = i + size; j < num.length; i++, j++) {
            heap.remove(num[i]);
            heap.add(num[j]);
            ret.add(heap.peek());
        }
        return ret;
    }

    public static ArrayList<Integer> maxInWindows2(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        // 窗口大于数组长度的时候，返回空
        if (size > num.length || size < 1) {
            return res;
        }
        // 双向队列
        ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
        for (int i = 0; i < size; i++) {
            while (!dq.isEmpty() && num[dq.peekLast()] < num[i]) {
                dq.pollLast();
            }
            dq.add(i);
        }
        for (int i = size; i < num.length; i++) {
            res.add(num[dq.peekFirst()]);
            while (!dq.isEmpty() && dq.peekFirst() < i - size + 1) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && num[dq.peekLast()] < num[i]) {
                dq.pollLast();
            }
            dq.add(i);
        }
        res.add(num[dq.peekFirst()]);
        return res;
    }

    public static void main(String[] args) {
        int[] num = {10, 2, 3, 1, 4};
        maxInWindows2(num, 3);
    }
}
