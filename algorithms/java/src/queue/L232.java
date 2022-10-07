package queue;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 *
 * @author zzf
 * @date 2022/10/7 2:35 下午
 */
public class L232 {
    class MyQueue {
        Stack<Integer> in;
        Stack<Integer> out;

        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            dumpStackIn();
            return out.pop();
        }

        public int peek() {
            dumpStackIn();
            return out.peek();
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }

        private void dumpStackIn() {
            if (out.empty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
        }
    }
}
