package com.learning.architect;

/**
 * @author HartLi
 * @version 1.0.0
 * @desc TODO
 * @date 2025-12-09 20:57
 */
public class StackOverflowTest {

    static int count = 0;

    public static void redo() {
        count ++;
        redo();
    }

    public static void main(String[] args) {
        try {
            redo();
        } catch (Throwable e) {
            System.out.println("count:" + count);
            e.printStackTrace();
        }
    }
}
