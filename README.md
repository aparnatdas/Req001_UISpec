# Req001_UISpec
Requirement 001-UI Spec

This repository contains a Cucumber BDD Framework and libraries that demonstrate how to use the tool and develop automation script using the Cucumber (v 6.8.1) BDD framework with Java as programming language. Selenium version 4.8.1 is used along with PageFactory. 
It generates Extend, HTML and JSON reports. Chromedriver version attached is 111

Installation (pre-requisites)

1. JDK 1.8+ (make sure Java class path is set)
2. Maven (make sure .m2 class path is set)
3. IntelliJ/Eclipse
4. IntelliJ Plugins for Cucumber and Gherkins
5. Chromedriver (as per the version of chrome browser)

Framework set up
Fork / Clone repository from here or download zip and set it up in your local workspace.

Test Runner
TestRunner class can be used to run the tests with desired tags. '@UISpecTests'includes the whole tests or remove the tags session to run all. Tests can be run using commands as well. 

Reports
Extend-spark report is used. It will be generated in test-results folder. 
![image](https://user-images.githubusercontent.com/10363367/231363135-1a7f1439-f4e6-4cb1-851b-30f42e2b2f0c.png)

JSON and HTML reports can also be generated
The feature files are placed under src/test/java/features and corresponding step definitions under src/main/java/stepDefinitions
and TestRunner under runner/TestRunner


Sample Feature File

![image](https://user-images.githubusercontent.com/10363367/231384166-b13871ed-44f1-4753-a4ee-1e021bcc3347.png)

Tags were added with respect to each tests.
If examples are there, then instead of Scenario, Scenario Outline will be used 
