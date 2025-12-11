package com.learning.architect;

/**
 * @author HartLi
 * @version 1.0.0
 * @desc TODO
 * @date 2025-12-11 20:12
 */
public class ReferenceCountGc {

    Object instance = null;

    public static void main(String[] args) {
        ReferenceCountGc objA = new ReferenceCountGc();
        ReferenceCountGc objB = new ReferenceCountGc();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
    }
}
