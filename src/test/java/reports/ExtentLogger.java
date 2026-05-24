package reports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class ExtentLogger {

    public static void pass(String message) {
        ExtentTest test = ExtentTestManager.getTest();
        if (test != null) {
            test.pass(message);
        }
    }

    public static void fail(String message) {
        ExtentTest test = ExtentTestManager.getTest();
        if (test != null) {
            test.fail(message);
        }
    }

    public static void skip(String message) {
        ExtentTest test = ExtentTestManager.getTest();
        if (test != null) {
            test.skip(message);
        }
    }

    public static void info(String message) {
        ExtentTest test = ExtentTestManager.getTest();
        if (test != null) {
            test.info(message);
        }
    }

    public static void warning(String message) {
        ExtentTest test = ExtentTestManager.getTest();
        if (test != null) {
            test.warning(message);
        }
    }

    public static void error(String message) {
        ExtentTest test = ExtentTestManager.getTest();
        if (test != null) {
            test.fail(message);
        }
    }

    public static void error(String message, Throwable throwable) {
        ExtentTest test = ExtentTestManager.getTest();
        if (test != null) {
            test.fail(message);
            test.fail(throwable);
        }
    }

    public static void failWithScreenshot(String message, String base64Screenshot) {
        ExtentTest test = ExtentTestManager.getTest();
        if (test != null) {
            try {
                test.fail(
                        message,
                        MediaEntityBuilder
                                .createScreenCaptureFromBase64String(base64Screenshot)
                                .build()
                );
            } catch (Exception e) {
                test.fail(message + " - Failed to attach screenshot: " + e.getMessage());
            }
        }
    }
}
