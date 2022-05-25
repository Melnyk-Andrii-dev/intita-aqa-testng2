package org.intita.tests;

import org.intita.enums.elements.editProfilePage.EducationShift;
import org.intita.pages.EditProfilePage;
import org.intita.pages.LoginPage;
import org.intita.pages.ProfilePage;
import org.intita.testsData.ProfileTestData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.Set;

public class ProfileTest extends BaseTest {

    private static final LoginPage loginPage = new LoginPage();
    private static final ProfilePage profilePage = new ProfilePage();
    private static final EditProfilePage editProfilePage = new EditProfilePage();

    @BeforeMethod
    public void openMyProfile() {
        loginPage.headerComponent().clickHeaderLoginButton();
        loginPage.inputEmailToEmailField("student2@qaintita.com");
        loginPage.inputPasswordToPasswordField("qaintita");
        loginPage.clickSignInButton();
        Assert.assertTrue(loginPage.headerComponent().isAvatarButtonDisplayed());
        loginPage.headerComponent().clickAvatarButton();
    }

    @Test(dataProvider = "editProfileTestData", dataProviderClass = ProfileTestData.class)
    public void editProfileTest(Map<String, String> mainFormTextFieldMap,
                                Map<String, String> mainFormSelectorMap,
                                EducationShift shift) {
        Set<Map.Entry<String, String>> mainFormTextFieldEntries = mainFormTextFieldMap.entrySet();
        Set<Map.Entry<String, String>> mainFormSelectorEntries = mainFormSelectorMap.entrySet();

        profilePage.clickEditProfile();
        editProfilePage.selectFirstDayOfCurrentMonthAsDOB();
        for (Map.Entry<String, String> fieldTextEntry :
                mainFormTextFieldEntries) {
            editProfilePage.eraseMainFormTextField(fieldTextEntry.getKey());
            editProfilePage.inputMainFormTextFields(fieldTextEntry.getKey(), fieldTextEntry.getValue());
        }
        for (Map.Entry<String, String> selectorEntry :
                mainFormSelectorEntries) {
            editProfilePage.selectMainFormSelectors(selectorEntry.getKey(), selectorEntry.getValue());
        }
        editProfilePage.chooseEducationShift(shift);
        editProfilePage.clickSubmitButton();

        String shiftString = null;
        if (shift == EducationShift.EVENING) {
            shiftString = "вечірня";
        }

        Assert.assertEquals(profilePage.getAboutme(), mainFormTextFieldMap.get("aboutMy"));
        Assert.assertEquals(profilePage.getInterests(), mainFormTextFieldMap.get("interests"));
        Assert.assertEquals(profilePage.getEducation(), mainFormTextFieldMap.get("education"));
        Assert.assertEquals(profilePage.getInfosource(), mainFormTextFieldMap.get("aboutUs"));
        Assert.assertEquals(profilePage.getSkype(), mainFormTextFieldMap.get("skype"));
        Assert.assertEquals(profilePage.getEducform(), shiftString);
    }

}
