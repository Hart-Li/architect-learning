package com.learning.architect.cinit;

/**
 * @author HartLi
 * @version 1.0.0
 * @desc TODO
 * @date 2025-12-08 21:51
 */

class Apple03 {
    static double price = 20.00;
    static Apple03 apple = new Apple03(10);
    double totalpay;

    public Apple03(double discount) {
        System.out.println("====" + price);
        totalpay = price - discount;
    }
}

public class PriceTest03 {

    public static void main(String[] args) {
        System.out.println(Apple03.apple.totalpay);
    }
}
