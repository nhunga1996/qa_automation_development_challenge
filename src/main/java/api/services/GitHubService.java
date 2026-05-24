package api.services;

import api.client.GitHubApiClient;
import api.models.response.RepositoryResponse;

import java.util.List;

public class GitHubService {

    private final GitHubApiClient apiClient = new GitHubApiClient();

    public List<RepositoryResponse> getRepositories(String organization) {
        return apiClient.getAllRepositories(organization);
    }
}