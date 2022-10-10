package tree;

/**
 * 530. 二叉搜索树的最小绝对差
 * 中序遍历
 * @author zzf
 * @date 2022/10/10 5:00 下午
 */
public class L530 {
    TreeNode pre;
    int res = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traversal(root);
        return res;
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        if (pre != null) {
            res = Math.min(res, root.val - pre.val);
        }
        pre = root;
        traversal(root.right);
    }
}
