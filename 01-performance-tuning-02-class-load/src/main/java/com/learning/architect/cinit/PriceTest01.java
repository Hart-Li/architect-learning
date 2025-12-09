package com.learning.architect.cinit;

/**
 * @author HartLi
 * @version 1.0.0
 * @desc TODO
 * @date 2025-12-08 21:51
 */

class Apple {
    static Apple apple = new Apple(10);
    static double price = 20.00;
    double totalpay;

    public Apple(double discount) {
        System.out.println("====" + price);
        totalpay = price - discount;
    }
}

public class PriceTest01 {

    public static void main(String[] args) {
        System.out.println(Apple.apple.totalpay);
    }
}
