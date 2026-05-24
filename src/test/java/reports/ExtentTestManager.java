package reports;

import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {

    private static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    private static ExtentTest test;

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }

    public static synchronized ExtentTest createTest(String testName) {
        return createTest(testName, "");
    }

    public static synchronized ExtentTest createTest(String testName, String description) {
        test = ExtentReportManager.getInstance().createTest(testName, description);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
        return test;
    }

    public static synchronized void removeTest() {
        extentTestMap.remove((int) Thread.currentThread().getId());
    }

    public static synchronized void setTest(ExtentTest extentTest) {
        extentTestMap.put((int) Thread.currentThread().getId(), extentTest);
        test = extentTest;
    }
}
