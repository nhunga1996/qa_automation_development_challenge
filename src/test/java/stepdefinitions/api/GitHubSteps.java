package stepdefinitions.api;

import api.models.response.RepositoryResponse;
import api.services.GitHubService;
import api.services.RepositoryAnalyzer;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import reports.ExtentLogger;

import java.util.List;

public class GitHubSteps {

    private final GitHubService gitHubService =
            new GitHubService();

    private final RepositoryAnalyzer analyzer =
            new RepositoryAnalyzer();

    private List<RepositoryResponse> repositories;

    @When("user retrieves all repositories from SeleniumHQ organization")
    public void getRepositories() {

        repositories =
                gitHubService.getRepositories(
                        "SeleniumHQ"
                );
    }

    @Then("total open issues should be calculated")
    public void calculateTotalOpenIssues() {

        int totalIssues =
                analyzer.calculateTotalOpenIssues(
                        repositories
                );

        ExtentLogger.info("Total Open Issues: " + totalIssues);
    }

    @Then("highest starred repository should be identified")
    public void identifyHighestStarredRepository() {
        analyzer.getHighestStarredRepository(repositories).ifPresent(repository -> {
            ExtentLogger.info("Highest Starred Repository: " + repository.getName());
            ExtentLogger.info("Stars: " + repository.getStargazersCount());
        });
    }
}