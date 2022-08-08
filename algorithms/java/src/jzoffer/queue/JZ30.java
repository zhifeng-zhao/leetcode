package jzoffer.queue;

import java.util.Stack;

/**
 * 包含min函数的栈
 *
 * @author zzf
 * @date 2022/8/8 3:19 下午
 */
public class JZ30 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
        if (minStack.isEmpty() || minStack.peek() > node) {
            minStack.push(node);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if (!stack1.isEmpty()) {
        stack1.pop();

        }
        if (!minStack.isEmpty()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
