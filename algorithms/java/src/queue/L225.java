package queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 225. 用队列实现栈
 *
 * @author zzf
 * @date 2022/10/7 2:47 下午
 */
public class L225 {
    class MyStack {
        Deque<Integer> que;

        public MyStack() {
            que = new ArrayDeque<>();
        }

        public void push(int x) {
            que.addLast(x);
        }

        public int pop() {
            int size = que.size();
            size--;
            while (size-- > 0) {
                que.addLast(que.peekFirst());
                que.pollFirst();
            }
            return que.pollFirst();
        }

        public int top() {
            return que.peekLast();
        }

        public boolean empty() {
            return que.isEmpty();
        }
    }
}
