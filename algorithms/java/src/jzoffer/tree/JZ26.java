package jzoffer.tree;

/**
 * 树的子结构
 * @author zzf
 * @date 2022/8/11 11:21 上午
 */
public class JZ26 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        // 遍历当前节点是否含有子结构，否遍历左节点或右节点
        return isSubtree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        // 判断子节点是否相同
        return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
    }
}
