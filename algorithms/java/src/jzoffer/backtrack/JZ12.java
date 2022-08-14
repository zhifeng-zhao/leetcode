package jzoffer.backtrack;

/**
 * 矩阵中的路径
 *  回溯
 * @author zzf
 * @date 2022/8/14 2:21 下午
 */
public class JZ12 {
    public boolean hasPath(char[][] matrix, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (dfs(matrix, chars, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] matrix, char[] word, int h, int l, int index) {
        if (l < 0 || h >= matrix.length || h < 0 || l >= matrix[0].length || matrix[h][l] != word[index]) {
            return false;
        }
        if (index == word.length - 1) {
            return true;
        }
        // 标记已使用
        char temp = matrix[h][l];
        matrix[h][l] = '*';
        // 下上右左四个方向
        boolean res = dfs(matrix, word, h + 1, l, index + 1)
                || dfs(matrix, word, h - 1, l, index + 1)
                || dfs(matrix, word, h, l + 1, index + 1)
                || dfs(matrix, word, h, l - 1, index + 1);
        matrix[h][l] = temp;
        return res;
    }

    public static void main(String[] args) {
        char[][] chars= {{'a','b'},{'c','d'}};
        new JZ12().hasPath(chars , "abcd");
    }

}
