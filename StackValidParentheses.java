import java.util.Scanner;
import java.util.Stack;

public class StackValidParentheses {
    public static void main (String[] args) {
        Stack<Character> stack = new Stack<>();
        String inputString;

        try (Scanner scanner = new Scanner (System.in)) {
            System.out.println("Enter a string: ");
            inputString = scanner.nextLine();   
        }

        boolean checker = validParentheses(stack, inputString);
        System.out.println ("The string passes the valid parentheses? " + checker);

    }

    public static boolean validParentheses (Stack<Character> stack, String s) {
        for (char c: s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c); 
            } else {
                if (stack.isEmpty()) return false;
                else {
                    char top = stack.pop();
                    if (c == '}' && top != '{' ||
                    c == ')' && top != '(' ||
                    c == ']' && top != '[') {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    
    }
}