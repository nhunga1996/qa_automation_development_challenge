
# QA Automation Development Challenge

An advanced, scalable automation test framework for both UI and API testing, featuring:

- UI automation with Selenium, Cucumber, and TestNG
- API testing with REST Assured
- Rich HTML reporting with Extent Reports

---

## Table of Contents

1. [Features](#features)
2. [Tech Stack](#tech-stack)
3. [Project Structure](#project-structure)
4. [Setup Instructions](#setup-instructions)
5. [Running Tests](#running-tests)
6. [Test Reports](#test-reports)
7. [Framework Highlights](#framework-highlights)
8. [Contributing](#contributing)
9. [Support](#support)
10. [License](#license)

---

## Features

- Cross-browser UI automation
- BDD-style test scenarios
- API test automation with request/response validation
- Automatic driver management
- Detailed HTML and screenshot reporting
- Page Object Model for maintainability

---

## Tech Stack

| Technology         | Usage                        |
|--------------------|------------------------------|
| Java 18            | Programming language         |
| Maven              | Build tool                   |
| Selenium WebDriver | UI automation                |
| Cucumber           | BDD framework                |
| TestNG             | Test runner                  |
| REST Assured       | API testing                  |
| Extent Reports     | HTML reporting               |
| WebDriverManager   | Browser driver management    |

---

## Setup Instructions

### 1. Install Prerequisites

- **Java 17**
  - Verify: `java -version`
- **Maven**
  - Verify: `mvn -version`
- **Google Chrome** (latest stable)

### 2. Clone the Repository

```sh
git clone <repository-url>
cd qa_automation_development_challenge
```

### 3. Install Dependencies

```sh
mvn clean install
```

---

## Running Tests

### Run UI Tests

```sh
mvn test "-Dcucumber.filter.tags=@ui"
```

### Run API Tests

```sh
mvn test "-Dcucumber.filter.tags=@api"
```

---

## Test Reports

- **Extent HTML Report:**
  - Generated at: `target/extent-report.html`
  - Open with:
    ```sh
    open target/extent-report.html
    ```
- **UI Failure Screenshots:**
  - Saved in: `screenshots/`

### Report Features

- Scenario and step execution logs
- Pass/fail status and timestamps
- API/UI execution visibility
- Embedded screenshots for UI failures

  <img width="1906" height="906" alt="image" src="https://github.com/user-attachments/assets/48836506-a851-46ee-8380-d6e85312ca03" />

  <img width="1917" height="912" alt="image" src="https://github.com/user-attachments/assets/ee421db3-a6de-4869-b613-d2e7790909d4" />



---

## Framework Highlights

- Page Object Model for UI maintainability
- Scenario Context and Page Object Manager for state management
- BasePage abstraction and explicit waits
- Reusable components for common actions
- WebDriverManager for automatic browser driver handling
- API pagination handled (e.g., GitHub API with `per_page=100`)
- Designed for scalability and maintainability

---

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request. For major changes, open an issue first to discuss your ideas.

---

## Support

For questions, issues, or feature requests, please open an issue in this repository.

---
