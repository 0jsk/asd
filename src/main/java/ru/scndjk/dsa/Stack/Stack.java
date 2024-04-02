import java.util.*;

public class Stack<T> {
    private final LinkedList<T> stack;

    public Stack() {
        stack = new LinkedList<>();
    }

    public int size() {
        return stack.size();
    }

    public T pop() {
        if (stack.isEmpty()) {
            return null;
        }

        return stack.removeFirst();
    }

    public void push(T val) {
        stack.addFirst(val);
    }

    public T peek() {
        if (stack.isEmpty()) {
            return null;
        }

        return stack.getFirst();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
