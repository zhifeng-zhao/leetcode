package jzoffer.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表中环的入口结点
 * @author zzf
 * @date 2022/8/6 8:43 下午
 */
public class JZ23 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        List<ListNode> listNodes = new ArrayList<>();
        while (pHead != null) {
            listNodes.add(pHead);
            pHead = pHead.next;
            if (listNodes.contains(pHead)) {
                return pHead;
            }
        }
        return null;
    }

    public ListNode EntryNodeOfLoop2(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead, fast = pHead;
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (slow != fast);
        fast = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
