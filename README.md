# This repo is archived

# springboot-tracking-number-generator-app

- Version 0.0.1-SNAPSHOT
- Date 12th August 2024


## Requirements

Design and implement a unique tracking numbers generator using java spring boot with junit test cases.The system must handle high concurrency and be scalable.

-Uniqueness: Each tracking number must be unique.
-Scalability: Handle high concurrency and scale horizontally.
-Efficiency: Quick generation without bottlenecks.
-Fault Tolerance: Resilient to failures, ensuring no duplicate tracking numbers.

For building and running the application you need:

- [Java 17]
- [Maven 3]
- [Redis]

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.user.tracking.TrackingApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
