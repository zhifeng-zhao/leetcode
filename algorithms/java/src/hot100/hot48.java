package hot100;

/**
 * 48. 旋转图像
 * 先对角线反转，再反转每一行
 *
 * @author zzf
 * @date 2022/9/9 3:38 上午
 */
public class hot48 {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        int left;
        int right;
        for (int[] ints : matrix) {
            left = 0;
            right = ints.length - 1;
            while (left < right) {
                int temp = ints[left];
                ints[left++] = ints[right];
                ints[right--] = temp;
            }
        }
    }
}
