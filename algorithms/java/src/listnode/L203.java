package listnode;

/**
 * 203. 移除链表元素
 *
 * @author zzf
 * @date 2022/9/29 4:57 下午
 */
public class L203 {
    /**
     * 添加头节点
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * 不添加虚拟头节点
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode move = head;
        while (move != null) {
            while (move.next != null && move.next.val == val) {
                move.next = move.next.next;
            }
            move = move.next;
        }
        return head;
    }
}
