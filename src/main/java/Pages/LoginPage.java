package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    private final By emailField = By.xpath(".//input[@class='text input__textfield text_type_main-default' and @name='name']");
    private final By passwordField = By.xpath(".//input[@class='text input__textfield text_type_main-default' and @name='Пароль']");
    private final By loginButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private final By registrationButton = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Зарегистрироваться']");
    private final By resetPassword = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step
    private void setEmailField(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    @Step
    public void login(String email, String password) {
        setEmailField(email);
        setPasswordField(password);
        clickLoginButton();
    }
    @Step
    private void setPasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    @Step
    private void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    @Step
    public void clickRegisterButton() {
        driver.findElement(registrationButton).click();
    }

    public boolean checkTitle() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(loginButton));
        return driver.findElement(loginButton).isDisplayed();
    }

}
