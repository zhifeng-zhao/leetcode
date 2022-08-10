package jzoffer.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 重建二叉树
 *
 * @author zzf
 * @date 2022/8/10 11:01 下午
 */
public class JZ7 {
    private Map<Integer, Integer> vinMap = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        for (int i = 0; i < vin.length; i++) {
            vinMap.put(vin[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int vinL) {
        if (preL > preR) {
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[preL]);
        // 中序遍历中间节点
        int index = vinMap.get(treeNode.val);
        // 当前节点左节点长度
        int treeLeft = index - vinL;
        treeNode.left = reConstructBinaryTree(pre, preL + 1, preL + treeLeft, vinL);
        treeNode.right = reConstructBinaryTree(pre, preL + treeLeft + 1, preR, vinL + treeLeft + 1);
        return treeNode;
    }

    public static void main(String[] args) {
        JZ7 jz7 = new JZ7();
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] vin = {4, 7, 2, 1, 5, 3, 8, 6};
        jz7.reConstructBinaryTree(pre, vin);
    }
}
