package com.learning.architect;

/**
 * @author HartLi
 * @version 1.0.0
 * @desc TODO
 * @date 2025-12-09 20:01
 */
public class Math {

    public static void main(String[] args) {
        int result = compute(1, 2);
        System.out.println(result);
    }

    public static int compute(int a, int b) {
        int c = (a + b) * 10;
        return c;
    }
}
