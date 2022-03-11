package array;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 *      给定一个二维矩阵 matrix，以下类型的多个请求：
 *      计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2)
 *
 * 思路：
 *      构建一个前置矩阵，记录原点为0，0时的矩阵和，通过大矩阵减小矩阵得出所需范围总和
 * @author zzf
 * @date 2022/3/11 10:56 上午
 */
class NumMatrix {

    int[][] preMatrix;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        preMatrix = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < preMatrix.length; i++) {
            for (int j = 1; j < preMatrix[i].length; j++) {
                preMatrix[i][j] = preMatrix[i - 1][j] + preMatrix[i][j - 1] + matrix[i - 1][j - 1] - preMatrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preMatrix[row2 + 1][col2 + 1] - preMatrix[row1][col2 + 1] - preMatrix[row2 + 1][col1] + preMatrix[row1][col1];
    }

    public static void main(String[] args) {
        int[][] num = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix numMatrix = new NumMatrix(num);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }
}
