package com.belajartestng.pages.authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DashboardPage {
    private WebDriver driver;

    @FindBy(xpath = "//h1[normalize-space()='Welcome to Demo SQA Testing Portal']")
    private WebElement welcomeHeadingElement;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement logoutButton;

    @FindBy(xpath = "//a[normalize-space()='Categorys']")
    private WebElement categorysElement;

    @FindBy(xpath = "//*[@id=\"content-main\"]/div[2]/table/tbody/tr[1]/td[1]/a")
    private WebElement addCategoryElement;

    @FindBy(id = "id_name")
    private WebElement nameInputField;

    @FindBy(xpath = "//input[@name='_save']")
    private WebElement saveButton;

    @FindBy(xpath = "//a[normalize-space()='Add category']")
    private WebElement addCategoryButton;

    private WebDriverWait wait;
    private WebElement setAddCategoryButton;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void waitForWelcomeHeadingElement() {
        By locator = By.xpath("//h1[normalize-space()='Welcome to Demo SQA Testing Portal']");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public String getTextWelocmeHeadingElement() {
        waitForWelcomeHeadingElement();
        return welcomeHeadingElement.getText();
    }

    public void clickLogout() {
        logoutButton.click();
    }

    public void waitForcategorysElement() {
        By locator = By.xpath("//a[normalize-space()='Categorys']");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public String GetTextCategoryElement() {
        waitForcategorysElement();
        return categorysElement.getText();
    }

    public void setNameInputField(String input) {
        nameInputField.clear();
        nameInputField.sendKeys(input);
    }

    public void waitForCategoryAdded() {
        By locator = By.xpath("//li[@class='success']");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }


    public void clickAddCategory(String categoryName) throws InterruptedException{

        addCategoryElement.click();
        setNameInputField(categoryName);
        saveButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='success']")));

        TimeUnit.SECONDS.sleep(2);

        addCategoryButton.click();
        setNameInputField("mie ayam");
        saveButton.click();

    }
}
