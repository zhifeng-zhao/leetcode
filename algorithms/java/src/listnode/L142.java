package listnode;

/**
 * 142. 环形链表 II
 *
 * @author zzf
 * @date 2022/9/30 6:09 下午
 */
public class L142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 有环
            if (slow == fast) {
                ListNode index1 = fast;
                ListNode index2 = head;
                // 相遇点为环入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
