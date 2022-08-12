package jzoffer.tree;

/**
 * 在二叉树中找到两个节点的最近公共祖先
 * 递归
 * @author zzf
 * @date 2022/8/12 1:40 下午
 */
public class JZ86 {
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        return find(root, o1, o2).val;
    }

    private TreeNode find(TreeNode root, int o1, int o2) {
        if (root == null || root.val == o1 || root.val == o2) {
            return root;
        }
        TreeNode left = find(root.left, o1, o2);
        TreeNode right = find(root.right, o1, o2);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        // 左右节点不为空，返回当前节点
        return root;
    }
}
