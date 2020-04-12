package BasicTesting;

import org.testng.annotations.*;

public class TC1 {
    @BeforeClass
    void beforeClass() {
        System.out.println("This is beforeClass..");
    }

    @AfterClass
    void afterClass() {
        System.out.println("This is afterClass..");
    }

    @BeforeMethod
    void beforeMethod() {
        System.out.println("This is beforeMethod..");
    }

    @AfterMethod
    void afterMethod() {
        System.out.println("This is afterMethod..");
    }

    @Test
    void test1() {
        System.out.println("This is test1..");
    }

    @Test
    void test2() {
        System.out.println("This is test2..");
    }

    @BeforeTest
    void beforeTest() {
        System.out.println("This is beforeTest..");
    }

    @AfterTest
    void AfterTest() {
        System.out.println("This is afterTest..");
    }

    @BeforeSuite
    void beforeSuit() {
        System.out.println("This is beforeSuite..");
    }

    @AfterSuite
    void afterSuite() {
        System.out.println("This is afterSuite..");
    }
}
