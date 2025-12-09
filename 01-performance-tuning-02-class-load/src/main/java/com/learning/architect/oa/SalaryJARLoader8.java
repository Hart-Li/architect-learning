package com.learning.architect.oa;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureClassLoader;

/**
 * @author HartLi
 * @version 1.0.0
 * @desc TODO
 * @date 2025-12-09 15:28
 */
public class SalaryJARLoader8 extends SecureClassLoader {

    private final String jarPath;

    public SalaryJARLoader8(String jarPath) {
        this.jarPath = jarPath;
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        // 报错 java.io.FileNotFoundException: JAR entry java/lang/Object.myclass
        if (!name.startsWith("com.learning.architect.oa.impl")) {
            return super.loadClass(name, resolve);
        }

        synchronized (getClassLoadingLock(name)) {
            // First, check if the class has already been loaded
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                c = findClass(name);
                if (c == null) {
                    c = super.loadClass(name);
                }
            }
            return c;
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] b = loadClassData(name);
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassData(String name) {
        String classFilePath = name.replace(".", "/").concat(".class");
        System.out.println("classFilePath:" + classFilePath);
        try {
            int code;
            URL jarFile = new URL("jar:file:" + jarPath + "!/" + classFilePath);
            URLConnection urlConnection = jarFile.openConnection();
            // 不使用缓存 不然有些操作系统下会出现jar包无法更新的情况
            urlConnection.setUseCaches(false);
            InputStream is = urlConnection.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            is.read(); // 先读取一个二进制码
            while ((code = is.read()) != -1) {
                baos.write(code);
            }
            // 将 baos 转成 bytes 数组
            return baos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
