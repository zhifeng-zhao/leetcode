package jzoffer.other;

/**
 * 构建乘积数组
 *
 * @author zzf
 * @date 2022/8/16 7:33 下午
 */
public class JZ66 {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        B[0] = 1;
        //先乘左边，从左到右
        for (int i = 1; i < A.length; i++) {
            //每多一位由数组B左边的元素多乘一个前面A的元素
            B[i] = B[i - 1] * A[i - 1];
        }
        int temp = 1;
        //再乘右边，从右到左
        for (int i = A.length - 1; i >= 0; i--) {
            //temp为右边的累乘
            B[i] *= temp;
            temp *= A[i];
        }
        return B;
    }

    public static void main(String[] args) {
        new JZ66().multiply(new int[]{1, 2, 3, 4, 5});
    }
}
