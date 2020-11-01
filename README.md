# StringManipulator
Spring Boot 2 and Java 8 Demo Project for REST API. It had two method for string manipulations.
This utility tool consolidating series to be used to determine if a ranges(s) should be allowed or excluded.

## Requirements
	1. Write an sprint boot application with below api 
	1.1 POST api to accept list of strings and return the first longest string from it. Use streams. 
	1.2 DELETE api to accept list of strings and remove all the string which is having length more than 10. 
			- Return remaining. 
			- Use streams


## EXAMPLES
Post Api
If the input = `['A', 'B', 'AA', 'BB']`
Then the output should be = `['AA']`

Delete Api
If the input = `['A1234567890', 'B12345678', '123456789012']`
Then the output should be = `['A1234567890', '123456789012']`

## Evaluation Guidelines

Your work will be evaluated against the following criteria:
- Successful implementation
- Efficiency of the implementation
- Design choices and overall code organization
- Code quality and best practices

## Getting Started

After downloading or cloning this repository, any further setup is completely optional. It is possible to use this demo immediately if your environment if configured to use the tools listed below in `Prerequisites`.

### Prerequisites

Your environment will need to be setup to use [Java](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
 and [Gradle](https://gradle.org/install/).

## Building

Gradle is used for building the source code, generating the documentation, executing unit tests, and running the demo application.

```
Run all commands from within the main project folder.
```
### Configure in Eclipse
Import project as gradle project.
Gradle Refresh
Run Application.java


### Gradle tasks

The following Gradle tasks are available:

- build
- clean
- javadoc
- run
- test

#### build

The `build` task will compile all Java classes (including unit tests) and copy the compiled classes and resource file(s) to the `build` folder.

To execute this, run: `gradle build`

#### clean

The `clean` task will remove the `build` folder.

To execute this, run: `gradle clean`

#### javadoc

The `javadoc` task will generate the JavaDocs from source code and copy them into `build/docs`.

To execute this, run: `gradle javadoc`

#### run

The `run` task will execute the main Java class: `com.nisum.seriesgenerator.Application`

To execute this, run: `gradle run`

When the `Application` class is executed, it will:
- read the contents of `build/resources/main/rawRanges.txt`
   ```
   To change the code range definitions, edit the file: src/main/resources/rawRanges.txt

   After editing rawRanges.txt, it is necessary to run the build again.
   ```
- process all of the ranges contained within `rawRanges.txt`
- sort and consolidate all ranges into the minimum number of ranges
- display both the original and consolidated ranges
- optional: Any codes passed in via the command-line will be checked if they are in any of the excluded ranges
   ```
   To add codes to the command-line, run add "-Pexclude=#####,#####" to the build command.

   Example: gradle run -Pexclude=11111,22222,98765
   ```

#### test

The `test` task will execute the unit tests copy the results to the `build/________________________` folder.

To execute this, run: `gradle test`

The unit test report can be seen by opening `/build/reports/tests/test/index.html` with a web browser.

The code coverage report can be seen by opening `/build/reports/jacoco/test/html/index.html` with a web browser.

## Libraries

This project uses the following libraries:
* [JDK 1.8.0.261]
