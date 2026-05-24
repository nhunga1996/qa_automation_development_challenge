package reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

    private static final ThreadLocal<ExtentTest>
            extentTestThreadLocal =
            new ThreadLocal<>();

    private ExtentTestManager() {
    }

    public static void setTest(ExtentTest extentTest) {
        extentTestThreadLocal.set(extentTest);
    }

    public static ExtentTest getTest() {

        return extentTestThreadLocal.get();
    }
}