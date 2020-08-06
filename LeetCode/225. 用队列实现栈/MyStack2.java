import java.util.LinkedList;
import java.util.Queue;

public class MyStack2 {
    private Queue<Integer> q;
    private int top;

    public MyStack2() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
        top = x;
    }

    public int pop() {

        Queue<Integer> q2 = new LinkedList<>();
        while (q.size() > 1){
            // 每从 q 中取出一个元素，都给 top 赋值
            // top 最后存储的就是 q 中除了队尾元素以外的最后一个元素
            // 即新的栈顶元素
            top = q.peek();
            q2.add(q.remove());
        }

        int ret = q.remove();
        q = q2;
        return ret;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
