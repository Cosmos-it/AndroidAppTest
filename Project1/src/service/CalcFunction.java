package service;

/**
 * Created by Taban on 11/2/16.
 */


public class CalcFunction {
    double addition(Double a, Double b) {
        return (a + b);
    }

    double subtraction(Double a, Double b){
        return (a - b);
    }

    double divide(Double a, Double b) {

        return (a / b);
    }


    double multiply(Double a, Double b){
        return (a * b);
    }

    double raisedToPowerOf(Double a, Double b){
        return Math.pow(a, b);
    }

}
