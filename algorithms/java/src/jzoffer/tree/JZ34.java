package jzoffer.tree;

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径(二)
 *  深度优先搜索dfs
 * @author zzf
 * @date 2022/8/11 8:10 下午
 */
public class JZ34 {
    private ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectNumber) {
        path(root, expectNumber, new ArrayList<>());
        return ans;
    }

    private void path(TreeNode root, int exp, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == exp) {
            ans.add(new ArrayList<Integer>(list));
        }
        path(root.left, exp - root.val, list);
        path(root.right, exp - root.val, list);
        // 删除节点
        list.remove(list.size() - 1);
    }
}
