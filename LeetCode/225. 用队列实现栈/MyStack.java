import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private Queue<Integer> q;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        q = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        Queue<Integer> q2 = new LinkedList<>();
        // 前面所有元素出队 每出队一个便入队q2
        while (q.size() > 1)
            q2.add(q.remove());
        // 最后一个元素出队暂存返回
        int ret = q.remove();
        q = q2;
        return ret;

    }

    /**
     * Get the top element.
     */
    public int top() {
        // 查看栈顶元素其实就是取出队尾的元素 取出来暂存然后在入队还原栈
        int ret = pop();
        push(ret);
        return ret;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */