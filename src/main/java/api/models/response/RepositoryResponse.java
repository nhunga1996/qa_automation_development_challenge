package api.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryResponse {

    private String name;

    @JsonProperty("open_issues_count")
    private int openIssuesCount;

    @JsonProperty("stargazers_count")
    private int stargazersCount;

    public RepositoryResponse() {
    }

    public RepositoryResponse(String name, int openIssuesCount, int stargazersCount) {
        this.name = name;
        this.openIssuesCount = openIssuesCount;
        this.stargazersCount = stargazersCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOpenIssuesCount() {
        return openIssuesCount;
    }

    public void setOpenIssuesCount(int openIssuesCount) {
        this.openIssuesCount = openIssuesCount;
    }

    public int getStargazersCount() {
        return stargazersCount;
    }

    public void setStargazersCount(int stargazersCount) {
        this.stargazersCount = stargazersCount;
    }
}