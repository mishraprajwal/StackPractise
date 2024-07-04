import java.util.Scanner;
import java.util.Stack;

public class StackPractise {
    public static void main (String[] args) {
        Stack<Integer> stack = new Stack<>();

        try(Scanner scanner = new Scanner (System.in)) {
            System.out.println("Enter the number of elements you want to push in the stack:");
            int n = scanner.nextInt();

            System.out.println("Enter the elements:");
            for (int i = 0; i < n; i++) {
                int element = scanner.nextInt();
                pushToStack(stack, element);
            }

            System.out.println("Stack: " + stack);

            System.out.println("Enter the elements you want to pop from the stack:");
            int k = scanner.nextInt();

            for (int i = 0; i < k; i++) {
                if (!stack.isEmpty()) {
                    int y = popFromStack(stack);
                    System.out.println("Popped: " + y);
                } else {
                    System.out.println("Stack is empty, cannot pop more elements.");
                    break;
                }
            }

            System.out.println("The element at the top of the stack is: " + stack.peek());

            System.out.println("Stack: " + stack);

        }

    }

    public static void pushToStack(Stack<Integer> stack, int data) {
        stack.push(data);
    }

    public static int popFromStack(Stack<Integer> stack) {
        return stack.pop();
    }
}
