import java.util.Stack;

public class CustomStack {
    private Stack<Integer> stack;

    public CustomStack() {
        stack = new Stack<>();
    }

    public void push(int element) {
        if (stack.isEmpty() || element == stack.peek() + 1) {
        stack.push(element);
        System.out.println("Added: " + element);
        } 
        else {
            System.out.println("Error: Element " + element + " must be equal to top element plus  one.");
        }
    }

    public Integer pop() {
        if (!stack.isEmpty()) {
            return stack.pop();
        } else {
            System.out.println("Stack is empty.");
            return null;
        }
    }

    public Integer peek() {
        return stack.isEmpty() ? null : stack.peek();
    }

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack();
        customStack.push(1); // Added: 1
        customStack.push(2); // Added: 2
        customStack.push(4); // Error: Element 4 must be equal to top element plus one.
        customStack.push(3); // Added: 3
        customStack.push(5); // Added: 5
        customStack.push(6); // Added: 6
        customStack.push(8); // Error: Element 8 must be equal to top element plus one.
        // Print the stack elements
        System.out.println("Current stack: " + customStack.stack);
    }
}