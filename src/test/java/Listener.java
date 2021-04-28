import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class Listener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName() + " with parameters: \n"
                + Arrays.toString(result.getParameters()) + " STARTED!");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName() + " with parameters: \n"
                + Arrays.toString(result.getParameters()) + " SUCCEED!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName() + " with parameters: \n"
                + Arrays.toString(result.getParameters()) + " FAILED!");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getName() + " with parameters: \n"
                + Arrays.toString(result.getParameters()) + " SKIPPED!");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println(result.getName() + " with parameters: \n"
                + Arrays.toString(result.getParameters()) + " TIMEOUT FAIL!");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println(context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println(context.getName());
    }
}
