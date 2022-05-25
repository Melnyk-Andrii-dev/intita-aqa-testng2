package org.intita.pages;

import org.intita.enums.elements.registrationPage.FacebookRegistrationInputFields;
import org.intita.enums.elements.registrationPage.LinkedinRegistrationInputFields;
import org.intita.enums.elements.socialMediaRegistrationPage.GoogleRegistrationInputFields;

public class SocialMediaRegistrationPage extends BasePage {

    private static final String GOOGLE_REGISTRATION_INPUT_FIELD = "//div[@class='Xb9hP']//input[@type='%s']";
    private static final String GOOGLE_CONTINUE_BUTTON = "//span[text()='Далее']";
    private static final String LINKEDIN_REGISTRATION_INPUT_FIELD = "//div[@class='form__input--floating']//input[@type='%s']";
    private static final String LINKEDIN_CONTINUE_BUTTON = "//button[@type='submit']";
    private static final String LINKEDIN_CONFIRMATION_OF_USER_BUTTON = "//button[@id='oauth__auth-form__submit-btn']";
    private static final String FACEBOOK_INPUT_FIELD = "//input[@id='%s']";
    private static final String FACEBOOK_LOGIN_BUTTON = "//button[@id='loginbutton']";
    private static final String FACEBOOK_CONTINUE_AS_BUTTON = "//span[text()='Продолжить как Intita']";
    private static final String LINKED_IN_CONFIRM_BUTTON = "//button[@class='actions__allow']";


    public void inputDataToRegistrationViaGoogle(GoogleRegistrationInputFields field, String data) {
        findElementByXPath(String.format(GOOGLE_REGISTRATION_INPUT_FIELD, field.toString())).sendKeys(data);
    }

    public void clickContinueGoogleButton() {
        findElementByXPath(GOOGLE_CONTINUE_BUTTON).click();
    }

    public String getPageURL() {
        return getDriverThreadLocal().getCurrentUrl();
    }

    public void inputDataToRegistrationViaLinkedIn(LinkedinRegistrationInputFields field, String data) {
        findElementByXPath(String.format(LINKEDIN_REGISTRATION_INPUT_FIELD, field.toString())).sendKeys(data);
    }

    public void clickContinueLinkedinButton() {
        findElementByXPath(LINKEDIN_CONTINUE_BUTTON).click();
    }

    public void confirmationOfUserLinkedinButton() {
        findElementByXPath(LINKEDIN_CONFIRMATION_OF_USER_BUTTON).click();
    }

    public void inputDataToRegistrationViaFacebook(FacebookRegistrationInputFields field, String data) {
        findElementByXPath(String.format(FACEBOOK_INPUT_FIELD, field.toString())).sendKeys(data);
    }

    public void clickLoginFacebookButton() {
        findElementByXPath(FACEBOOK_LOGIN_BUTTON).click();
    }

    public void clickLoginFacebookContinueAsButton() {
        findElementByXPath(FACEBOOK_CONTINUE_AS_BUTTON).click();
    }

    public void clickLinkedInConfirmButton(){
        findElementByXPath(LINKED_IN_CONFIRM_BUTTON).click();
    }
}
