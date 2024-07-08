import java.util.Scanner;
import java.util.Stack;

public class StackReverseString {

    public static void main (String[] args) {
        Stack<Character> stack = new Stack<>();
        String originalString;

        try (Scanner scanner = new Scanner (System.in)) {
            System.out.println("Enter a string: ");
            originalString = scanner.nextLine();
        }

        String reversedString = reverseString(stack, originalString);
        System.out.println("The string after reversing is: " + reversedString);

    }

    public static String reverseString (Stack<Character> stack, String s) {
        for (char c: s.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();

    }

    
}
