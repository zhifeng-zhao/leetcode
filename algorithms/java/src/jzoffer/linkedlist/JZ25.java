package jzoffer.linkedlist;

/**
 * 合并两个排序的链表
 * 类似归并排序中子序列合并过程，判断哪个节点需要优先添加到合成链表尾部
 * @author zzf
 * @date 2022/8/6 4:09 下午
 */
public class JZ25 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode headNode; // 链表头节点
        if (list1.val > list2.val) {
            headNode = list2;
            list2 = list2.next;
        } else {
            headNode = list1;
            list1 = list1.next;
        }
        ListNode removeNode = headNode; // 链表尾节点，长度为1头尾节点一致
        while (list1 != null &&  list2 != null) {
            if (list1.val > list2.val) {
                removeNode.next = list2;
                removeNode = list2;
                list2 = list2.next;
            } else {
                removeNode.next = list1;
                removeNode = list1;
                list1 = list1.next;
            }
        }
        // 将剩余链表加入合成链表中
        while (list1 != null) {
            removeNode.next = list1;
            removeNode = list1;
            list1 = list1.next;
        }
        while (list2 != null) {
            removeNode.next = list2;
            removeNode = list2;
            list2 = list2.next;
        }
        return headNode;
    }
}

