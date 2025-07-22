import java.util.*;

// Interface
interface ExpressionEvaluator {
    int evaluate(String expression);
}

// Utility: Convert Infix to Postfix
class InfixToPostfixConverter {
    private static int precedence(char op) {
        return switch (op) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> 0;
        };
    }

    public static String convert(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char ch : infix.toCharArray()) {
            if (Character.isDigit(ch)) {
                postfix.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    postfix.append(stack.pop());
                stack.pop(); // Remove '('
            } else { // Operator
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek()))
                    postfix.append(stack.pop());
                stack.push(ch);
            }
        }
        while (!stack.isEmpty())
            postfix.append(stack.pop());

        return postfix.toString();
    }
}

// Implementation
class PostfixEvaluator implements ExpressionEvaluator {
    public int evaluate(String expression) {
        String postfix = InfixToPostfixConverter.convert(expression);
        Stack<Integer> stack = new Stack<>();
        for (char ch : postfix.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (ch) {
                    case '+' -> stack.push(a + b);
                    case '-' -> stack.push(a - b);
                    case '*' -> stack.push(a * b);
                    case '/' -> stack.push(a / b);
                }
            }
        }
        return stack.pop();
    }
}

// Demo
public class ExpressionApp {
    public static void main(String[] args) {
        ExpressionEvaluator evaluator = new PostfixEvaluator();
        String expr = "3+(2*4)-5";
        int result = evaluator.evaluate(expr);
        System.out.println("Result: " + result); // Output: 6
    }
}
