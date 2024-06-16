import Models.UserData;
import Pages.*;
import Utils.UserApi;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import static Models.UserData.*;

public class RegistrationTests {

    UserApi userApi = new UserApi();

    @Rule
    public DriverRules driverRules = new DriverRules();

    @Test
    public void registrationSuccessTest(){
        MainPage mainPage = new MainPage(driverRules.getDriver());
        mainPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driverRules.getDriver());
        loginPage.clickRegisterButton();
        RegistrationPage registrationPage = new RegistrationPage(driverRules.getDriver());
        registrationPage.register(NAME, EMAIL, PASSWORD);
        boolean userCreated = userApi.checkUser(new UserData(EMAIL, PASSWORD)).statusCode() == 200;
        Assert.assertTrue(userCreated);
    }

    @Test
    public void registrationFailedWithIncorrectPasswordTest() {
        MainPage mainPage = new MainPage(driverRules.getDriver());
        LoginPage loginPage = new LoginPage(driverRules.getDriver());
        RegistrationPage registrationPage = new RegistrationPage(driverRules.getDriver());

        mainPage.clickLoginButton();
        loginPage.clickRegisterButton();
        registrationPage.register(NAME, EMAIL, SHORT_PASSWORD);
        Assert.assertTrue(registrationPage.checkInvalidPassword());
    }
}
