package listnode;

/**
 * 160. 相交链表
 *
 * @author zzf
 * @date 2022/9/30 5:26 下午
 */
public class L160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0;
        int lenB = 0;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        // 重置链表
        curA = headA;
        curB = headB;
        // 交换，保持curA最长
        if (lenB > lenA) {
            int temp = lenA;
            lenA = lenB;
            lenB = temp;
            ListNode tempNode = curA;
            curA = curB;
            curB = tempNode;
        }
        int gap = lenA - lenB;
        while (gap-- > 0) {
            curA = curA.next;
        }
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
