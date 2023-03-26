import java.util.Queue;
import java.util.LinkedList;

/**
 * Design and implement a stack using queues. Write the complete implementation in core java.
 */
public class StackWithQueues<T> {
    private Queue<T> queue1;
    private Queue<T> queue2;

    public StackWithQueues() {
        queue1 = new LinkedList<T>();
        queue2 = new LinkedList<T>();
    }

    // Push an element onto the stack by adding it to queue1
    public void push(T value) {
        queue1.add(value);
    }

    // Pop the top element from the stack by moving all elements from queue1 to queue2
    // except for the last element, which we remove from queue1 and return
    public T pop() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        T result = queue1.remove();

        // Swap the references to queue1 and queue2
        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return result;
    }

    // Peek at the top element of the stack by moving all elements from queue1 to queue2
    // except for the last element, which we return as the result
    public T peek() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        T result = queue1.remove();
        queue2.add(result);

        // Swap the references to queue1 and queue2
        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return result;
    }

    // Check if the stack is empty by checking if queue1 is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    // Get the number of elements in the stack by getting the size of queue1
    public int size() {
        return queue1.size();
    }
}
