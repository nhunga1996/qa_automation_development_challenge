package reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class ExtentLogger {

    private ExtentLogger() {
    }

    public static void info(String message) {

        ExtentTestManager
                .getTest()
                .log(
                        Status.INFO,
                        message
                );
    }

    public static void pass(String message) {

        ExtentTestManager
                .getTest()
                .log(
                        Status.PASS,
                        message
                );
    }

    public static void fail(String message) {

        ExtentTestManager
                .getTest()
                .log(
                        Status.FAIL,
                        message
                );
    }

    public static void failWithScreenshot(String message, String base64Screenshot) {
        ExtentTestManager
                .getTest()
                .fail(
                        message,
                        MediaEntityBuilder
                                .createScreenCaptureFromBase64String(base64Screenshot)
                                .build()
                );
    }
}