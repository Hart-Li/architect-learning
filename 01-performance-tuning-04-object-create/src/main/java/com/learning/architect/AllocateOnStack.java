package com.learning.architect;

/**
 * @author HartLi
 * @version 1.0.0
 * @desc TODO
 * @date 2025-12-11 18:05
 */

/**
 * 栈上分配，标量替换
 * 代码调用了1亿次allocate()方法，如果分配到堆上，大概需要1G以上的空间，如果堆空间小于该值，必然会触发GC。
 *
 * 使用如下参数不会发生 GC
 * -Xmx15m -Xms15m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:+EliminateAllocations
 * 使用如下参数会发生大量 GC
 * -Xmx15m -Xms15m -XX:-DoEscapeAnalysis -XX:+PrintGC -XX:+EliminateAllocations
 * -Xmx15m -Xms15m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-EliminateAllocations
 */
public class AllocateOnStack {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            allocate();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }

    private static void allocate() {
        User user = new User();
        user.setId(1);
        user.setName("HartLi");
    }
}
