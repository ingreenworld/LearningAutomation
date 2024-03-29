package BasicTesting;

import org.testng.annotations.Test;

public class GroupingExample {

    @Test(groups = {"sanity"})
    void test1() {
        System.out.println("This is Test");
    }

    @Test(groups = {"sanity"})
    void test2() {
        System.out.println("This is Test 2");
    }

    @Test(groups = {"regression"})
    void test3() {
        System.out.println("This is Test 3");
    }

    @Test(groups = {"regression"})
    void test4() {
        System.out.println("This is Test 4");
    }

    @Test(groups = {"sanity", "regression"})
    void test5() {
        System.out.println("This is Test 5");
    }
}
