package ru.scndjk.dsa.Stack;

public class PostfixEvaluator {
    public static Double evalPostfix(String expression) {
        String[] tokens = expression.split("\\s");
        Stack<Double> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("=")) {
                break;
            }

            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                Double b = stack.pop();
                Double a = stack.pop();

                switch (token) {
                    case "+" -> stack.push(a + b);
                    case "-" -> stack.push(a - b);
                    case "*" -> stack.push(a * b);
                    case "/" -> stack.push(a / b);
                }
            } else {
                stack.push(Double.parseDouble(token));
            }
        }

        return stack.pop();
    }

}

