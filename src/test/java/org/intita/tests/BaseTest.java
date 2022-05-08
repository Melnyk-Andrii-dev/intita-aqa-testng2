package org.intita.tests;

import lombok.Getter;
import org.intita.pages.BasePage;
import org.intita.testUtils.SetupUtil;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static final String SAUCELAB_ACCESS = "https://oauth-sao2099-6f890:945bc1c2-dda6-4ef2-ab8e-a1855009d2b7@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    @Getter
    private WebDriver driver;

    private WebDriver inicializeDriver(String platform, String browser, String version, String viewport)
            throws MalformedURLException {
        WebDriver driver = null;
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("screenResolution", "1920x1080");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("sauce:options", sauceOptions);
        Capabilities capabilities = SetupUtil.getCapabilities(platform, browser, version, viewport);
        driver = new RemoteWebDriver(new URL(SAUCELAB_ACCESS), capabilities);
        return driver;
    }

    @Parameters({"platform", "browser", "version", "viewport", "url"})
    @BeforeMethod(alwaysRun = true)
    public void setup(String platform, String browser, String
            version, String viewport, String url) throws MalformedURLException {
        driver = inicializeDriver(platform, browser, version, viewport);
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        BasePage.setDriverThreadLocal(driver);
    }

    @AfterMethod
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}

