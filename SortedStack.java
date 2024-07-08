import java.util.Scanner;
import java.util.Stack;

public class SortedStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        try(Scanner scanner = new Scanner (System.in)) {
            System.out.println("Enter the number of elements you want to sort: ");
            int n = scanner.nextInt();

            System.out.println("Enter the elements:");
            for (int i = 0; i < n; i++) {
                int element = scanner.nextInt();
                stack.push(element);
            }

        }
            System.out.println("The numbers to be sorted are: " + stack);
            Stack<Integer> sortedStack = sortStack(stack);
            System.out.println("The numbers after sorting are: " + sortedStack);
    }

    public static Stack<Integer> sortStack (Stack<Integer> stack) {
        Stack<Integer> sortedStack = new Stack<>();
        while(!stack.empty()) {
            int current = stack.pop();
            while(!sortedStack.isEmpty() && sortedStack.peek() > current) {
                stack.push(sortedStack.pop());
            }
            sortedStack.push(current);
        }
        return sortedStack;
    }
}
