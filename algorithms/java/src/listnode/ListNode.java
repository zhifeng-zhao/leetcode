package listnode;

/**
 * @author zzf
 * @date 2022/8/6 10:42 上午
 */
public class ListNode {
    int val;
    ListNode next = null;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
