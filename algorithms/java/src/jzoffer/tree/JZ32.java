package jzoffer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印二叉树
 * @author zzf
 * @date 2022/8/11 3:20 下午
 */
public class JZ32 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                ans.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return ans;
    }
}
