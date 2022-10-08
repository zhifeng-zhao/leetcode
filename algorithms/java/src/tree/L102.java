package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * @author zzf
 * @date 2022/10/8 10:09 下午
 */
public class L102 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    /**
     * 递归
     * @param root 根节点
     * @param deep 层数
     */
    private void dfs(TreeNode root, Integer deep) {
        if (root == null) {
            return;
        }
        deep++;
        if (deep > res.size()) {
            List<Integer> list = new ArrayList<>();
            res.add(list);
        }
        res.get(deep - 1).add(root.val);
        dfs(root.left, deep);
        dfs(root.right, deep);
    }

    /**
     * 迭代
     * @param root
     */
    private void found(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int len = queue.size();
            while (len > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                len--;
            }
            res.add(list);
        }
    }
}
