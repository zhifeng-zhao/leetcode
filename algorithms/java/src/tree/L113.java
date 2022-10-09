package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 *
 * @author zzf
 * @date 2022/10/9 7:13 下午
 */
public class L113 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        path.add(root.val);
        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            res.add(new ArrayList<>(path));
        }
        if (root.left != null) {
            pathSum(root.left, targetSum - root.val);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            pathSum(root.right, targetSum - root.val);
            path.remove(path.size() - 1);
        }
        return res;
    }
}
