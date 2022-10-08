package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 226. 翻转二叉树
 * @author zzf
 * @date 2022/10/8 10:31 下午
 */
public class L226 {
    // dfs
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        invertTree(root.left);
        invertTree(root.right);
        swap(root);
        return root;
    }

    private void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    //bfs
    public TreeNode invertTree2(TreeNode root) {
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                TreeNode node = que.poll();
                swap(root);
                if (node.left != null) {
                    que.offer(root.left);
                }
                if (node.right != null) {
                    que.offer(root.right);
                }
            }
        }
        return root;
    }
}
