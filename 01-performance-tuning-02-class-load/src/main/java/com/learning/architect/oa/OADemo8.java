package com.learning.architect.oa;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.ServiceLoader;

public class OADemo8 {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        Double salary = 15000.00;
        Double money = 0.00;
        // 模拟不停机状态
        while (true) {
            try {
                money = calSalary(salary);
                System.out.println("实际到手Money:" + money);
            } catch (Exception e) {
                System.out.println("加载出现异常 ：" + e.getMessage());
            }
            Thread.sleep(5000);
        }
    }

    private static Double calSalary(Double salary) {
        // 使用 SalaryJARLoader8 来加载的话需要在本项目中添加 SPI 配置
        SalaryJARLoader8 salaryJARLoader = new SalaryJARLoader8(
                "/Users/lijianwei/Documents/personal/codes/architect-learning/salary-caler/target/salary-caler-1.0-SNAPSHOT.jar");
        SalaryCalService salaryService = getSalaryService(salaryJARLoader);
        return salaryService.cal(salary);
    }

    private static SalaryCalService getSalaryService(ClassLoader classLoader) {
        SalaryCalService service = null;
        // ServiceLoader.load(SalaryCalService.class, classLoader);
        ClassLoader c1 = Thread.currentThread().getContextClassLoader();
        try {
            Thread.currentThread().setContextClassLoader(classLoader);
            ServiceLoader<SalaryCalService> services = ServiceLoader.load(SalaryCalService.class, classLoader);
            // 这里只需要拿SPI加载到的第一个实现类
            Iterator<SalaryCalService> iterator = services.iterator();
            if (iterator.hasNext()) {
                service = iterator.next();
            }
        } finally {
            Thread.currentThread().setContextClassLoader(c1);
        }
        return service;
    }

}
