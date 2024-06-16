package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private WebDriver driver;
    private final By constructorButton = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Конструктор']");
    private final By stellarBurgersLogo = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    private final By logout = By.xpath(".//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive' and text()='Выход']");
    private final By userDataLink = By.xpath(".//li/a[@href='/account/profile']");
    private final By orderHistoryLink = By.xpath(".//li/a[@href='/account/order-history']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    @Step
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step
    public void clickLogo() {
        driver.findElement(stellarBurgersLogo).click();
    }

    public By getLogout() {
        return logout;
    }

    @Step
    public void clickLogout() {
        driver.findElement(logout).click();
    }

    public boolean checkProfilePageLoaded() {
        new WebDriverWait(driver, Duration.ofSeconds(8)).until(ExpectedConditions.elementToBeClickable(logout));
        new WebDriverWait(driver, Duration.ofSeconds(8)).until(ExpectedConditions.elementToBeClickable(userDataLink));
        new WebDriverWait(driver, Duration.ofSeconds(8)).until(ExpectedConditions.elementToBeClickable(orderHistoryLink));

        return   driver.findElement(logout).isDisplayed()
                && driver.findElement(userDataLink).isDisplayed()
                && driver.findElement(orderHistoryLink).isDisplayed();
    }

}
