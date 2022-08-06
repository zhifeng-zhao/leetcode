package jzoffer.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 从尾到头打印链表
 *
 * @author zzf
 * @date 2022/8/6 10:45 上午
 */
public class JZ6 {
    /**
     * 栈
     *
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    /**
     * 头插法
     *
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList();
        while (listNode != null) {
            int i = 0;
            list.add(i, listNode.val);
            listNode = listNode.next;
        }
        return list;
    }

    /**
     * 递归
     *
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode != null) {
            add(list, listNode);
        }
        return list;
    }

    public static void add(List<Integer> list, ListNode listNode) {
        if (listNode.next != null) {
            add(list, listNode.next);
        }
        list.add(listNode.val);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode removeNode = head;
        for (int i = 1; i < 10; i++) {
            ListNode j = new ListNode(i);
            removeNode.next = j;
            removeNode = j;
        }
        System.out.println(printListFromTailToHead3(head));
    }
}
