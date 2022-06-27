# API call sample project

## About the job description
Strong testing background delivering major pieces of work in an Agile environment
Background testing within mobile / device testing teams especially Apple/iOS, Android or both
3-5 years+ using commercial and/or open source test automation tools across the test automation pyramid.
Practical experience with iOS and especially the following programming languages and framework, i.e. Swift, xcode and XCUIT.
Practical experience with Android and especially the following programming languages and framework, i.e. Java, and Appium.
Knowledge of following programming languages and database query tools, i.e. Java, JavaScript, C#, SQL, HTML, XML etc.
Javascript is a nice to have

## Dev environment setup, dev tool installation and solution to blockers
### Try `Maven package/install` without test (skip tests) but running into an error in Powershell
The reason for this is, in Powershell the "-" has special meaning and it is causing problem with maven.

The solution is to prepend it with a backtick (`), for example:
```
mvn `-Dmaven.test.skip=true install
```
[Maven package install without test skip tests](https://stackoverflow.com/questions/7456006/maven-package-install-without-test-skip-tests)

## Misc
### About command `mvn test`
Please note that by default Maven uses the following naming conventions when looking for tests to run:

- Test*
- *Test
- *Tests (has been added in Maven Surefire Plugin 2.20)
- *TestCase

If your test class doesn't follow these conventions you should rename it or configure Maven Surefire Plugin to use another pattern for test classes.

### About junit version
- [A Exception for junit4.11 and 4.12 about org/hamcrest/SelfDescribing](https://github.com/junit-team/junit4/issues/1429)
- [Summary of changes in version 4.11](https://github.com/junit-team/junit4/blob/main/doc/ReleaseNotes4.11.md)
Basically JUint 4 is deprecated and has more issues in its older version. We've changed to JUnit 5 (Jupiter).

### Other useful sites
- [Build a Java app with Maven](https://jenkins.io/doc/tutorials/build-a-java-app-with-maven/)
- [Jenkins User Documentation](https://jenkins.io/doc/)
- [How to run specific test cases with Maven](https://mkyong.com/maven/how-to-run-unit-test-with-maven/)
- [PageFactory and ExpectedConditions in C# Selenium](https://ultimateqa.com/selenium-3-11-released/)
- [Playwright Java instructions](https://playwright.dev/java/docs/input)
- [Playwright Java examples](https://github.com/microsoft/playwright-java)
