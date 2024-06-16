import Pages.MainPage;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class ConstructorTests {
    @Rule
    public DriverRules driverRules = new DriverRules();

    @Test
    public void moveToBunsSectionTest() {
        MainPage mainPage = new MainPage(driverRules.getDriver());
        mainPage.clickFillings();
        mainPage.clickBuns();
        Assert.assertTrue(mainPage.checkActiveSection("Булки"));
    }

    @Test
    public void moveToSaucesSectionTest() {
        MainPage mainPage = new MainPage(driverRules.getDriver());
        mainPage.clickFillings();
        mainPage.clickSauces();
        Assert.assertTrue(mainPage.checkActiveSection("Соусы"));
    }

    @Test
    public void moveToFillingsSectionTest() {
        MainPage mainPage = new MainPage(driverRules.getDriver());
        mainPage.clickFillings();
        Assert.assertTrue(mainPage.checkActiveSection("Начинки"));
    }
}
