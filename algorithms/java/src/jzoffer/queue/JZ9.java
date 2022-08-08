package jzoffer.queue;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 通过两个栈间元素复制交换实现队列
 * @author zzf
 * @date 2022/8/8 2:56 下午
 */
public class JZ9 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public void push2(int node) {
        stack1.push(node);
    }

    public int pop2() {
        if (stack2.size() <= 0) {
            while (stack1.size() != 0) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
