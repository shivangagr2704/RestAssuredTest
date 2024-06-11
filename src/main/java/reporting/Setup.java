package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class Setup implements ITestListener {

    private static ExtentReports extentReports;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public void onStart(ITestContext context) {
        String fileName = ExtentReportManager.getReportNameWithTimestamp();
        String fullReportPath = System.getProperty("user.dir") + "/reports/" + fileName;
        extentReports = ExtentReportManager.createInstance(fullReportPath,"Test API Automation Report", "Test Execution");
    }

    public void onFinish(ITestContext context) {
        if(extentReports != null){
            extentReports.flush();
        }
    }

    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReports.createTest("Test Name " + result.getTestClass().getName() + " - " + result.getMethod().getMethodName());
        extentTest.set(test);
    }

    public void onTestFailure(ITestResult result) {
        ExtentReportManager.logFailureDetails(result.getThrowable().getMessage());
        String stackTrace = Arrays.toString(result.getThrowable().getStackTrace());
        stackTrace = stackTrace.replaceAll(",","<br>");
        String formatedTrace = "<details>\n" +
                "\t<summary>Click Here To See Exception Logs</summary>\n" +
                "\t" + stackTrace + "\n" +
                "</details>";
        ExtentReportManager.logExceptionDetails(formatedTrace);
    }
}
