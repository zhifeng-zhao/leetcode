package twopoint;

/**
 * 141. 环形链表
 *      给你一个链表的头节点 head ，判断链表中是否有环。
 * 思路：快慢指针
 * @author zzf
 * @date 2022/3/18 4:27 下午
 */
public class LinkedListCycle {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
