package jzoffer.tree;

/**
 * 二叉树中和为某一值的路径(三)
 * @author zzf
 * @date 2022/8/12 12:10 下午
 */
public class JZ84 {
    private int num = 0;
    public int FindPath (TreeNode root, int sum) {
        if (root== null) {
            return num;
        }
        dfs(root, sum);
        // 以子节点为新的根节点
        FindPath(root.left, sum);
        FindPath(root.right, sum);
        return num;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (root.val == sum) {
            num++;
        }
        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
    }
}
