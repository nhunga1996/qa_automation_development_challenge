package api.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class GitHubApiConfig {

    private static final String BASE_URI = "https://api.github.com";
    private static final RequestSpecification REQUEST_SPECIFICATION;

    static {
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .addHeader("Accept", "application/vnd.github+json")
                .addHeader("Content-Type", "application/json")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    private GitHubApiConfig() {
    }

    public static RequestSpecification getRequestSpecification() {
        return REQUEST_SPECIFICATION;
    }
}