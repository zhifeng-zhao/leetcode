package jzoffer.tree;

/**
 * 二叉搜索树与双向链表
 *
 * @author zzf
 * @date 2022/8/11 8:54 下午
 */
public class JZ36 {
    private TreeNode head = null;
    private TreeNode pre = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        inOrder(pRootOfTree);
        return head;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        // 往左遍历
        inOrder(node.left);
        // 当前节点左节点指向前节点
        node.left = pre;
        // 前节点不为空，前节点右节点指向当前节点
        if (pre != null) {
            pre.right = node;
        }
        // 当前节点做为前节点
        pre = node;
        if (head == null) {
            head = node;
        }
        inOrder(node.right);
    }
}
