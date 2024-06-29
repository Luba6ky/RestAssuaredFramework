RestAssuredFramework

Overview

RestAssuredFramework is a comprehensive test automation framework designed for API testing.
It leverages RestAssured for API interactions, TestNG for test execution, Cucumber, 
and several other libraries for logging, reporting, and database interactions.

Prerequisites

Before you begin, ensure you have met the following requirements:

- Java 17: Ensure Java 17 is installed on your machine.
- Maven: Ensure Maven is installed for dependency management and build automation.

Building and Running the Project using Maven
Prerequisites
Ensure you have the following installed on your machine:

Java 17: Download and install Java 17
Maven: Download and install Maven
Installing Dependencies

To install all the necessary dependencies, navigate to the project root directory and run:
mvn clean install

Building the Project
To compile the code, run the tests, and package the application into a jar file, execute:
mvn clean package

This command will generate the executable jar file in the target directory.

Running the Tests
To run all the tests in the project, use:
mvn test

This will execute the tests using TestNG and Cucumber.


