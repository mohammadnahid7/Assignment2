import java.util.Arrays;

public class Evaluate {
    private boolean isOperator(String character){
        return character.equals("+") || character.equals("-") || character.equals("*") || character.equals("/") || character.equals("^");
    }

    private String[] reverse(String[] s){
        String newS = "";
        for (int i = s.length-1; i >= 0; i--){
            String current = s[i];
            if (current.equals("(")) current = ")";
            else if (current.equals(")")) current = "(";
            newS += current + " ";
        }
        return newS.split(" ");
    }

    public int getEvalResult(String[] expression){
        boolean isPreFix = isOperator(String.valueOf(expression[0]));
        String[] expressionArr = isPreFix ? reverse(expression) : expression;
        ResizedArrayStackOfStrings stack = new ResizedArrayStackOfStrings();

        for (int i = 0; i < expressionArr.length; i++){
            String currentChar = expressionArr[i];
            // If the current character is operand, just push onto the stack.
            if(!isOperator(currentChar)) stack.push(currentChar);

            // If the current character is operator, pop two operands and do operation accordingly.
            else{
                int a, b;
                if(isPreFix){
                    a = Integer.parseInt(stack.pop());
                    b = Integer.parseInt(stack.pop());
                }else {
                    b = Integer.parseInt(stack.pop());
                    a = Integer.parseInt(stack.pop());
                }

                if(currentChar.equals("+")) stack.push(String.valueOf(a + b));
                else if(currentChar.equals("-")) stack.push(String.valueOf(a - b));
                else if(currentChar.equals("*")) stack.push(String.valueOf(a * b));
                else if(currentChar.equals("/")) stack.push(String.valueOf(a / b));
                else if(currentChar.equals("^")) stack.push(String.valueOf((int) Math.pow(a, b)));
            }
        }
        return Integer.parseInt(stack.pop());
    }



}
