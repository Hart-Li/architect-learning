package com.learning.architect.cinit;

/**
 * @author HartLi
 * @version 1.0.0
 * @desc TODO
 * @date 2025-12-08 21:51
 */

class Apple02 {
    static Apple02 apple = new Apple02(10);
    final static double price = 20.00;
    double totalpay;

    public Apple02(double discount) {
        System.out.println("====" + price);
        totalpay = price - discount;
    }
}

public class PriceTest02 {

    public static void main(String[] args) {
        System.out.println(Apple02.apple.totalpay);
    }
}
