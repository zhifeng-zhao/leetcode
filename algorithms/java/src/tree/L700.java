package tree;

/**
 * 700. 二叉搜索树中的搜索
 * @author zzf
 * @date 2022/10/10 4:25 下午
 */
public class L700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        while (root != null) {
            if (root.val < val) {
                root = root.left;
            } else if (root.val > val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
