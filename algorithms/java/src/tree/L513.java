package tree;

/**
 * 513. 找树左下角的值
 * @author zzf
 * @date 2022/10/9 5:28 下午
 */
public class L513 {
    int res;
    int Deep = -1;

    public int findBottomLeftValue(TreeNode root) {
        res = root.val;
        find(root, 0);
        return res;
    }

    private void find(TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (deep > Deep) {
                res = root.val;
                Deep = deep;
            }
        }
        if (root.left != null) {
            find(root.left, deep + 1);
        }
        if (root.right != null) {
            find(root.right, deep + 1);
        }
    }

}
