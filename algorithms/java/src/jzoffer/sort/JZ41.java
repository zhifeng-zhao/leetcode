package jzoffer.sort;

import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * @author zzf
 * @date 2022/8/14 9:39 下午
 */
public class JZ41 {
    // 大堆顶
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    // 小堆顶
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    private int N = 0;

    public void Insert(Integer num) {
        // right中数字永远大于left
        if (N % 2 == 0) {
            left.add(num);
            right.add(left.poll());
        } else {
            right.add(num);
            left.add(right.poll());
        }
        N++;
    }

    public Double GetMedian() {
        if (N % 2 == 0) {
            return (right.peek() + left.peek()) / 2.0;
        } else {
            return (double) right.peek();
        }
    }
}
