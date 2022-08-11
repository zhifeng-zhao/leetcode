package jzoffer.tree;

/**
 * 二叉树的镜像
 *
 * @author zzf
 * @date 2022/8/11 3:10 下午
 */
public class JZ27 {
    public TreeNode Mirror(TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }
        swap(pRoot);
        Mirror(pRoot.left);
        Mirror(pRoot.right);
        return pRoot;
    }

    /**
     * 交换左右节点
     *
     * @param root
     */
    private void swap(TreeNode root) {
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
    }
}
