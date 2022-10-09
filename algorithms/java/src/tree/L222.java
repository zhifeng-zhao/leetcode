package tree;

/**
 * 222. 完全二叉树的节点个数
 * @author zzf
 * @date 2022/10/9 3:34 下午
 */
public class L222 {
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
