package jzoffer.tree;

/**
 * 二叉树的深度
 * @author zzf
 * @date 2022/8/10 3:15 下午
 */
public class JZ55 {
    public int TreeDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }
}
