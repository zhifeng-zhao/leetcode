package jzoffer.tree;

import java.util.*;

/**
 * 二叉搜索树的第k个节点
 * 中序遍历
 * @author zzf
 * @date 2022/8/10 10:36 下午
 */
public class JZ54 {
    public int KthNode(TreeNode proot, int k) {
        if (proot == null || k < 1) {
            return -1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(proot);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode treeNode = queue.poll();
                if (treeNode == null) {
                    continue;
                }
                list.add(treeNode.val);
                queue.add(treeNode.left);
                queue.add(treeNode.right);
            }
        }
        if (list.size() < k) {
            return -1;
        }
        Collections.sort(list);
        return list.get(k - 1);
    }

    /**
     * 中序遍历
     *
     * @param proot
     * @param k
     * @return
     */
    private int cnt = 0;
    private int ans = -1;

    public int KthNode2(TreeNode proot, int k) {
        inOrder(proot, k);
        return ans;
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null || cnt > k) {
            return;
        }
        inOrder(root.left, k);
        cnt++;
        if (cnt == k) {
            ans = root.val;
        }
        inOrder(root.right, k);
    }
}
