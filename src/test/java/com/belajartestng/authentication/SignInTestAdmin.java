package com.belajartestng.authentication;

import com.belajartestng.drivers.DriverSingleton;
import com.belajartestng.pages.authentication.DashboardPage;
import com.belajartestng.pages.authentication.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SignInTestAdmin {
    private SignInPage signInPage;
    private DashboardPage dashboardPage;
    private WebDriver driver;

    @BeforeClass
    public void setup() {

        driver = DriverSingleton.driver;
    }

    @DataProvider(name = "testMethods")
    public Object[][] data() {
        return new Object[][] {
                {"signInTestNegative"},
                {"signInTest"},
                {"testAddCategorys"}
        };
    }

    @Test(dataProvider = "testMethods")
    public void runTest(String testName) throws InterruptedException {
        switch (testName) {

            // Test Login Negative
            case "signInTestNegative":
                driver.get("http://localhost:8000/admin");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                signInPage = new SignInPage(driver);
                signInPage.loginActivity("admin", "qwe");// Login dengan kredensial yang salah

                String errorMessage = signInPage.getErrorMessage();
                Assert.assertTrue(errorMessage.contains("Please enter the correct username and password for a staff account. Note that both fields may be case-sensitive."));

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                break;

            // Test Login
            case "signInTest":
                driver.get("http://localhost:8000/admin");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                signInPage = new SignInPage(driver);
                signInPage.loginActivity("admin", "qwe123");

                dashboardPage = new DashboardPage(driver);


                String expected = "Welcome to Demo SQA Testing Portal";
                String actual = dashboardPage.getTextWelocmeHeadingElement();

                // Assert.assertTrue(actual.toLowerCase().equals(expected.toLowerCase()));
                Assert.assertEquals(actual.toLowerCase(), expected.toLowerCase());

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                dashboardPage.clickLogout();

                break;

            // Test Add Categorys
            case "testAddCategorys":

                driver.get("http://localhost:8000/admin");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                signInPage = new SignInPage(driver);
                signInPage.loginActivity("admin", "qwe123");

                dashboardPage = new DashboardPage(driver);

                dashboardPage.clickAddCategory("soto");
                dashboardPage.waitForCategoryAdded();



                String expectedUrl = "http://localhost:8000/admin/products/category/";
                String actualUrl = driver.getCurrentUrl();
                Assert.assertEquals(actualUrl, expectedUrl);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                throw new RuntimeException(e);
                }

                driver.quit();

        }
    }
}
