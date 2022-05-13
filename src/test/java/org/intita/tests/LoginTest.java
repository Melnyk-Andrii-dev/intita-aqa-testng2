package org.intita.tests;

import org.intita.pages.LoginPage;
import org.intita.tests.BaseTest;
import org.intita.testsData.LoginTestData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private static final LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void openLoginForm() {
        loginPage.headerComponent().clickHeaderLoginButton();
    }

    @Test(dataProvider = "credentialsTestData", dataProviderClass = LoginTestData.class)
    public void loginFormTest(String email, String password, String expectedErrorMessage) {
        loginPage.inputEmailToEmailField(email);
        loginPage.inputPasswordToPasswordField(password);
        loginPage.clickSignInButton();
        if (expectedErrorMessage == null) {
            Assert.assertTrue(loginPage.headerComponent().isStartPageVisible());
        } else {
            Assert.assertFalse(loginPage.headerComponent().isStartPageVisible());
            Assert.assertEquals(loginPage.getIncorrectEmailOrPasswordDisplayedMessage(), expectedErrorMessage);
        }
    }

}
