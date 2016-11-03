package modal;

import android.util.Log;
import android.util.StringBuilderPrinter;

import java.util.*;

/**
 * Created by Taban on 11/2/16.
 */


public class CalculatorService {
    // Associativity constants for operators
    private static final int LEFT1 = 0;
    private static final int RIGHT = 1;
    private static CalculatorClass calculatorClass;

    // Operators
    private static final Map<String, int[]> OPERATORS = new HashMap<String, int[]>();

    static {
        // Map<"token", []{precendence, associativity}>
        OPERATORS.put("+", new int[]{0, LEFT1});
        OPERATORS.put("-", new int[]{0, LEFT1});
        OPERATORS.put("*", new int[]{5, LEFT1});
        OPERATORS.put("/", new int[]{5, LEFT1});
        OPERATORS.put("^", new int[]{5, LEFT1});
    }

    //Check for operator
    private static boolean isAnOperator(String token) {

        return OPERATORS.containsKey(token);
    }

    //Association of operator
    private static boolean isAnAssociative(String token, int type) {
        if (!isAnOperator(token)) {
            throw new IllegalArgumentException("Invalid: " + token);
        }

        if (OPERATORS.get(token)[1] == type) {
            return true;
        }
        return false;
    }

    //Precedence operation check
    private static final int compareThePrecedence(String token1, String token2) {
        if (!isAnOperator(token1) || !isAnOperator(token2)) {
            throw new IllegalArgumentException("Invalid: " + token1
                    + " " + token2);
        }
        return OPERATORS.get(token1)[0] - OPERATORS.get(token2)[0];
    }

    //
    private  static String[] changeInfixToRpn(String[] inputTokens) {
        ArrayList<String> out = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();

        for (String token : inputTokens) //for tokens
        {
            if (isAnOperator(token)) //Operator token
            {
                while (!stack.empty() && isAnOperator(stack.peek())) {
                    if ((isAnAssociative(token, LEFT1) &&
                            compareThePrecedence(token, stack.peek()) <= 0) ||
                            (isAnAssociative(token, RIGHT) &&
                                    compareThePrecedence(token, stack.peek()) < 0)) {
                        out.add(stack.pop());
                        continue;
                    }
                    break;
                }
                //Push new operator on stack
                stack.push(token);
            }
            //left bracket '('
            else if (token.equals("(")) {
                stack.push(token);
            }
            //right bracket ')'
            else if (token.equals(")")) {
                while (!stack.empty() && !stack.peek().equals("(")) {
                    out.add(stack.pop());
                }
                stack.pop();
            }
            // If token is a number
            else {
                out.add(token);
            }
        }
        while (!stack.empty()) {
            out.add(stack.pop());
        }
        String[] output = new String[out.size()];
        return out.toArray(output);
    }

    private static double changeFromRpnToDouble(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        calculatorClass = new CalculatorClass();

        //Loop through tokens
        for (String token : tokens) {
            // If the token is a value push it onto the stack
            if (!isAnOperator(token)) {
                stack.push(token);
            } else {
                // Token is an operator: pop top two entries
                Double secondNumber = Double.valueOf(stack.pop());
                Double firstNumber = Double.valueOf(stack.pop());

                //Return a result
                Double result = token.compareTo("+") == 0 ? firstNumber + secondNumber :
                        token.compareTo("-") == 0 ? firstNumber - secondNumber:
                                token.compareTo("*") == 0 ? firstNumber * secondNumber:
                                        token.compareTo("^") == 0 ? calculatorClass.raisedToPowerOf(firstNumber, secondNumber) :
                                                firstNumber / secondNumber;
                //Push to stack
                stack.push(String.valueOf(result));
            }
        }

        return Double.valueOf(stack.pop());
    }

    public static String operation(String str, int counter) {
        String result = "";
        StringBuilder builder = new StringBuilder();
        System.out.print(str.length());
        Log.d("", String.valueOf(str.length() + " " + counter));
        if (counter < str.length()) {
            for(int i = 0; i < str.length(); i++){
                builder.append(str.charAt(i));

            }
            str.substring(1);
            Log.d("", String.valueOf(builder.length() + " " + counter));
            String[] data = str.split("");
            String[] output = CalculatorService.changeInfixToRpn(data);
            try {
                result = String.valueOf(CalculatorService.changeFromRpnToDouble(output));

            } catch (Exception e) {
                System.out.print("Error test: " + e.getMessage());
                result = "Format error eg. ( 1 + 1 )";
            }
        }
        return result;
    }

}
