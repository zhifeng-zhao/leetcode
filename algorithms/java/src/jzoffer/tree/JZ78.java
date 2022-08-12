package jzoffer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 把二叉树打印成多行
 *
 * @author zzf
 * @date 2022/8/12 11:56 上午
 */
public class JZ78 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (cnt-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (list.size() != 0) {
                ans.add(list);
            }
        }
        return ans;
    }
}
