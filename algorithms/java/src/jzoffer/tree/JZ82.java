package jzoffer.tree;

/**
 * 二叉树中和为某一值的路径(一)
 *
 * @author zzf
 * @date 2022/8/11 5:59 下午
 */
public class JZ82 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
