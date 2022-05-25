package org.intita.testsData;

import org.apache.commons.lang3.RandomStringUtils;
import org.intita.enums.elements.registrationPage.IncorrectInputFieldMessage;
import org.intita.enums.elements.registrationPage.SocialMediaRegistration;
import org.testng.annotations.DataProvider;

public class RegistrationTestData {

    @DataProvider(name = "formValidationTestData")
    public Object[][] getData() {
        return new Object[][]{
                {"testNG" + RandomStringUtils.randomNumeric(5, 6) + "@gmail.com", "123", null},
                {"ddcdc11@", "123", IncorrectInputFieldMessage.INCORRECT_EMAIL_MESSAGE},
                {"dddccdc11@gmail.com", "", IncorrectInputFieldMessage.INCORRECT_PASSWORD_MESSAGE}
        };
    }

    @DataProvider(name = "socialMediaRegistrationTestData")
    public Object[][] getData2() {
        return new Object[][]{
                {SocialMediaRegistration.FACEBOOK, "https://www.facebook.com/login.php"},
                {SocialMediaRegistration.LINKEDIN, "https://www.linkedin.com/uas/login"},
                {SocialMediaRegistration.GOOGLE, "https://accounts.google.com/o/oauth2/auth"}
        };
    }
}
