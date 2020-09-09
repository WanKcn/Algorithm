import java.util.Deque;
import java.util.LinkedList;

class CQueue {

    private Deque<Integer> stack1, stack2;

    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.isEmpty())
            stack1.push(stack2.pop());
    }

    public int deleteHead() {
        if (stack1.size() == 0)
            return -1;
        int res = stack1.peek();
        stack1.pop();
        return res;
    }
}

