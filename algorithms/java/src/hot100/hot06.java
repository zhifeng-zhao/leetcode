package hot100;

/**
 * 6.Z字形变换
 *  矩形模拟
 * @author zzf
 * @date 2022/8/20 10:22 下午
 */
public class hot06 {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows > s.length()) {
            return s;
        }
        int x = 0;
        // 变化的周期
        int t = numRows * 2 - 2;
        StringBuffer[] buffers = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            buffers[i] = new StringBuffer();
        }
        for (int i = 0; i < s.length(); i++) {
            buffers[x].append(s.charAt(i));
            // 每个周期占用的列numRows - 1
            if (i % t < numRows - 1) {
                x++;
            } else {
                x--;
            }
        }
        StringBuffer ans = new StringBuffer();
        for (StringBuffer buffer : buffers) {
            ans.append(buffer);
        }
        return ans.toString();
    }
}
