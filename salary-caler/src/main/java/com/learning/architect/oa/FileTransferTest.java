package com.learning.architect.oa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author HartLi
 * @version 1.0.0
 * @desc TODO
 * @date 2025-12-09 15:13
 */
public class FileTransferTest {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("/Users/lijianwei/Documents/personal/codes/architect-learning/salary-caler/target/classes/com/learning/architect/oa/SalaryCaler.class");
            FileOutputStream fos = new FileOutputStream("/Users/lijianwei/Documents/personal/codes/architect-learning/salary-caler/target/classes/com/learning/architect/oa/SalaryCaler.myclass");
            fos.write(1);
            int code;
            while ((code = fis.read()) != -1) {
                fos.write(code);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
