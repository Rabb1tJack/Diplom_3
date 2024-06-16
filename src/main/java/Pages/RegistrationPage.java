package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;
    private final By nameField = By.xpath(".//fieldset[1]//input[@class='text input__textfield text_type_main-default']");
    private final By emailField = By.xpath(".//fieldset[2]//input[@class='text input__textfield text_type_main-default']");
    private final By passwordField = By.xpath(".//fieldset[3]//input[@class='text input__textfield text_type_main-default']");
    private final By registrationButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text()='Зарегистрироваться']");
    private final By loginButton = By.xpath(".//a[@class='Auth_link__1fOlj']");
    private final By invalidPassword = By.xpath(".//p[@class='input__error text_type_main-default' and text()='Некорректный пароль']");
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step
    public void register(String name, String email, String password) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(registrationButton).click();
    }

    @Step
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean checkInvalidPassword() {new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(invalidPassword));
        return driver.findElement(invalidPassword).isDisplayed();
    }

}
