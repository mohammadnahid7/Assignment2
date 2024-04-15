import java.util.Arrays;

public class InfixToPrefix {

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
    public String[] getPreFixExp(String expression){
        expression = "pre " + expression;
        String[] infixArray = reverse(expression.split(" "));
        InfixToPostfix infixToPostfix = new InfixToPostfix();
        String[] postFixExp = infixToPostfix.getPostFixExp(String.join(" ", infixArray));
        postFixExp = reverse(postFixExp);
        return postFixExp;
    }
//    public String getPreFixExpString(String expression){
//        String[] preFixArray = getPreFixExp(expression);
//        return String.join(" ", preFixArray);
//    }
}
