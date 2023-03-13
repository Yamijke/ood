package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int b) {
        return b - x;
    }

    public int divide(int q) {
        return q / x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int sumAllOperation(int y, int b, int q, int a) {
        int sum = sum(y);
        int minus = minus(b);
        int divide = divide(q);
        int multiply = multiply(a);
        return sum + minus + divide + multiply;
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println(result);
        int result1 = minus(15);
        System.out.println(result1);
        Calculator calculator = new Calculator();
        int result2 = calculator.multiply(5);
        System.out.println(result2);
        Calculator calculator1 = new Calculator();
        int result3 = calculator.divide(5);
        System.out.println(result3);
        Calculator calculator2 = new Calculator();
        int result4 = calculator.sumAllOperation(10, 15, 5, 5);
        System.out.println(result4);
    }
}
