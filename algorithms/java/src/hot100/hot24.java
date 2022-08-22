package hot100;

/**
 * 24. 两两交换链表中的节点
 *  递归
 * @author zzf
 * @date 2022/8/22 10:59 下午
 */
public class hot24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 第二个节点做为新的头节点
        ListNode newHead = head.next;
        // 传入第三个节点去交换，将当前头节点的next指向交换完的节点
        head.next = swapPairs(newHead.next);
        // 原头节点成为新的第二个节点，并指向新交换完的节点
        newHead.next = head;
        return newHead;
    }
}
