package com.belajartestng;

import com.belajartestng.drivers.DriverSingleton;
import com.belajartestng.drivers.utils.BrowserType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class HookTest {


    @BeforeTest
    public void init() {
        System.out.println("init");
        DriverSingleton.getDriver(BrowserType.CHROME);// Inisialisasi DriverSingleton
    }

    @AfterTest
    public void teardown() {
        System.out.println("teardown");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        DriverSingleton.quitDriver();
    }

}
