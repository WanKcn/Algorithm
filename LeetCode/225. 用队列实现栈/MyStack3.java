import java.util.Queue;
import java.util.LinkedList;

public class MyStack3 {
    private Queue<Integer> q;

    public MyStack3() {
        q = new LinkedList<>();
    }

    public void push(int x) {

        Queue<Integer> q2 = new LinkedList<>();

        q2.add(x);
        while (!q.isEmpty())
            q2.add(q.remove());

        q = q2;
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
