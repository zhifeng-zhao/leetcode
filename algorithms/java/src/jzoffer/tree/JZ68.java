package jzoffer.tree;

/**
 * 二叉搜索树的最近公共祖先
 *
 * @author zzf
 * @date 2022/8/12 1:48 下午
 */
public class JZ68 {
    public int lowestCommonAncestor(TreeNode root, int p, int q) {
        return find(root, p, q).val;
    }

    private TreeNode find(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = find(root.left, p, q);
        TreeNode right = find(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
