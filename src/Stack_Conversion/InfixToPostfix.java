package Stack_Conversion;

import java.util.Stack;

public class InfixToPostfix {
    public static String InToPost(String infix) {

        StringBuilder postfix = new StringBuilder();
        Stack<Character> operator = new Stack<>();
        char popped;

        for (int i = 0; i < infix.length(); i++) {

            char get = infix.charAt(i);

            if (!isOperator(get)) {
                postfix.append(get);

            }else if (get == ')')
                while ((popped = operator.pop()) != '(')
                    postfix.append(popped);

            else {
                while (!operator.isEmpty() && get != '(' && precedence(operator.peek()) >= precedence(get))
                    postfix.append(operator.pop());

                operator.push(get);
            }
        }
        // pop any remaining operator
        while (!operator.isEmpty())
            postfix.append(operator.pop());

        return postfix.toString();
    }

    private static boolean isOperator(char i) {
        return precedence(i) > 0;
    }

    private static int precedence(char i) {

        if (i == '(' || i == ')') return 1;
        else if (i == '-' || i == '+') return 2;
        else if (i == '*' || i == '/') return 3;
        else return 0;
    }
}
