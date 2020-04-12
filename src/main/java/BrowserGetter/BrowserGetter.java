package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.System.setProperty;
import static org.apache.commons.lang3.SystemUtils.*;

public class BrowserGetter {

    public WebDriver getChromeDriver() {
        /**
         *          detect operating system
         *          if it is not one of the predefined ones, just throw exception
         *          only create a webDriver instance for a known operating system
         */

        if (!IS_OS_WINDOWS && !IS_OS_LINUX && !IS_OS_MAC) {
            throw new RuntimeException("Could not initialize browser due to unknown operating system!");
        }
        if (IS_OS_WINDOWS) {
            setProperty("webdriver.chrome.driver", "src/test/resources/browsers/chromedriver.exe");
        }
        if (IS_OS_LINUX) {
            setProperty("webdriver.chrome.driver", "src/test/resources/browsers/chromedriver");
        }
        if (IS_OS_MAC) {
            setProperty("webdriver.chrome.driver", "src/test/resources/browsers/chromedriverMac");
        }

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver getFireFox() {
        /**
         *          detect operating system
         *          if it is not one of the predefined ones, just throw exception
         *          only create a webDriver instance for a known operating system
         */

        if (!IS_OS_WINDOWS && !IS_OS_LINUX && !IS_OS_MAC) {
            throw new RuntimeException("Could not initialize browser due to unknown operating system!");
        }
        if (IS_OS_WINDOWS) {
            setProperty("webdriver.chrome.driver", "src/test/resources/browsers/geckodriver.exe");
        }
        if (IS_OS_LINUX) {
            setProperty("webdriver.chrome.driver", "src/test/resources/browsers/geckodriver");
        }
        if (IS_OS_MAC) {
            setProperty("webdriver.chrome.driver", "src/test/resources/browsers/geckodriver");
        }

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }
}