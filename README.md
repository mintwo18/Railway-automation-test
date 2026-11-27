# Railway Web UI Automation Testing

**Academic group project · Group 05 · 2025**

A Java and Selenium Web UI automation project for selected user journeys in the Safe Railway training application.

## Project overview
The project automates selected flows using Java, Selenium WebDriver, TestNG, Maven, and Page Object classes. Coverage includes login, registration, password-related flows, ticket booking, timetable navigation, and ticket cancellation.

This repository is a sanitized portfolio copy of the original group coursework. The supplied code archive contains Selenium UI automation; it does not include an API test collection or API automation implementation.

## Technology stack
- Java 11
- Maven
- Selenium Java 4.38.0
- TestNG 7.11.0
- Microsoft Edge
- Page Object Model-style page classes

## Test coverage
The coursework contains 16 test cases / TestNG methods:

| Area | Test cases | Scenarios |
|---|---|---|
| Login and access | TC01–TC06 | Valid login, invalid input, protected-page access, repeated failed login, post-login navigation |
| Registration and password | TC07–TC13 | Registration, inactive account login, password change, confirmation mismatch, required-field validation, password-reset flows |
| Ticket booking | TC14–TC16 | Book ticket, navigate from timetable to booking, cancel ticket |

See TEST_EXECUTION_SUMMARY.md for the historical execution results and observations.

## Project structure
~~~text
src/
  main/java/
    Common/Constant/       # Shared driver and environment-based test configuration
    PageObjects/Railway/   # Page-object classes for Railway pages
  test/java/
    Testcases/Railway/     # TestNG test classes
pom.xml
Testng.xml
.env.example
~~~

## Configuration and execution
Set the environment variables listed in .env.example in your IDE run configuration or shell. Do not commit real credentials or a local .env file.

PowerShell example:
~~~powershell
$env:RAILWAY_USERNAME="your-test-account@example.com"
$env:RAILWAY_PASSWORD="your-test-password"
$env:RAILWAY_NEW_PASSWORD="your-new-test-password"
$env:RAILWAY_INVALID_PASSWORD="incorrect-password"
$env:RAILWAY_TEST_PID="12345678"
mvn clean test
~~~

Bash example:
~~~bash
export RAILWAY_USERNAME="your-test-account@example.com"
export RAILWAY_PASSWORD="your-test-password"
export RAILWAY_NEW_PASSWORD="your-new-test-password"
export RAILWAY_INVALID_PASSWORD="incorrect-password"
export RAILWAY_TEST_PID="12345678"
mvn clean test
~~~

The variables must be set before running the suite. Some registration and password-reset scenarios depend on external email confirmation and may not complete when that service is unavailable.

## Recorded execution snapshot
The archived TestNG report for the 20 November 2025 run recorded **16 methods: 7 passed and 9 failed**. This is a historical coursework result, not a claim that the current target or test suite has been revalidated.

Several failures were differences between expected and actual UI messages. Two password-reset scenarios stopped because of an application/mailbox error. A failed assertion does not by itself establish a product defect; test data, expected behavior, and environment behavior must be reviewed together.

## Academic / contribution disclosure
This is group coursework, not a solo product. The code archive preserves the team's Selenium structure. Personal contributions should be described in a CV only to the extent that they can be explained and demonstrated in an interview.

## API-testing boundary
No Postman collection, REST Assured tests, or API automation source was present in the supplied ZIP. API testing is therefore not claimed as a deliverable of this repository.
