package BasicTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AssertionsExample {
    WebDriver driver;

    @BeforeClass
    void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com");
    }

    @Test(priority = 1)
    void logoTest() {
        WebElement logo = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/img"));
        Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed");

    }

    @Test(priority = 2)
    void homePageTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "OrangeHRM", "Title is not matched");
    }

    @Test(priority = 3)
    void tearDown() {
        driver.quit();
    }
}
