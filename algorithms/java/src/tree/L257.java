package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * @author zzf
 * @date 2022/10/9 4:00 下午
 */
public class L257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        traversal(root, path, res);
        return res;
    }

    private void traversal(TreeNode root, List<Integer> path, List<String> res) {
        path.add(root.val);
        if (root != null && root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size() - 1));
            res.add(sb.toString());
        }
        if (root.left != null) {
            traversal(root.left, path, res);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            traversal(root.right, path, res);
            path.remove(path.size() - 1);
        }
    }
}
