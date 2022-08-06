package jzoffer.linkedlist;

/**
 * 删除链表中重复的结点
 * @author zzf
 * @date 2022/8/7 1:40 上午
 */
public class JZ76 {
    private static ListNode change(ListNode listNode) {
        int temp = listNode.val;
        while (listNode != null && listNode.val == temp) {
            listNode = listNode.next;
        }
        return listNode;
    }
    public static ListNode deleteDuplication(ListNode pHead) {
        ListNode ans = pHead;
        while (ans != null) {
            // 获得最终链表头节点，删除头部重复节点
            if (ans.next != null && ans.val == ans.next.val) {
                ans = change(ans);
            } else {
                break;
            }
        }
        if (ans == null) {
            return null;
        }
        // 最终链表尾节点
        ListNode head = ans;
        ListNode removeNode = ans.next;
        while (removeNode != null) {
            // 删除中间重复节点
            if (removeNode.next != null && removeNode.val == removeNode.next.val) {
                removeNode = change(removeNode);
            } else {
                head.next = removeNode;
                head = removeNode;
                removeNode = removeNode.next;
            }
        }
        // 删除末尾重复节点
        head.next = null;
        return ans;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode removeNode = head;
        for (int i = 1; i < 3; i++) {
            ListNode j = new ListNode(2);
            removeNode.next = j;
            removeNode = j;
        }
        System.out.println(deleteDuplication(head));
    }
}
