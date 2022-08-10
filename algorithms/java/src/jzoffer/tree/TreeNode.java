package jzoffer.tree;

/**
 *         1
 *       2   3
 *      4   5 6
 * 前序遍历：当前节点，左节点，右节点。 124356
 * 中序遍历：左节点，当前节点，右节点。 421536
 * 后序遍历：左节点，右节点，当前节点。 425631
 * @author zzf
 * @date 2022/8/10 3:15 下午
 */
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
