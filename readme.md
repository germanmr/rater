# Inditex Core Platform Technical Test 

<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li> <a href="#requirements">Requirements</a> </li>
    <li>
          <a href="#running-the-application-locally">Running the application locally</a>
          <ul>
            <li><a href="#step-1">Step 1: Install and generate Jacoco Reports</a></li>
            <li><a href="#step-2">Step 2: Running the application</a></li>
            <li><a href="#step-3">Step 3: Use</a></li>
          </ul>
        </li>
    <li><a href="#modules">Modules</a></li>
    <li><a href="#tools">tools</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#author">Author</a></li>
  </ol>
</details>

## About the project

This is the Inditex Core Platform Technical Test, developed with Java 17, Spring Boot 2.7.18 and an in-memory H2 Database.

The application takes a Brand, a Product and a DateTime, then returns the corresponding Pricing Details

[(Back to the top)](#inditex-core-platform-technical-test)

## Requirements

For building and running the application you need:

- [JDK 1.17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven 3](https://maven.apache.org)

[(Back to the top)](#inditex-core-platform-technical-test)

## Running the application locally

### Step 1: 

### Install and generate Jacoco Reports

```shell    
mvn clean install
```

Besides Maven's **clean** and **install** default goals this will:
* Generate the Open API endpoint and Dto classes
* MapStruct implementations
* Immutables implementations
* Run **Unit** and **Integration** Tests
* Generate and gather Jacoco Reports

Regarding **Jacoco Reports**, they can be found in the **Jacoco Aggregate** module, specifically the file:

Location:

Windows

    \jacoco-aggregate\target\site\jacoco-aggregate\index.html

Linux/Mac

    /jacoco-aggregate/target/site/jacoco-aggregate/index.html

### Step 2:
#### Running the application
  Manually run **'com.inditex.rater.domain.RaterApplication'** class in **rater-container** module

  or through the command line terminal or shell

Navigate to the container module 
```shell
cd rater-container
```

Execute

```shell
mvn spring-boot:run -Dstart-class='com.inditex.rater.domain.RaterApplication'
```

### Step 3:

#### Use
  
A **Valid Request** can be done using [Curl](https://curl.se/) or accessing the [Swagger doc URL](HTTP://LOCALHOST:8181/swagger)

    curl --location 'http://localhost:8181/rate' \
        --header 'Content-Type: application/json' \
        --data '{
            "brandId": 1,
            "productId": 35455,
            "applyDate": "2020-06-16T21:00:00.000-00:00"
    }'

**Expected reply**

    {
        "brandId": 1,
        "productId": 35455,
        "startDate": "2020-06-15T16:00:00Z",
        "endDate": "2020-12-31T23:59:59Z",
        "priceList": 4,
        "finalPrice": 38.95
    }


An **Invalid Request**, in this case without the "brandId" attribute

    curl --location 'http://localhost:8181/rate' \
    --header 'Content-Type: application/json' \
    --data '{
        "productId": 1,
        "applyDate": "2020-06-16T21:00:00.000-00:00"
    }'

**Expected reply**

    {
        "code": "Bad Request",
        "message": "brandId no debe ser nulo"
    }

[(Back to the top)](#inditex-core-platform-technical-test)

## Modules

Hexagonal architecture was applied, thus separating the Core Domain from the Exterior.
The developed was made starting from the Core: **Domain Core** and **Domain application services**, defining entities,
and interfaces for the inputs and outputs ports to define the interaction with the outside world. Later the **rater-application** and **rater-dataccess** 
modules were implemented tyo connect to the exterior. Finally, **rater-container** binds all modules in order to be able to 
start the application, and inject the proper implementations for the defined interfaces ports to the outside.
A Jacoco aggregate module was added to check tests coverage.

Modules list: ( In alphabetical order to be easily found in the tree file )     

* **Rater Application**: End points definitions and implementations. Global Exception Handling.
* **Rater Container**: Application class initiator. Integration tests.
* **Rater Data Access**: Implementation of entities repositories to connect to an in memory H2 Database
* **Rater Domain**
  * **Application Service**:  This is the layer that connects the domain with the exterior, inputs/outputs  
  * **Rater Core**: The core classes associated with the Domain
* **Rater Jacoco Aggregate**: Module that compiles all the Jacoco results from the other ones

[(Back to the top)](#inditex-core-platform-technical-test)

## Tools:
* [JDK 1.17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
* [Maven 3](https://maven.apache.org)
* [OpenAPI](https://swagger.io/specification/)
* [Lombok](https://projectlombok.org/)
* [Jacoco](https://www.jacoco.org/)
* [MapStruct](https://mapstruct.org/)
* [Immutables](https://immutables.github.io/)
* [H2 in-memory Database](https://www.h2database.com/html/main.html)

#### Concepts and patterns:
* [Hexagonal architecture](https://en.wikipedia.org/wiki/Hexagonal_architecture_(software))
* [Builder Pattern](https://refactoring.guru/design-patterns/builder)
* [Adapter Pattern](https://refactoring.guru/design-patterns/adapter)
* [SOLID principles](https://en.wikipedia.org/wiki/SOLID)

[(Back to the top)](#inditex-core-platform-technical-test)

## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/germanmr/rater/master/LICENSE) file.

[(Back to the top)](#inditex-core-platform-technical-test)

## Author

Developed by [German Muñoz Romano](https://github.com/germanmr)

[(Back to the top)](#inditex-core-platform-technical-test)