package hot100;

/**
 * 21. 合并两个有序链表
 *  双指针
 * @author zzf
 * @date 2022/8/22 3:38 下午
 */
public class hot21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode left = list1;
        ListNode right = list2;
        ListNode ans = new ListNode();
        ListNode move = ans;
        while (left != null && right != null) {
            if (left.val < right.val) {
                move.next = new ListNode(left.val);
                left = left.next;
            } else {
                move.next = new ListNode(right.val);
                right = right.next;
            }
            move = move.next;
        }
        if (left != null) {
            move.next = left;
        }
        if (right != null) {
            move.next = right;
        }
        return ans.next;
    }
}
