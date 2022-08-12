package jzoffer.tree;

/**
 * 对称的二叉树
 * 递归
 * @author zzf
 * @date 2022/8/12 11:39 上午
 */
public class JZ28 {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    boolean isSymmetrical(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null && treeNode2 == null) {
            return true;
        }
        if (treeNode1 == null || treeNode2 == null || treeNode1.val != treeNode2.val) {
            return false;
        }
        return isSymmetrical(treeNode1.left, treeNode2.right)
                && isSymmetrical(treeNode1.right, treeNode2.left);
    }
}
