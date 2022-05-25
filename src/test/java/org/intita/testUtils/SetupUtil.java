package org.intita.testUtils;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

import java.util.HashMap;
import java.util.Map;

public class SetupUtil {

    private static final String DEFAULT_WINDOWS_VERSION = "Windows 10";
    private static final String DEFAULT_MAC_VERSION = "macOS 11.00";

    public static Capabilities getCapabilities(String platform, String browser, String version, String viewPort) {
        Map<String, Object> sauceOptions;
        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                sauceOptions = new HashMap<>();
                sauceOptions.put("screenResolution", viewPort);
                chromeOptions.setCapability("sauce:options", sauceOptions);
                chromeOptions.setCapability("browserVersion", version);
                if (platform.equalsIgnoreCase("Windows")) {
                    chromeOptions.setCapability("platformName", DEFAULT_WINDOWS_VERSION);
                }
                if (platform.equalsIgnoreCase("Mac")) {
                    chromeOptions.setCapability("platformName", DEFAULT_MAC_VERSION);
                }
                return chromeOptions;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                sauceOptions = new HashMap<>();
                sauceOptions.put("screenResolution", viewPort);
                firefoxOptions.setCapability("sauce:options", sauceOptions);
                firefoxOptions.setCapability("browserVersion", version);
                if (platform.equalsIgnoreCase("Windows")) {
                    firefoxOptions.setCapability("platformName", DEFAULT_WINDOWS_VERSION);
                }
                if (platform.equalsIgnoreCase("Mac")) {
                    firefoxOptions.setCapability("platformName", DEFAULT_MAC_VERSION);
                }
                return firefoxOptions;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                sauceOptions = new HashMap<>();
                sauceOptions.put("screenResolution", viewPort);
                edgeOptions.setCapability("sauce:options", sauceOptions);
                edgeOptions.setCapability("browserVersion", version);
                if (platform.equalsIgnoreCase("Windows")) {
                    edgeOptions.setCapability("platformName", DEFAULT_WINDOWS_VERSION);
                }
                if (platform.equalsIgnoreCase("Mac")) {
                    edgeOptions.setCapability("platformName", DEFAULT_MAC_VERSION);
                }
                return edgeOptions;
            case "safari":
                SafariOptions safariOptions = new SafariOptions();
                sauceOptions = new HashMap<>();
                sauceOptions.put("screenResolution", viewPort);
                safariOptions.setCapability("sauce:options", sauceOptions);
                safariOptions.setCapability("browserVersion", version);
                if (platform.equalsIgnoreCase("Windows")) {
                    safariOptions.setCapability("platformName", DEFAULT_WINDOWS_VERSION);
                }
                if (platform.equalsIgnoreCase("Mac")) {
                    safariOptions.setCapability("platformName", DEFAULT_MAC_VERSION);
                }
                return safariOptions;
            default:
                return null;
        }
    }
}
