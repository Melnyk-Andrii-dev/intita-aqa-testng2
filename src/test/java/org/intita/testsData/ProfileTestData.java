package org.intita.testsData;

import org.intita.enums.elements.editProfilePage.EducationShift;
import org.testng.annotations.DataProvider;

import java.util.HashMap;

public class ProfileTestData {
    @DataProvider(name = "editProfileTestData")
    public Object[][] getData() {
        return new Object[][]{
                {
                        new HashMap<String, String>() {{
                            put("firstName", "Testfirstname");
                            put("secondName", "secondName");
                            put("nickname", "Testnickname");
                            put("address", "Соборна 1а");
                            put("phone", "0123456789");
                            put("aboutMy", "Test About Me");
                            put("interests", "testing");
                            put("education", "Educated");
                            put("prev_job", "none");
                            put("current_job", "IT specialst");
                            put("aboutUs", "Radio");
                            put("skype", "TestSkype");
                            put("facebook", "TestFacebook");
                            put("linkedin", "TestLinkedIn");
                            put("twitter", "TestTwitter");
                        }},
                        new HashMap<String, String>() {{
                            put("address_country", "Україна");
                            put("specializations", "Програмування");
                            put("careers", "Фріланс");
                        }},
                        EducationShift.EVENING,
                }
        };
    }
}
