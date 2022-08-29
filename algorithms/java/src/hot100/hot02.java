package hot100;


/**
 * 2.两数相加
 *
 * @author zzf
 * @date 2022/8/18 12:47 下午
 */
public class hot02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode move = res;
        int i = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + i;
            move.next = new ListNode(sum % 10);
            move = move.next;
            i = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (i > 0) {
            move.next = new ListNode(i);
        }
        return res.next;
    }
}
