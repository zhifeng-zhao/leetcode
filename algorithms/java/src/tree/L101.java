package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 101. 对称二叉树
 * @author zzf
 * @date 2022/10/9 1:54 上午
 */
public class L101 {
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || right.val != left.val) {
            return false;
        }
//        if (left == null && right != null) {
//            return false;
//        }
//        if (left != null && right == null) {
//            return false;
//        }
//        if (right.val != left.val) {
//            return false;
//        }
        return compare(left.left, right.right) && compare(left.right, right.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root.left);
        deque.offer(root.right);
        while (!deque.isEmpty()) {
            TreeNode left = deque.poll();
            TreeNode right = deque.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            deque.offer(left.left);
            deque.offer(right.right);
            deque.offer(left.right);
            deque.offer(right.left);
        }
        return true;
    }
}
