package com.belajartestng;

public class Calculator {
    public static int add(int a, int b){
        return a + b;
    }

    public static int substract(int a, int b){
        return a - b;
    }

    public static int multiply(int a, int b){
        return a * b;
    }

    public static double divide(int a, int b){
        if (b == 0){
            throw new ArithmeticException("Divide by zero is not allowed");
        }
        return (double) a / b;
    }

    public static int modulo(int a, int b){
        if (b == 0){
            throw new ArithmeticException("Modulo by zero is not allowed");
        }
        return a % b;
    }


}
