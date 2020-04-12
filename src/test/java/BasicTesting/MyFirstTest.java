package BasicTesting;

import org.testng.annotations.Test;

public class MyFirstTest {

    @Test(priority = 1)
    void setup() {
        System.out.println("Opening Browser");
    }

    @Test(priority = 2)
    void login() {
        System.out.println("This is login test");
    }

    @Test(priority = 3)
    void teardown() {
        System.out.println("closing browser");
    }
}
