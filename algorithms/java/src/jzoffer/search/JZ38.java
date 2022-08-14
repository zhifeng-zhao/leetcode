package jzoffer.search;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 字符串的排列
 *
 * @author zzf
 * @date 2022/8/13 10:32 下午
 */
public class JZ38 {
    private ArrayList<String> ans = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0) {
            return ans;
        }
        char[] chars = str.toCharArray();
        // 字典排序
        Arrays.sort(chars);
        backtracking(chars, new boolean[chars.length], new StringBuilder());
        return ans;
    }

    private void backtracking(char[] chars, boolean[] hasUsed, StringBuilder s) {
        if (chars.length == s.length()) {
            ans.add(s.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i]) {
                continue;
            }
            // 确保不重复
            if (i != 0 && chars[i] == chars[i - 1] && hasUsed[i - 1]) {
                continue;
            }
            hasUsed[i] = true;
            s.append(chars[i]);
            backtracking(chars, hasUsed, s);
            // 回溯
            s.deleteCharAt(s.length() - 1);
            hasUsed[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println();
        new JZ38().Permutation("aba");
        System.out.println("");
    }
}
