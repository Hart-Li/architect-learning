package com.learning.architect.oa;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class OADemo2 {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        Double salary = 15000.00;
        Double money = 0.00;

        ClassLoader cl = new URLClassLoader(new URL[]{new URL("file:/Users/lijianwei/Documents/personal/codes/architect-learning/salary-caler/target/salary-caler-1.0-SNAPSHOT.jar")});

        //模拟不停机状态
        while (true) {
            try {
                money = calSalary(salary,  cl);
                System.out.println("实际到手Money:" + money);
            }catch(Exception e) {
                System.out.println("加载出现异常 ："+e.getMessage());
            }
            Thread.sleep(5000);
        }
    }

    private static Double calSalary(Double salary, ClassLoader cl)
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException,
        InstantiationException, ClassNotFoundException {
		Class<?> clazz = cl.loadClass("com.learning.architect.oa.SalaryCaler");
        if (clazz != null ) {
            Object obj = clazz.newInstance();
            return (Double) clazz.getMethod("cal", Double.class).invoke(obj, salary);
        }
		return -1.00;
    }

}
