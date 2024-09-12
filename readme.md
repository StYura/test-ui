# Java Selenide UI Tests with Allure Reporting

This project uses [Selenide](https://selenide.org/) for UI tests and [Allure](https://docs.qameta.io/allure/) for test reporting. The project also integrates with GitHub Actions for automated testing and report publishing to GitHub Pages.

## Prerequisites

Before running the tests, ensure you have the following tools installed:

- [Java 17](https://adoptopenjdk.net/)
- [Maven](https://maven.apache.org/)
- [Allure Commandline](https://docs.qameta.io/allure/#_installing_a_commandline)

## Running Tests Locally

To run the tests locally, follow these steps:

1. **Clone the repository**:

    ```bash
    git clone https://github.com/StYura/test-ui.git
    ```

2. **Run the tests**:

   Execute the following Maven command to clean, compile, and run the Selenide UI tests:

    ```bash
    mvn clean test
    ```

3. **Generate and view Allure report**:

   After running the tests, generate the Allure report:

    ```bash
    mvn allure:serve
    ```

   This command will generate the report and automatically open it in your default web browser.

## Running Tests via GitHub Actions

This project is configured to run UI tests on demand from repository [Actions](https://github.com/StYura/test-ui/actions/new) tab.

### How to Trigger Tests

1. **Go to the actions tab**

2. **Click on `Run table comparison test` action**

3. **Click on `Run workflow button` anc confirm workflow execution**


### Workflow File

The workflow file is located at `.github/workflows/test.yml`. It sets up the environment, runs the tests, and publishes the Allure report.

You can view the workflow results under the **Actions** tab in your GitHub repository.

## Viewing Allure Report on GitHub Pages

After the tests are completed via GitHub Actions, the Allure report is automatically published to GitHub Pages.

[Report page](https://styura.github.io/test-ui/allure-action/main/test/)

and pick latest report