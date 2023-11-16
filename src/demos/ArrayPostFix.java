package demos;

import Stack.ArrayStack;

public class ArrayPostFix {

    public static int evaluatePostfix(String expression) {
       String[] elements = expression.split(" ");
       ArrayStack<Integer> stack = new ArrayStack<>();

       for(String element : elements) {
              if(isNumeric(element)) {
                stack.push(Integer.parseInt(element));
              } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = operation(element, operand1, operand2);
                stack.push(result);
              }
       }
       return stack.pop();
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    private static int operation(String operator, int operand1, int operand2) {
        switch(operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if(operand2 == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }


}
