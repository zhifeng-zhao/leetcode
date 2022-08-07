package jzoffer.linkedlist;

/**
 * 删除链表的节点
 *
 * @author zzf
 * @date 2022/8/7 8:44 下午
 */
public class JZ18 {
    public static ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            head = head.next;
            return head;
        }
        ListNode removeNode = head;
        while (removeNode != null) {
            if (removeNode.next != null && removeNode.next.val == val) {
                removeNode.next = removeNode.next.next == null ? null : removeNode.next.next;
                break;
            }
            removeNode = removeNode.next;
        }
        return head;
    }

    public static ListNode deleteNode2(ListNode head, int val) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                // 断开连接
                pre.next = cur.next;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return res.next;
    }
}
