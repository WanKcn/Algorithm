import java.util.Queue;
import java.util.LinkedList;

public class MyStack4 {
    private Queue<Integer> q;

    public MyStack4() {
        q = new LinkedList<>();
    }

    public void push(int x) {

        // 首先，将 x 入队
        q.add(x);

        // 执行 n - 1 次出队再入队的操作
        for (int i = 1; i < q.size(); i++)
            q.add(q.remove());
    }

    public int pop() {
        return q.remove();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
