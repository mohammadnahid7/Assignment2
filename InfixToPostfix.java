import java.util.Arrays;

public class InfixToPostfix {

    // This function returns the precedence number of operator in order to compare operator precedence.
    private int precedence(String operator){
        if(operator == null) return 0;
        else if(operator.equals("^")){
            return 3;
        }else if(operator.equals("/") || operator.equals("*")){
            return 2;
        }else if (operator.equals("-") || operator.equals("+")){
            return 1;
        }else return 0;
    }

    // This function returns true if the current character is an operator, otherwise false.
    private boolean isOperator(String character){
        return character.equals("+") || character.equals("-") || character.equals("*") || character.equals("/") || character.equals("^");
    }

    // This method receives infix expression as input and return postfix expression as an array.
    public String[] getPostFixExp(String expression){
        String[] infixArray = expression.split(" ");
        String postFixExp = "";
        ResizedArrayStackOfStrings stack = new ResizedArrayStackOfStrings();
        int infixArrLen = infixArray.length;

        // This variable will be true if the expression is coming from prefix class to check further conditions.
        boolean isPreFix = infixArray[infixArrLen-1].equals("pre");

        for (int i = 0; i < infixArrLen; i++){
            String currentChar = infixArray[i];

            // Just skip the last element if the expression comes from prefix class because it contains only the "pre" tag.
            if (isPreFix && i == infixArrLen-1) break;

            // If the current char is ( then simply push it onto the stack
             if (currentChar.equals("(")) stack.push(currentChar);

             // If the current char is ) then pop all the operators from the stack until ( and discard ( .
            else if (currentChar.equals(")")) {
                while (!stack.peek().equals("(")) postFixExp += stack.pop() + " ";
                stack.pop(); // after popping all operators from the stack until (, just pop the ( and discard it.
            }

            // If the current character is an operator, do the precedence check and then pop or push.
            else if(isOperator(currentChar)){
                while (!stack.isEmpty() && (isPreFix && precedence(stack.peek()) > precedence(currentChar)) || (!isPreFix && precedence(stack.peek()) >= precedence(currentChar))){
                    postFixExp += stack.pop() + " ";
                }
                stack.push(currentChar);
            }

            // Lastly, if the current character is an operand, just print that operand.
            else postFixExp += currentChar + " ";
        }
        
        // popping all the leftover operators from stack
        while (!stack.isEmpty()){
            postFixExp += stack.pop() + " ";
        }
        return postFixExp.trim().split(" ");
    }

    // This method receives infix expression as input and return postfix expression as string.
//    public String getPostFixExpString(String expression){
//        String[] postFixArray = getPostFixExp(expression);
//        return String.join(" ", postFixArray);
//    }

    // This method receives infix expression as input and return evaluated result through postfix expression.

}
