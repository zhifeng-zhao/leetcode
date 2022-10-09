package tree;

/**
 * 112. 路径总和
 * @author zzf
 * @date 2022/10/9 6:10 下午
 */
public class L112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }
        if (root.left != null) {
            boolean left = hasPathSum(root.left, targetSum - root.val);
            if (left) {
                return true;
            }
        }
        if (root.right != null) {
            boolean right = hasPathSum(root.right, targetSum - root.val);
            if (right) {
                return true;
            }
        }
        return false;
    }
}
