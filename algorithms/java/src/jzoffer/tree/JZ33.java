package jzoffer.tree;

/**
 * 二叉搜索树的后序遍历序列
 *
 * @author zzf
 * @date 2022/8/11 4:05 下午
 */
public class JZ33 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length < 1) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] seq, int first, int last) {
        // 区间小于等于1时不会有新的左右节点树
        if (last - first <= 1) {
            return true;
        }
        // 后序遍历最尾为根节点
        int rootVal = seq[last];
        // 左右节点分割坐标
        int cutIndex = first;
        while (cutIndex < last && seq[cutIndex] < rootVal) {
            cutIndex++;
        }
        // 遍历右区间,右区间所有值大于根节点
        for (int i = cutIndex; i < last; i++) {
            if (seq[i] < rootVal) {
                return false;
            }
        }
        return verify(seq, first, cutIndex - 1) && verify(seq, cutIndex, last - 1);
    }

    public static void main(String[] args) {
        int[] vin = {4, 6, 7, 5};
        System.out.println(new JZ33().VerifySquenceOfBST(vin));
    }
}
