package hot100;

import java.util.Stack;

/**
 * 20. 有效的括号
 *
 * @author zzf
 * @date 2022/8/22 3:29 下午
 */
public class hot20 {
    public boolean isValid(String s) {
        // 左括号入栈，比较距离最近的左括号
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && match(c) == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private char match(Character c) {
        if (c == '}') {
            return '{';
        }
        if (c == ']') {
            return '[';
        }
        return '(';
    }
}
