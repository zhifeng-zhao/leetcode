package hot100;

import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 * 优先级队列（二叉堆）
 * @author zzf
 * @date 2022/8/22 10:16 下午
 */
public class hot23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((o1, o2) -> (o1.val - o2.val));
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        ListNode ans = new ListNode();
        ListNode remove = ans;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            remove.next = node;
            if (node.next != null) {
                queue.add(node.next);
            }
            remove = remove.next;
        }
        return ans.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((o1, o2) -> (o1.val - o2.val));
        for (ListNode list : lists) {
            while (list != null) {
                queue.add(list);
                list = list.next;
            }
        }
        ListNode ans = new ListNode();
        ListNode remove = ans;
        while (!queue.isEmpty()) {
            remove.next = queue.poll();
            remove = remove.next;
        }
        remove.next = null;
        return ans.next;
    }
}
