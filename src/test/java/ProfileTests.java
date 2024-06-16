import Models.UserData;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.ProfilePage;
import Utils.UserApi;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfileTests {
    UserApi userApi = new UserApi();

    @Rule
    public DriverRules driverRules = new DriverRules();

    @Test
    public void enterToProfileFromMainPageTest() {
        userApi.createUser(new UserData(UserData.EMAIL, UserData.PASSWORD, UserData.NAME));

        MainPage mainPage = new MainPage(driverRules.getDriver());
        mainPage.clickProfile();

        LoginPage loginPage = new LoginPage(driverRules.getDriver());
        Assert.assertTrue(loginPage.checkTitle());
        loginPage.login(UserData.EMAIL, UserData.PASSWORD);
        new WebDriverWait(driverRules.getDriver(), Duration.ofSeconds(8)).until(ExpectedConditions.elementToBeClickable(mainPage.getProfile()));
        mainPage.clickProfile();

        ProfilePage profilePage = new ProfilePage(driverRules.getDriver());
        Assert.assertTrue(profilePage.checkProfilePageLoaded());
    }

    @Test
    public void logoutTest() {
        userApi.createUser(new UserData(UserData.EMAIL, UserData.PASSWORD, UserData.NAME));

        MainPage mainPage = new MainPage(driverRules.getDriver());
        mainPage.clickProfile();

        LoginPage loginPage = new LoginPage(driverRules.getDriver());
        Assert.assertTrue(loginPage.checkTitle());

        loginPage.login(UserData.EMAIL, UserData.PASSWORD);
        new WebDriverWait(driverRules.getDriver(), Duration.ofSeconds(8)).until(ExpectedConditions.elementToBeClickable(mainPage.getProfile()));
        mainPage.clickProfile();
        ProfilePage profilePage = new ProfilePage(driverRules.getDriver());
        new WebDriverWait(driverRules.getDriver(), Duration.ofSeconds(8)).until(ExpectedConditions.elementToBeClickable(profilePage.getLogout()));
        profilePage.clickLogout();

        Assert.assertTrue(loginPage.checkTitle());
    }

    @Test
    public void redirectToMainPageClickLogoTest() {
        userApi.createUser(new UserData(UserData.EMAIL, UserData.PASSWORD, UserData.NAME));

        MainPage mainPage = new MainPage(driverRules.getDriver());
        mainPage.clickProfile();

        LoginPage loginPage = new LoginPage(driverRules.getDriver());
        Assert.assertTrue(loginPage.checkTitle());

        loginPage.login(UserData.EMAIL, UserData.PASSWORD);
        mainPage.clickProfile();
        ProfilePage profilePage = new ProfilePage(driverRules.getDriver());
        profilePage.clickLogo();

        Assert.assertTrue(mainPage.checkTitle());
    }

    @Test
    public void redirectToMainPageClickNavElementTest() {
        userApi.createUser(new UserData(UserData.EMAIL, UserData.PASSWORD, UserData.NAME));

        MainPage mainPage = new MainPage(driverRules.getDriver());
        mainPage.clickProfile();

        LoginPage loginPage = new LoginPage(driverRules.getDriver());
        Assert.assertTrue(loginPage.checkTitle());

        loginPage.login(UserData.EMAIL, UserData.PASSWORD);
        mainPage.clickProfile();
        ProfilePage profilePage = new ProfilePage(driverRules.getDriver());
        profilePage.clickConstructorButton();

        Assert.assertTrue(mainPage.checkTitle());
    }
}
