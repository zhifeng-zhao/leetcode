package jzoffer.linkedlist;

/**
 * 链表中倒数最后k个结点
 *
 * @author zzf
 * @date 2022/8/6 10:37 下午
 */
public class JZ22 {
    public static ListNode FindKthToTail(ListNode pHead, int k) {
        int len = 0;
        ListNode move = pHead;
        while (move != null) {
            len++;
            move = move.next;
        }
        if (len < k) {
            return null;
        }
        ListNode ans = pHead;
        for (int i = 0; i < len - k; i++) {
            ans = ans.next;
        }
        return ans;
    }

    /**
     * 设链表的长度为 N。设置两个指针 P1 和 P2，先让 P1 移动 K 个节点，则还有 N - K 个节点可以移动。
     * 此时让 P1 和 P2 同时移动，可以知道当 P1 移动到链表结尾时，P2 移动到第 N - K 个节点处，该位置就是倒数第 K 个节点。
     *
     * @param pHead
     * @param k
     * @return
     */
    public static ListNode FindKthToTail2(ListNode pHead, int k) {
        if (pHead == null) {
            return null;
        }
        ListNode P1 = pHead;
        while (P1 != null && k-- > 0) {
            P1 = P1.next;
        }
        if (k > 0) {
            return null;
        }
        ListNode P2 = pHead;
        while (P1 != null) {
            P1 = P1.next;
            P2 = P2.next;
        }
        return P2;
    }
}
