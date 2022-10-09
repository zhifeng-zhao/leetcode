package tree;

/**
 * 404. 左叶子之和
 *
 * @author zzf
 * @date 2022/10/9 5:02 下午
 */
public class L404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftVal = sumOfLeftLeaves(root.left);
        int rightVal = sumOfLeftLeaves(root.right);
        int val = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            val = root.left.val;
        }
        val = val + leftVal + rightVal;
        return val;
    }
}
