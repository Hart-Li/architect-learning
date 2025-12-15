package com.learning.architect;

/**
 * @author HartLi
 * @version 1.0.0
 * @desc TODO
 * @date 2025-12-15 16:49
 */
/**
 * 垃圾收集之三色标记
 */
public class ThreeColorRemark {
    A a = new A();
    // 开始做并发标记
    D d = a.b.d;  // 读
    // 编译不通过，先临时注释掉
//    a.b.d = null; // 写
//    a.d = d;      // 写

}

class A {
    B b = new B();
    D d = null;
}

class B {
    C c = new C();
    D d = new D();
}

class C {

}

class D {

}