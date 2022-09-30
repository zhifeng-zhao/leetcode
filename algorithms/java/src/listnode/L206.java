package listnode;

/**
 * 206. 反转链表
 * @author zzf
 * @date 2022/9/30 4:00 下午
 */
public class L206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
