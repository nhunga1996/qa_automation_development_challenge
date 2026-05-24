package api.client;

import api.config.GitHubApiConfig;
import api.models.response.RepositoryResponse;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

public class GitHubApiClient {

    private static final int DEFAULT_PER_PAGE = 100;
    private static final String ORG_REPOS_ENDPOINT = "/orgs/{organization}/repos";

    public Response getRepositories(String organization) {
        return RestAssured
                .given()
                .spec(GitHubApiConfig.getRequestSpecification())
                .pathParam("organization", organization)
                .queryParam("per_page", DEFAULT_PER_PAGE)
                .when()
                .get(ORG_REPOS_ENDPOINT);
    }

    public Response getRepositoriesByUrl(String url) {
        return RestAssured
                .given()
                .spec(GitHubApiConfig.getRequestSpecification())
                .when()
                .get(url);
    }

    public List<RepositoryResponse> getAllRepositories(String organization) {
        List<RepositoryResponse> allRepos = new ArrayList<>();
        Response response = getRepositories(organization);

        while (true) {
            allRepos.addAll(response.as(new TypeRef<List<RepositoryResponse>>() {}));
            String nextUrl = getNextPageUrl(response.getHeader("Link"));
            if (nextUrl == null) {
                break;
            }
            response = getRepositoriesByUrl(nextUrl);
        }

        return allRepos;
    }

    private String getNextPageUrl(String linkHeader) {
        if (linkHeader == null || linkHeader.isBlank()) {
            return null;
        }

        for (String link : linkHeader.split(",")) {
            String[] parts = link.split(";");
            if (parts.length >= 2 && parts[1].trim().equals("rel=\"next\"")) {
                String urlPart = parts[0].trim();
                if (urlPart.startsWith("<") && urlPart.endsWith(">")) {
                    return urlPart.substring(1, urlPart.length() - 1);
                }
            }
        }
        return null;
    }
}