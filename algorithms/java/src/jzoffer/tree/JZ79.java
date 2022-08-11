package jzoffer.tree;

/**
 * 判断是不是平衡二叉树
 * 左右子节点深度差不超过1
 * @author zzf
 * @date 2022/8/11 10:01 下午
 */
public class JZ79 {
    public boolean IsBalanced_Solution(TreeNode root) {
            if (root == null) {
                return true;
            }
            return IsBalanced_Solution(root.left)
                    && IsBalanced_Solution(root.right)
                    && Math.abs(deep(root.left) - deep(root.right)) < 2;
    }

    private int deep(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(deep(node.left), deep(node.right)) + 1;
    }
}
