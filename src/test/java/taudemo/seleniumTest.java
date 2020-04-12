package taudemo;

import browser.BrowserGetter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class seleniumTest {
    private browser.BrowserGetter browserGetter = new BrowserGetter();
    private WebDriver driver;


    @BeforeAll
    public void beforeAll() {
        driver = browserGetter.getChromeDriver();

    }

    @AfterAll
    public void afterAll() {

        driver.quit();

    }

    @Test
    public void openTheComPageAndCheckTheTitle() {
        String expectedComTitle = "Example Title";
        driver.get("https://example.com");
        assertEquals(expectedComTitle, driver.getTitle());
    }

    @Test
    public void openTheOrgPageAndCheckTheTitle2() {
        String expectedOrgTitle = "Example Title";
        driver.get("https://example.org");
        assertEquals(expectedOrgTitle, driver.getTitle());
    }
}
