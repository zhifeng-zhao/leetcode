package listnode;

/**
 * 707. 设计链表
 *
 * @author zzf
 * @date 2022/9/29 5:21 下午
 */
public class L707 {
    static class MyLinkedList {
        int size;
        ListNode listNode;

        public MyLinkedList() {
            size = 0;
            listNode = new ListNode(0);
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode cur = listNode;
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index < 0) {
                index = 0;
            }
            ListNode head = listNode;
            for (int i = 0; i < index; i++) {
                head = head.next;
            }
            ListNode newNode = new ListNode(val);
            newNode.next = head.next;
            head.next = newNode;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            size--;
            ListNode head = listNode;
            for (int i = 0; i < index; i++) {
                head = head.next;
            }
            head.next = head.next.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1,2);
        System.out.println(myLinkedList.get(1));
        myLinkedList.deleteAtIndex(0);
        System.out.println(myLinkedList.get(0));
    }
}
