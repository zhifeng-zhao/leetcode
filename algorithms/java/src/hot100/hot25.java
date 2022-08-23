package hot100;

/**
 * 25. K 个一组翻转链表
 *
 * @author zzf
 * @date 2022/8/22 11:38 下午
 */
public class hot25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode a = head;
        ListNode b = head;
        // 确定反转区间
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        // 反转链表
        ListNode newNode = reverse(a, b);
        // 链接后序反转
        a.next = reverseKGroup(b, k);
        return newNode;
    }

    private ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null;
        ListNode cur = a;
        ListNode next = a;
        while (cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 返回反转后头节点
        return pre;
    }
}
