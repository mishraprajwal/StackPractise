import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a string: ");
            String infix = scanner.nextLine();
            String postfix = convertInfixToPostfix(infix);
            System.out.println("The postfix expression is: " + postfix);
        }
    }


    public static String convertInfixToPostfix (String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfixExpression = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfixExpression.append(c);
            }
            else if (c == '(') {
                stack.push(c);
            }

            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfixExpression.append(stack.pop());
                }

                stack.pop();
            }

            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfixExpression.append(stack.pop());
                }
                stack.push(c);
            }

        }

        while (!stack.isEmpty()) {
            postfixExpression.append(stack.pop());
        }

        return postfixExpression.toString();

    }

    public static int precedence(char op) {
        switch (op) {
            case '+', '-' -> {
                return 1;
            }
            case '*', '/' -> {
                return 2;
            }
            case '^' -> {
                return 3;
            }
        }
        return -1;
    }
    
}
