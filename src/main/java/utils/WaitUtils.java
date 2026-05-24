package utils;

import java.time.Duration;
import java.util.function.Supplier;

public class WaitUtils {
    /**
     * Waits until the given condition returns true or the timeout is reached.
     *
     * @param condition          the condition to check
     * @param timeoutSeconds     the maximum time to wait in seconds
     * @param pollIntervalMillis the interval between checks in milliseconds
     */
    public static void awaitSuccessOrTimeout(Supplier<Boolean> condition,
                                             long timeoutSeconds,
                                             long pollIntervalMillis) {
        long end = System.currentTimeMillis() + Duration.ofSeconds(timeoutSeconds).toMillis();
        while (System.currentTimeMillis() < end) {
            try {
                if (condition.get()) {
                    return;
                }
                Thread.sleep(pollIntervalMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
