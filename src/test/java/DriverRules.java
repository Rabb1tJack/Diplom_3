import Models.UserData;
import Utils.UserApi;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static Models.Urls.*;
import static Models.UserData.*;

public class DriverRules extends ExternalResource {
    private WebDriver driver;

    @Override
    protected void before() throws Throwable {
        initDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(MAIN_PAGE);
        RestAssured.baseURI = MAIN_PAGE;
    }
    @Override
    protected  void after() {
        driver.quit();
        UserData userData = new UserData(EMAIL, PASSWORD, NAME);
        UserApi userApi = new UserApi();
        Response response = userApi.checkUser(userData);
        int statusCode = response.then().extract().statusCode();
        if (statusCode == 200) {
            String token = response.then().extract().path("accessToken");
            userApi.deleteUser(token).asString();
        }
    }
    public void initDriver() {
        if ("yandex".equals(System.getProperty("browser"))) {
            initYandex();
        }
        else {
            initChrome();
        }
    }
    private void initYandex() {
        WebDriverManager.chromedriver().driverVersion(System.getProperty("version")).setup();

        var options = new ChromeOptions();
        options.setBinary(System.getProperty("webdriver"));

        driver = new ChromeDriver(options);
    }
    private void initChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
