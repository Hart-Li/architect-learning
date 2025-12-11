package com.learning.architect;

/**
 * @author HartLi
 * @version 1.0.0
 * @desc TODO
 * @date 2025-12-11 18:01
 */
public class EscapeAnalysis {

    public User test1() {
        User user = new User();
        user.setId(1);
        user.setName("HartLi");
        // TODO:保存到数据库
        // 此时 user 返回出了该方法，说明逃逸出去了
        return user;
    }

    public void test2() {
        User user = new User();
        user.setId(1);
        user.setName("HartLi");
        // TODO:保存到数据库
        // 此时 user 还在方法中，说明未逃逸
    }
}
