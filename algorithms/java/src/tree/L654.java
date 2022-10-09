package tree;

/**
 * 654. 最大二叉树
 *
 * @author zzf
 * @date 2022/10/9 11:51 下午
 */
public class L654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree1(nums, 0, nums.length);
    }

    private TreeNode constructMaximumBinaryTree1(int[] nums, int left, int right) {
        if (right - left < 1) {
            return null;
        }
        if (right - left == 1) {
            return new TreeNode(nums[left]);
        }
        int maxIndex = left;
        int maxVal = nums[maxIndex];
        for (int i = left + 1; i < right; i++) {
            if (nums[i] > maxVal) {
                maxIndex = i;
                maxVal = nums[i];
            }
        }
        TreeNode treeNode = new TreeNode(maxVal);
        treeNode.left = constructMaximumBinaryTree1(nums, left, maxIndex);
        treeNode.right = constructMaximumBinaryTree1(nums, maxIndex + 1, right);
        return treeNode;
    }
}
