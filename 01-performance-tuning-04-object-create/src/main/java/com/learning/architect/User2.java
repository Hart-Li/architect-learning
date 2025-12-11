package com.learning.architect;

/**
 * @author HartLi
 * @version 1.0.0
 * @desc TODO
 * @date 2025-12-11 21:04
 */
public class User2 {

    private int id;
    private String name;

    public User2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
