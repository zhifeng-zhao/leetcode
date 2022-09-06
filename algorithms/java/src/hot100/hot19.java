package hot100;

/**
 * 19. 删除链表的倒数第 N 个结点
 * @author zzf
 * @date 2022/9/6 2:33 下午
 */
public class hot19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = ans;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return ans.next;
    }
}
