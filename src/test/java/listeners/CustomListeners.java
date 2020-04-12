package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListeners implements ITestListener {


    public void onStart(ITestContext arg) {
        System.out.println("Starts test... " + arg.getName());
    }

    public void onFinish(ITestContext arg) {
        System.out.println("Finish test... " + arg.getName());
    }

    public void onTestStart(ITestResult arg0) {
        System.out.println("Starts test... " + arg0.getName());
    }

    public void onTestSkipped(ITestResult arg0) {
        System.out.println("Skipped test... " + arg0.getName());
    }

    public void onTestSuccess(ITestResult arg0) {
        System.out.println("Passed test... " + arg0.getName());
    }

    public void onTestFailure(ITestResult arg0) {
        System.out.println("Starts test... " + arg0.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

    }

}
