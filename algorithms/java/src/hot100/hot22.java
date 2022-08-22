package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 回溯框架
 * result = []
 * def backtrack(路径, 选择列表):
 * if 满足结束条件:
 * result.add(路径)
 * return
 * <p>
 * for 选择 in 选择列表:
 * 做选择
 * backtrack(路径, 选择列表)
 * 撤销选择
 *
 * @author zzf
 * @date 2022/8/22 6:57 下午
 */
public class hot22 {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, n, new StringBuilder());
        return ans;
    }

    private void backtrack(int left, int right, StringBuilder sb) {
        if (left > right || left < 0) {
            return;
        }
        if (left == 0 && right == 0) {
            ans.add(sb.toString());
            return;
        }
        sb.append("(");
        backtrack(left - 1, right, sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        backtrack(left, right - 1, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
