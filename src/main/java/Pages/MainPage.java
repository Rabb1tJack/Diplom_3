package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;

    private final By loginButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");

    public By getProfile() {
        return profile;
    }

    private final By profile = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет']");
    private final By buns = By.xpath(".//span[text()='Булки']");
    private final By sauces = By.xpath(".//span[text()='Соусы']");
    private final By fillings = By.xpath(".//span[text()='Начинки']");
    private final By getOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step
    public void clickProfile() {
        driver.findElement(profile).click();
    }

    @Step
    public void clickBuns() {
        driver.findElement(buns).click();
    }

    @Step
    public void clickSauces() {
        driver.findElement(sauces).click();
    }

    @Step
    public void clickFillings() {
        driver.findElement(fillings).click();
    }

    public boolean checkTitle() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(getOrderButton));
        return driver.findElement(getOrderButton).isDisplayed();
    }

    @Step
    public boolean checkActiveSection(String section) {
        boolean tabActive = driver
                .findElement(By.xpath(String.format(".//span[text()='%s']/parent::div[1]", section)))
                .getAttribute("class")
                .contains("tab_tab_type_current__");

        boolean sectionHeaderDisplayed = driver
                .findElement(By.xpath(String.format(".//h2[text()='%s']", section)))
                .isDisplayed();

        return tabActive && sectionHeaderDisplayed;
    }
}
