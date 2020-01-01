package login;

import base.BaseTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test(priority = 1, groups = "smoke, regression")
    public void testSuccessfulLogin() {
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        assertTrue(secureAreaPage.getAlertText()
                        .contains("You logged into a secure area!"),
                "Alert text is incorrect");
    }

    @Test(priority = 2, groups = "smoke, regression", dataProvider = "logInData")
    public void testUnsuccessfulLogin(String username, String password) {
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        assertTrue(secureAreaPage.getAlertText()
                        .contains("Your username is invalid!"),
                "Alert text is incorrect");
    }

    @DataProvider
    public Object[][] logInData() {
        Object[][] data = new Object[2][2];

        data[0][0] = "TestNG@Framework.com";
        data[0][1] = "TestNG1234";
        data[1][0] = "Joe@Doe.com";
        data[1][1] = "DoeDoe34";

        return data;
    }
}
