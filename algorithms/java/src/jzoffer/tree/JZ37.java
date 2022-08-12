package jzoffer.tree;

/**
 * 序列化二叉树
 *
 * @author zzf
 * @date 2022/8/12 9:23 下午
 */
public class JZ37 {
    private String deserializeStr;

    String Serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }

    TreeNode Deserialize(String str) {
        deserializeStr = str;
        return Deserialize();
    }

    private TreeNode Deserialize() {
        if (deserializeStr.length() == 0) {
            return null;
        }
        // 分割树的值
        int index = deserializeStr.indexOf(" ");
        String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
        deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
        if ("#".equals(node)) {
            return null;
        }
        // 创建新的树
        TreeNode tree = new TreeNode(Integer.parseInt(node));
        tree.left = Deserialize();
        tree.right = Deserialize();
        return tree;
    }
}
