package api.services;

import api.models.response.RepositoryResponse;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class RepositoryAnalyzer {

    public int calculateTotalOpenIssues(List<RepositoryResponse> repositories) {
        if (repositories == null || repositories.isEmpty()) {
            return 0;
        }

        return repositories.stream()
                .mapToInt(RepositoryResponse::getOpenIssuesCount)
                .sum();
    }

    public Optional<RepositoryResponse> getHighestStarredRepository(List<RepositoryResponse> repositories) {
        if (repositories == null || repositories.isEmpty()) {
            return Optional.empty();
        }

        return repositories.stream()
                .max(Comparator.comparingInt(RepositoryResponse::getStargazersCount));
    }
}