package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 *  回溯
 * @author zzf
 * @date 2022/8/22 12:56 下午
 */
public class hot17 {
    // 每个数字到字母的映射
    private String[] map = new String[]{
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return res;
        }
        backtrack(digits, 0, new StringBuffer());
        return res;
    }

    // 回溯算法主函数
    private void backtrack(String digits, int start, StringBuffer sb) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = start; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '0';
            for (char c : map[digit].toCharArray()) {
                sb.append(c);
                backtrack(digits, i + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
