package com.learning.architect;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author HartLi
 * @version 1.0.0
 * @desc TODO
 * @date 2025-12-11 21:03
 */
public class FinalizeTest {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (true) {
            list.add(new User2(i++, UUID.randomUUID().toString()));
            new User2(j--, UUID.randomUUID().toString());
        }

    }
}
