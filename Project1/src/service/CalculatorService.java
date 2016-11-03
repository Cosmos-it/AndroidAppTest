package service;

import java.util.*;

public class CalculatorService {
    private static final int LEFT1 = 0;
    private static final int RIGHT = 1;
    private static CalcFunction clcf;
    // Operators
    private static final Map<String, int[]> OPERATORS = new HashMap<String, int[]>();


    /**
     *
     * Pass a string to be used for the calculation
     *
     * */
    public static String operation(String str) {
        String[] data = str.split(" ");
        String[] output = convertFromInfix(data);
        String result = "";
        try {
            result = String.valueOf(doubleNumber(output));

        } catch (Exception e) {
            System.out.print("Error test: " + e.getMessage());
            result = "Format error eg. ( 1 + 1 )";
        }
        return result;
    }

    //Precedence operation check
    private static final int precedence(String token1, String token2) {
        if (!operator(token1) || !operator(token2)) {
            throw new IllegalArgumentException("Format error: " + token1
                    + " " + token2);
        }
        return OPERATORS.get(token1)[0] - OPERATORS.get(token2)[0];
    }

    static {
        OPERATORS.put("*", new int[]{1, LEFT1});
        OPERATORS.put("^", new int[]{2, LEFT1});
        OPERATORS.put("-", new int[]{3, LEFT1});
        OPERATORS.put("+", new int[]{4, LEFT1});
        OPERATORS.put("/", new int[]{5, LEFT1});
    }


    public static String[] convertFromInfix(String[] stringTokens) {
        ArrayList<String> out = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();

        for (String token : stringTokens) //for tokens
        {
            if (operator(token)) //Operator token
            {
                while (!stack.empty() && operator(stack.peek())) {
                    if ((associativity(token, LEFT1) &&
                            precedence(token, stack.peek()) <= 0) ||
                            (associativity(token, RIGHT) &&
                                    precedence(token, stack.peek()) < 0)) {
                        out.add(stack.pop());
                        continue;
                    }
                    break;
                }
                stack.push(token);
            }
            else if (token.equals("(")) {
                stack.push(token);  //
            }
            else if (token.equals(")")) {
                while (!stack.empty() && !stack.peek().equals("(")) {
                    out.add(stack.pop());
                }
                stack.pop();
            }
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

    public static double doubleNumber(String[] tokens) {
        Stack<String> stack = new Stack<String>();

        // For each token
        for (String token : tokens) {
            if (!operator(token)) {
                stack.push(token);
            } else {
                clcf = new CalcFunction();
                Double two = Double.valueOf(stack.pop());
                Double one = Double.valueOf(stack.pop());

                Double result = token.compareTo("+") == 0 ? clcf.addition(one, two):
                        token.compareTo("-") == 0 ? clcf.subtraction(one, two) :
                                token.compareTo("*") == 0 ? clcf.multiply(one, two) :
                                        token.compareTo("^") == 0 ? clcf.raisedToPowerOf(one, two) :
                                                clcf.divide(one, two);
                stack.push(String.valueOf(result));
            }
        }

        return Double.valueOf(stack.pop());
    }
    //Check for operator
    private static boolean operator(String token) {

        return OPERATORS.containsKey(token);
    }

    public static double expo(double a, double b) {
        return Math.pow(a, b);
    }

    private static boolean associativity(String token, int type) {
        if (!operator(token)) {
            throw new IllegalArgumentException("Format error: " + token);
        }

        if (OPERATORS.get(token)[1] == type) {
            return true;
        }
        return false;
    }


}