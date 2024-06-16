package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;

    //ссылка Войти
    private final By login = By.xpath(".//a[@class='Auth_link__1fOlj']");
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать на ссылку Войти в форме восстановления пароля")
    public void clickLogin() {
        driver.findElement(login).click();
    }
}
