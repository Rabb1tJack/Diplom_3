import Models.UserData;
import Pages.ForgotPasswordPage;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.RegistrationPage;
import Utils.UserApi;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import static Models.Urls.MAIN_PAGE;

public class LoginTests {
    UserApi userApi = new UserApi();

    @Rule
    public DriverRules driverRules = new DriverRules();

    @Test
    public void loginSuccessFromMainPageTest() {
        userApi.createUser(new UserData(UserData.EMAIL, UserData.PASSWORD, UserData.NAME));
        MainPage mainPage = new MainPage(driverRules.getDriver());
        mainPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driverRules.getDriver());
        loginPage.login(UserData.EMAIL, UserData.PASSWORD);
        Assert.assertTrue(mainPage.checkTitle());
    }

    @Test
    public void loginSuccessFromProfileTest() {
        userApi.createUser(new UserData(UserData.EMAIL, UserData.PASSWORD, UserData.NAME));
        driverRules.getDriver().navigate().to(String.format("%s/account", MAIN_PAGE));
        LoginPage loginPage = new LoginPage(driverRules.getDriver());
        loginPage.login(UserData.EMAIL, UserData.PASSWORD);
        MainPage mainPage = new MainPage(driverRules.getDriver());
        Assert.assertTrue(mainPage.checkTitle());
    }

    @Test
    public void loginSuccessFromRegistrationPageTest() {
        userApi.createUser(new UserData(UserData.EMAIL, UserData.PASSWORD, UserData.NAME));
        driverRules.getDriver().navigate().to(String.format("%s/register", MAIN_PAGE));
        RegistrationPage registerPage = new RegistrationPage(driverRules.getDriver());
        registerPage.clickLogin();
        LoginPage loginPage = new LoginPage(driverRules.getDriver());
        loginPage.login(UserData.EMAIL, UserData.PASSWORD);
        MainPage mainPage = new MainPage(driverRules.getDriver());
        Assert.assertTrue(mainPage.checkTitle());
    }

    @Test
    public void loginSuccessFromForgotPasswordPageTest() {
        userApi.createUser(new UserData(UserData.EMAIL, UserData.PASSWORD, UserData.NAME));
        driverRules.getDriver().navigate().to(String.format("%s/forgot-password", MAIN_PAGE));
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driverRules.getDriver());
        forgotPasswordPage.clickLogin();
        LoginPage loginPage = new LoginPage(driverRules.getDriver());
        loginPage.login(UserData.EMAIL, UserData.PASSWORD);
        MainPage mainPage = new MainPage(driverRules.getDriver());
        Assert.assertTrue(mainPage.checkTitle());
    }
}
