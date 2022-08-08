package jzoffer.queue;

import java.util.Stack;

/**
 * 翻转单词序列
 * @author zzf
 * @date 2022/8/9 12:25 上午
 */
public class JZ73 {
    public String ReverseSentence(String str) {
        Stack<String> stack = new Stack<>();
        String[] strings = str.split(" ");
        for (String string : strings) {
            stack.push(string);
        }
        StringBuffer ans = new StringBuffer();
        while (!stack.isEmpty()) {
            ans.append(stack.pop()).append(" ");
        }
        return ans.toString().trim();
    }

    /**
     * 不使用额外空间
     * 将str转换成char数组，第一遍先反转单词，第二边将所有字母反转
     * @param str
     * @return
     */
    public static String ReverseSentence2(String str) {
        int length = str.length();
        char[] chars = str.toCharArray();
        int i = 0,j = 0;
        while (j <= length) {
            if (j == length || chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        reverse(chars, 0, length - 1);
        return new String(chars);
    }

    public static void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[j];
            chars[j--] = chars[i];
            chars[i++] = temp;
        }
    }

    public static void main(String[] args) {
        String str = new String("nowcoder. a am I");
        ReverseSentence2(str);
    }
}
