package modal;

import android.util.Log;

import java.util.Locale;

/**
 * Created by Taban on 10/22/16.
 *
 */

public class CalculatorClass {

    public double addition(String a, String b) {

        return (Double.valueOf(a) + Double.valueOf(b));
    }

    public double addition(double a, double b) {

        return (a + b);
    }

    public double subtraction(String a, String b){
        return (Double.valueOf(a) - Double.valueOf(b));
    }

    public double subtraction(double a, double b){
        return (a - b);
    }

    public double divide(String a, String b) {

        return (Double.valueOf(a) / Double.valueOf(b));
    }

    public double divide(double a, double b) {

        return (a / b);
    }


    public double multiply(String a, String b){

        return (Double.valueOf(a) * Double.valueOf(b));
    }

    public double multiply(double a, double b){
        return (a * b);
    }

    public double rasiedToPowerOf(double a, double b){
        return Math.pow(a, b);
    }

    public double operation(String a, String b, String op){

        switch (op){
            case "+": return this.addition(a, b);
            case "-": return this.subtraction(a, b);
            case "x": return this.multiply(a, b);
            case "÷": try {
                return this.divide(a, b);
            } catch (Exception e) {
                Log.d("Calc", e.getMessage());
            }
            default: return -1;

        }
    }

}
