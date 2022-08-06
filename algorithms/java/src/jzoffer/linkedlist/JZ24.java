package jzoffer.linkedlist;

import java.util.Stack;

/**
 * 反转链表
 * 通过两个距离为1的移动节点，不断的反转原链表相邻的节点之间的指向
 * @author zzf
 * @date 2022/8/6 1:53 下午
 */
public class JZ24 {
    public static ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode frontNode = head;
        ListNode toNode = head.next;

        while (toNode != null) {
            // 保存移动路径
            ListNode tempNode = toNode.next;
            // 链表反置
            toNode.next = frontNode;
            // 节点右移
            frontNode = toNode;
            toNode = tempNode;
        }
        head.next = null;
        return frontNode;
    }

    /**
     * 栈
     *
     * @param head
     * @return
     */
    public static ListNode ReverseList2(ListNode head) {
        if (head == null) {
            return null;
        }

        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode listNode = stack.pop();
        ListNode ans = listNode;
        while (!stack.isEmpty()) {
            ListNode tempNode = stack.pop();
            tempNode.next = null;
            listNode.next = tempNode;
            listNode = tempNode;
        }
        return ans;
    }

    public static void main(String[] args) {
    }
}
