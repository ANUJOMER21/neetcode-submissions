public class ArrayStack<T> {
    private T[] data;
    private int top = -1;

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        data = (T[]) new Object[capacity];
    }

    public void push(T item) {
        if (top == data.length - 1) {
            resize(data.length * 2);          // grow when full
        }
        data[++top] = item;
    }

    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack underflow");
        T item = data[top];
        data[top--] = null;                   // avoid memory leak
        return item;
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        T[] copy = (T[]) new Object[newCapacity];
        System.arraycopy(data, 0, copy, 0, top + 1);
        data = copy;
    }
}
class Solution {
    public int evalRPN(String[] tokens) {
        ArrayStack<Integer> stack = new ArrayStack<>(10);

        for (String token : tokens) {
            if (token.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            } else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);   // Java int division truncates toward zero, as the problem requires
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}