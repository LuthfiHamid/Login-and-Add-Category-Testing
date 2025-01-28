package com.belajartestng.pages.authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.time.Duration;

public class SignInPage {

    private WebDriverWait wait;
    private WebDriver driver;

    @FindBy(id = "id_username")
    WebElement usernameElement;

    @FindBy(id = "id_password")
    WebElement passwordElement;

    @FindBy(xpath = "//input[@value='Log in']")
    WebElement buttonSignInElement;

    @FindBy(xpath = "//p[@class='errornote']")
    WebElement errorMessageElement;

    public SignInPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void fillUsername(String username){
        usernameElement.sendKeys(username);
    }

    public void fillPassword(String password){
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton(){
        buttonSignInElement.click();
    }

    public void loginActivity(String username, String password){
        fillUsername(username);
        fillPassword(password);
        clickLoginButton();
    }

    public void waitForGetErrorMessageElement() {
        By locator = By.xpath("//p[@class='errornote']");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public String getErrorMessage() {
        waitForGetErrorMessageElement();
        return errorMessageElement.getText();
    }
}
