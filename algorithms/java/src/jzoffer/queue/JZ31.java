package jzoffer.queue;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 * 使用一个栈来模拟压入弹出操作。
 * 每次入栈一个元素后，都要判断一下栈顶元素是不是当前出栈序列 popA的第一个元素，
 * 如果是的话则执行出栈操作并将 popIndex 往后移一位，继续进行判断。
 * @author zzf
 * @date 2022/8/8 4:12 下午
 */
public class JZ31 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < pushA.length; pushIndex++) {
            stack.push(pushA[pushIndex]);
            while (popIndex < popA.length && !stack.isEmpty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
