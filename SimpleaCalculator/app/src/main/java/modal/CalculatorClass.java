package modal;

import android.util.Log;

import java.util.Locale;

/**
 * Created by Taban on 10/22/16.
 *
 */

public class CalculatorClass {

    public double addition(double a, double b) {

        return (a + b);
    }

    public double subtraction(double a, double b){
        return (a - b);
    }

    public double divide(double a, double b) {

        return (a / b);
    }


    public double multiply(double a, double b){
        return (a * b);
    }

    public double raisedToPowerOf(double a, double b){
        return Math.pow(a, b);
    }


}
