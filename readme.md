# Spring PetClinic – Applied Spring Boot Research Project
## Overview

This project is an applied research and exploration of Spring Boot conducted at the request of a university lecturer.
The goal was to evaluate Spring Boot as a modern backend framework for educational use and to support curriculum modernization with tools that better reflect current industry practices.

The project uses Spring PetClinic as a real-world reference application to analyze architecture, configuration, and development workflows commonly used in professional Java backend development.

## Purpose of the Project

Evaluate Spring Boot as a suitable framework for teaching modern backend development

Explore industry-relevant practices instead of outdated academic examples

Produce practical, explainable material that can be reused for teaching and curriculum updates

Bridge the gap between academic learning and real-world software development

This was not a typical coursework assignment, but a targeted research initiative requested by a lecturer to explore and validate newer technologies for long-term educational use.

## What Was Explored

Spring Boot application structure and auto-configuration

Layered architecture (Controller / Service / Repository)

RESTful API design principles

Database integration using JPA / Hibernate

Configuration management and environment-based setup

Maintainability and readability of production-style codebases

Version control and structured development workflow (Git)

## Cloud & Environment Context

- Application tested with a **cloud-hosted SQL database running on Google Cloud Platform**
- Worked with **Google Cloud SQL** as the database backend instead of a purely local setup
- Focus on understanding:
  - Remote database connectivity
  - Environment-based configuration
  - Credentials and connection handling
  - Cloud vs local development differences
- Emphasis on building **cloud-ready Spring Boot applications** that can operate reliably with managed database services


## Why Spring PetClinic

Spring PetClinic was chosen because it:

Represents a realistic, non-trivial Spring Boot application

Demonstrates common enterprise patterns

Is widely recognized in the Java ecosystem

Serves as a strong baseline for evaluating framework suitability in both education and industry

## Outcome

Clear understanding of Spring Boot’s strengths for modern backend development

Practical material and examples suitable for teaching and curriculum updates

Transferable knowledge applicable to enterprise Java projects

Strong foundation for working with Spring-based systems in professional environments

## Technologies Used

Java

Spring Boot

Spring MVC

Spring Data JPA

Hibernate

SQL

Git

Google Cloud Platform (project/environment context)

## Author

Anton
Software Developer
Focus areas:

Backend & full-stack development

Legacy system analysis and modernization

Applied research and technology evaluation

Bridging technical implementation with business and educational needs
## What Was Done
Added a page for deleting owner . For that ,it creates a page to confirm the action,Runs the deletion on the other page to avoid errors and redirects back to owner find page
## Note 
1. !! Replace the  variable values annotated with !! in 
main/resources/application.properties and application-mysql.properties
before the first launch
2. After Booting up The Shell editor ALWAYS run this two commands in the terminal 
cd spring-petclinic/ 
(replace spring-petclinic/ with your own directory where pom.xml is located)
gcloud config set project cloud-computing-123456
(replace cloud-computing-123456 with your own Project ID found in Cloud Overview in Google Cloud)
3. Make sure that both App Engine And your SQL instance are running (not updating) in Google Cloud
4. Run "mvn spring-javaformat:apply" to fix formating errors ,run it every time you change a file before starting the application with
 "mvn spring-boot:run"  
5. Dont know if gcloud app deploy is useful as shell editor saves automatically if set,but do check if it does
"File-> Auto-Save" should be ticked
app is deployed via spring boot anyway
6. there could be a problem with github that it does not recognise you , if so run
" git config --global user.email youremail@example.com "
" git config --global user.name "FIRST_NAME LAST_NAME" "
7. Im not sure that you need a principal for this project or not (IAM in Google Cloud)
8. Link to original installation process (Its already done here and updated to fit and fix the project)
https://codelabs.developers.google.com/codelabs/cloud-spring-petclinic-cloudsql/index.html 
9. Whethewer you update it will ask you to provide a message and then 
click the check/tick on the top right right next to open files list

# Original Description 

# Spring PetClinic Sample Application [![Build Status](https://github.com/spring-projects/spring-petclinic/actions/workflows/maven-build.yml/badge.svg)](https://github.com/spring-projects/spring-petclinic/actions/workflows/maven-build.yml)

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/spring-projects/spring-petclinic) [![Open in GitHub Codespaces](https://github.com/codespaces/badge.svg)](https://github.com/codespaces/new?hide_repo_select=true&ref=main&repo=7517918)

## Understanding the Spring Petclinic application with a few diagrams

[See the presentation here](https://speakerdeck.com/michaelisvy/spring-petclinic-sample-application)

## Run Petclinic locally

Spring Petclinic is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/) or [Gradle](https://spring.io/guides/gs/gradle/). You can build a jar file and run it from the command line (it should work just as well with Java 17 or newer):

```bash
git clone https://github.com/spring-projects/spring-petclinic.git
cd spring-petclinic
./mvnw package
java -jar target/*.jar
```

You can then access the Petclinic at <http://localhost:8080/>.

<img width="1042" alt="petclinic-screenshot" src="https://cloud.githubusercontent.com/assets/838318/19727082/2aee6d6c-9b8e-11e6-81fe-e889a5ddfded.png">

Or you can run it from Maven directly using the Spring Boot Maven plugin. If you do this, it will pick up changes that you make in the project immediately (changes to Java source files require a compile as well - most people use an IDE for this):

```bash
./mvnw spring-boot:run
```

> NOTE: If you prefer to use Gradle, you can build the app using `./gradlew build` and look for the jar file in `build/libs`.

## Building a Container

There is no `Dockerfile` in this project. You can build a container image (if you have a docker daemon) using the Spring Boot build plugin:

```bash
./mvnw spring-boot:build-image
```

## In case you find a bug/suggested improvement for Spring Petclinic

Our issue tracker is available [here](https://github.com/spring-projects/spring-petclinic/issues).

## Database configuration

In its default configuration, Petclinic uses an in-memory database (H2) which
gets populated at startup with data. The h2 console is exposed at `http://localhost:8080/h2-console`,
and it is possible to inspect the content of the database using the `jdbc:h2:mem:<uuid>` URL. The UUID is printed at startup to the console.

A similar setup is provided for MySQL and PostgreSQL if a persistent database configuration is needed. Note that whenever the database type changes, the app needs to run with a different profile: `spring.profiles.active=mysql` for MySQL or `spring.profiles.active=postgres` for PostgreSQL.

You can start MySQL or PostgreSQL locally with whatever installer works for your OS or use docker:

```bash
docker run -e MYSQL_USER=petclinic -e MYSQL_PASSWORD=petclinic -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=petclinic -p 3306:3306 mysql:8.2
```

or

```bash
docker run -e POSTGRES_USER=petclinic -e POSTGRES_PASSWORD=petclinic -e POSTGRES_DB=petclinic -p 5432:5432 postgres:16.1
```

Further documentation is provided for [MySQL](https://github.com/spring-projects/spring-petclinic/blob/main/src/main/resources/db/mysql/petclinic_db_setup_mysql.txt)
and [PostgreSQL](https://github.com/spring-projects/spring-petclinic/blob/main/src/main/resources/db/postgres/petclinic_db_setup_postgres.txt).

Instead of vanilla `docker` you can also use the provided `docker-compose.yml` file to start the database containers. Each one has a profile just like the Spring profile:

```bash
docker-compose --profile mysql up
```

or

```bash
docker-compose --profile postgres up
```

## Test Applications

At development time we recommend you use the test applications set up as `main()` methods in `PetClinicIntegrationTests` (using the default H2 database and also adding Spring Boot Devtools), `MySqlTestApplication` and `PostgresIntegrationTests`. These are set up so that you can run the apps in your IDE to get fast feedback and also run the same classes as integration tests against the respective database. The MySql integration tests use Testcontainers to start the database in a Docker container, and the Postgres tests use Docker Compose to do the same thing.

## Compiling the CSS

There is a `petclinic.css` in `src/main/resources/static/resources/css`. It was generated from the `petclinic.scss` source, combined with the [Bootstrap](https://getbootstrap.com/) library. If you make changes to the `scss`, or upgrade Bootstrap, you will need to re-compile the CSS resources using the Maven profile "css", i.e. `./mvnw package -P css`. There is no build profile for Gradle to compile the CSS.

## Working with Petclinic in your IDE

### Prerequisites

The following items should be installed in your system:

- Java 17 or newer (full JDK, not a JRE)
- [Git command line tool](https://help.github.com/articles/set-up-git)
- Your preferred IDE
  - Eclipse with the m2e plugin. Note: when m2e is available, there is an m2 icon in `Help -> About` dialog. If m2e is
  not there, follow the install process [here](https://www.eclipse.org/m2e/)
  - [Spring Tools Suite](https://spring.io/tools) (STS)
  - [IntelliJ IDEA](https://www.jetbrains.com/idea/)
  - [VS Code](https://code.visualstudio.com)

### Steps

1. On the command line run:

    ```bash
    git clone https://github.com/spring-projects/spring-petclinic.git
    ```

1. Inside Eclipse or STS:

    Open the project via `File -> Import -> Maven -> Existing Maven project`, then select the root directory of the cloned repo.

    Then either build on the command line `./mvnw generate-resources` or use the Eclipse launcher (right-click on project and `Run As -> Maven install`) to generate the CSS. Run the application's main method by right-clicking on it and choosing `Run As -> Java Application`.

1. Inside IntelliJ IDEA:

    In the main menu, choose `File -> Open` and select the Petclinic [pom.xml](pom.xml). Click on the `Open` button.

    - CSS files are generated from the Maven build. You can build them on the command line `./mvnw generate-resources` or right-click on the `spring-petclinic` project then `Maven -> Generates sources and Update Folders`.

    - A run configuration named `PetClinicApplication` should have been created for you if you're using a recent Ultimate version. Otherwise, run the application by right-clicking on the `PetClinicApplication` main class and choosing `Run 'PetClinicApplication'`.

1. Navigate to the Petclinic

    Visit [http://localhost:8080](http://localhost:8080) in your browser.

## Looking for something in particular?

|Spring Boot Configuration | Class or Java property files  |
|--------------------------|---|
|The Main Class | [PetClinicApplication](https://github.com/spring-projects/spring-petclinic/blob/main/src/main/java/org/springframework/samples/petclinic/PetClinicApplication.java) |
|Properties Files | [application.properties](https://github.com/spring-projects/spring-petclinic/blob/main/src/main/resources) |
|Caching | [CacheConfiguration](https://github.com/spring-projects/spring-petclinic/blob/main/src/main/java/org/springframework/samples/petclinic/system/CacheConfiguration.java) |

## Interesting Spring Petclinic branches and forks

The Spring Petclinic "main" branch in the [spring-projects](https://github.com/spring-projects/spring-petclinic)
GitHub org is the "canonical" implementation based on Spring Boot and Thymeleaf. There are
[quite a few forks](https://spring-petclinic.github.io/docs/forks.html) in the GitHub org
[spring-petclinic](https://github.com/spring-petclinic). If you are interested in using a different technology stack to implement the Pet Clinic, please join the community there.

## Interaction with other open-source projects

One of the best parts about working on the Spring Petclinic application is that we have the opportunity to work in direct contact with many Open Source projects. We found bugs/suggested improvements on various topics such as Spring, Spring Data, Bean Validation and even Eclipse! In many cases, they've been fixed/implemented in just a few days.
Here is a list of them:

| Name | Issue |
|------|-------|
| Spring JDBC: simplify usage of NamedParameterJdbcTemplate | [SPR-10256](https://jira.springsource.org/browse/SPR-10256) and [SPR-10257](https://jira.springsource.org/browse/SPR-10257) |
| Bean Validation / Hibernate Validator: simplify Maven dependencies and backward compatibility |[HV-790](https://hibernate.atlassian.net/browse/HV-790) and [HV-792](https://hibernate.atlassian.net/browse/HV-792) |
| Spring Data: provide more flexibility when working with JPQL queries | [DATAJPA-292](https://jira.springsource.org/browse/DATAJPA-292) |

## Contributing

The [issue tracker](https://github.com/spring-projects/spring-petclinic/issues) is the preferred channel for bug reports, feature requests and submitting pull requests.

For pull requests, editor preferences are available in the [editor config](.editorconfig) for easy use in common text editors. Read more and download plugins at <https://editorconfig.org>. If you have not previously done so, please fill out and submit the [Contributor License Agreement](https://cla.pivotal.io/sign/spring).

## License

The Spring PetClinic sample application is released under version 2.0 of the [Apache License](https://www.apache.org/licenses/LICENSE-2.0).

# End Of Original Description
