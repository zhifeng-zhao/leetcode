package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * @author zzf
 * @date 2022/10/9 11:06 下午
 */
public class L105 {
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return findNode(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode findNode(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        if (preBegin >= preEnd || inBegin >= inEnd) {
            return null;
        }
        int rootIndex = map.get(preorder[preBegin]);
        TreeNode treeNode = new TreeNode(inorder[rootIndex]);
        int lenLeft = rootIndex - inBegin;
        treeNode.left = findNode(preorder, preBegin + 1, preBegin + lenLeft + 1,
                inorder, inBegin, rootIndex);
        treeNode.right = findNode(preorder, preBegin + lenLeft + 1, preEnd,
                inorder, rootIndex + 1, inEnd);
        return treeNode;
    }
}
