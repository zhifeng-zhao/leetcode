package jzoffer.tree;

/**
 * 二叉树的下一个结点
 *
 * @author zzf
 * @date 2022/8/12 2:00 上午
 */
public class JZ8 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 右节点是否为空，遍历右节点下最左节点
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                // 父节点的左节点等于当前节点
                if (parent.left == pNode) {
                    return parent;
                }
                pNode = pNode.next;
            }
        }
        return null;
    }
}
