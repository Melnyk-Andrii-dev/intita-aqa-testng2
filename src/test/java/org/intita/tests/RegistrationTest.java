package org.intita.tests;

import org.intita.enums.elements.registrationPage.IncorrectInputFieldMessage;
import org.intita.enums.elements.registrationPage.RegistrationCredentials;
import org.intita.enums.elements.registrationPage.SocialMediaRegistration;
import org.intita.pages.LoginPage;
import org.intita.pages.RegistrationPage;
import org.intita.pages.SocialMediaRegistrationPage;
import org.intita.testsData.RegistrationTestData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    private static final LoginPage loginPage = new LoginPage();
    private static final RegistrationPage registrationPage = new RegistrationPage();
    private static final SocialMediaRegistrationPage socialMediaRegistrationPage = new SocialMediaRegistrationPage();


    private static final String SUCCESS_REGISTRATION_INDICATOR = "На вашу електронну адресу було відправлено листа з інструкціями щодо активації облікового запису. Після отримання листа по електронній пошті, потрібно відвідати URL, вказаний у листі, щоб активувати свій аккаунт. Якщо лист з активацією не прийшов, перевірте папку Спам.";

    @BeforeMethod
    public void openLoginForm() {
        loginPage.headerComponent().clickHeaderLoginButton();
        loginPage.clickSignUpButton();
    }

    @Test(dataProvider = "formValidationTestData", dataProviderClass = RegistrationTestData.class)
    public void registrationFormTest(String email, String password, IncorrectInputFieldMessage expectedError) {
        registrationPage.inputDataToRegistrationField(RegistrationCredentials.EMAIL, email);
        registrationPage.inputDataToRegistrationField(RegistrationCredentials.PASSWORD, password);
        registrationPage.clickStartButton();
        if (expectedError == null) {
            Assert.assertEquals(registrationPage.getConfirmEmailMessage().trim(), SUCCESS_REGISTRATION_INDICATOR);
        } else {
            Assert.assertTrue(registrationPage.getWarningInvalidEmailMessage(expectedError));
        }
    }

    @Test(dataProvider = "socialMediaRegistrationTestData", dataProviderClass = RegistrationTestData.class)
    public void registrationWith3PITest(SocialMediaRegistration socialMedia, String expectedUrl) {
        registrationPage.clickSocialMediaRegistration(socialMedia);
        String actualURL = socialMediaRegistrationPage.getPageURL();
        System.out.println("ACTUAL URL: " + actualURL);
        System.out.println("EXPECTED URL: " + expectedUrl);
        Assert.assertTrue(actualURL.contains(expectedUrl));
    }

}