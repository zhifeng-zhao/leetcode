package jzoffer.linkedlist;

import java.util.Stack;

/**
 * 两个链表的第一个公共结点
 * @author zzf
 * @date 2022/8/6 6:36 下午
 */
public class JZ52 {
    /**
     * 栈
     * 倒序遍历链表
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        while (pHead1 != null) {
            stack1.add(pHead1);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null) {
            stack2.add(pHead2);
            pHead2 = pHead2.next;
        }

        ListNode ans = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.peek().val == stack2.peek().val) {
                ans = stack1.pop();
                stack2.pop();
            } else {
                break;
            }
        }
        return ans;
    }

    /**
     * 正序遍历链表
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        int len1 = 0;
        int len2 = 0;
        ListNode listNode1 = pHead1;
        ListNode listNode2 = pHead2;
        while (listNode1 != null) {
            len1++;
            listNode1 = listNode1.next;
        }
        while (listNode2 != null) {
            len2++;
            listNode2 = listNode2.next;
        }
        // 使得两个链表的长度相同
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                pHead1 = pHead1.next;
            }
        } else if (len2 > len1) {
            for (int i = 0; i < len2 - len1; i++) {
                pHead2 = pHead2.next;
            }
        }
        ListNode ans = null;
        while (pHead1 != null && pHead2 != null) {
            if (pHead1.val == pHead2.val) {
                ans = pHead1;
                break;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return ans;
    }

    /**
     * 设A的长度为a + cB的长度为b + c，其中c为尾部公共部分长度，可知a + c + b = b + c + a。
     * 当访问链表A的指针访问到链表尾部时，令它从链表B的头部重新开始访问链表B；
     * 同样地，当访问链表B的指针访问到链表尾部时，令它从链表 A 的头部重新开始访问链表A。
     * 这样就能控制访问A和B两个链表的指针能同时访问到交点。
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode3(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;
    }
}
