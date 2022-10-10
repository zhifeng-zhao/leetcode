package tree;

/**
 * 98. 验证二叉搜索树
 * @author zzf
 * @date 2022/10/10 4:47 下午
 */
public class L98 {
    TreeNode max;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        if (max != null && root.val <= max.val) {
            return false;
        }
        max = root;
        return isValidBST(root.right);
    }
}
