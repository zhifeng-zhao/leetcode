package jzoffer.backtrack;

/**
 * 机器人的运动范围
 *
 * @author zzf
 * @date 2022/8/14 2:56 下午
 */
public class JZ13 {
    // 移动方向
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int ans = 0;

    public int movingCount(int threshold, int rows, int cols) {
        if (threshold <= 0) {
            return 1;
        }
        dfs(0, 0, rows, cols, threshold, new boolean[rows][cols]);
        return ans;
    }

    /**
     * 计算位数和
     * @param num
     * @return
     */
    private int sum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    private void dfs(int i, int j, int rows, int cols, int threshold, boolean[][] hasUsed) {
        if (i >= rows || i < 0 || j >= cols || j < 0 || hasUsed[i][j]) {
            return;
        }
        if (sum(i) + sum(j) > threshold) {
            return;
        }
        ans++;
        hasUsed[i][j] = true;
        for (int k = 0; k < dir.length; k++) {
            dfs(i + dir[k][0], j + dir[k][1], rows, cols, threshold, hasUsed);
        }
    }
}
