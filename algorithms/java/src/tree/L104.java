package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 104. 二叉树的最大深度
 * @author zzf
 * @date 2022/10/9 2:14 上午
 */
public class L104 {
    // 迭代
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int depth = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    // 递归
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
    }
}
