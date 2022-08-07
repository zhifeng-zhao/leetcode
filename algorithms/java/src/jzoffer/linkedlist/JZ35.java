package jzoffer.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表的复制
 *
 * @author zzf
 * @date 2022/8/7 6:06 下午
 */
public class JZ35 {
    /**
     * map映射
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode removeNode = pHead;
        // 遍历复制链表值，创建原链表与新链表间的映射关系
        while (removeNode != null) {
            RandomListNode node = new RandomListNode(removeNode.label);
            map.put(removeNode, node);
            removeNode = removeNode.next;
        }
        // 重置移动节点
        removeNode = pHead;
        // 遍历复制原链表的结构关系
        while (removeNode != null) {
            RandomListNode node = map.get(removeNode);
            node.next = map.get(removeNode.next);
            node.random = map.get(removeNode.random);
            removeNode = removeNode.next;
        }
        return map.getOrDefault(pHead, null);
    }

    public RandomListNode Clone2(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        // 1.创建新的节点插入到原链表中
        RandomListNode removeNode = pHead;
        while (removeNode != null) {
            RandomListNode temp = removeNode.next;
            RandomListNode node = new RandomListNode(removeNode.label);
            removeNode.next = node;
            node.next = temp;
            removeNode = temp;
        }
        // 2.创建random节点的指向
        removeNode = pHead;
        while (removeNode != null) {
            removeNode.next.random = removeNode.random == null ? null : removeNode.random.next;
            removeNode = removeNode.next.next;
        }
        // 3.链表的分割
        removeNode = pHead;
        RandomListNode ans = pHead.next;
        while (removeNode != null) {
            RandomListNode node = removeNode.next;
            // 原链表节点
            removeNode.next = node.next;
            // 新链表节点
            node.next = node.next == null ? null : node.next.next;
            removeNode = removeNode.next;
        }
        return ans;
    }
}
