### Install and generate Jacoco Report

    mvn clean install

generates the jacoco report that can be found in the Jacoco Aggregate Module

Location:

Windows

    \jacoco-aggregate\target\site\jacoco-aggregate\index.html

Linux/Mac

    /jacoco-aggregate/target/site/jacoco-aggregate/index.html

Run com.inditex.rater.domain.RaterApplication in Container module

A valid request using Curl or access the [Swagger doc URL](HTTP://LOCALHOST:8181/swagger)

    curl --location 'http://localhost:8181/rate' \
        --header 'Content-Type: application/json' \
        --data '{
            "brandId": 1,
            "productId": 35455,
            "applyDate": "2020-06-16T21:00:00.000-00:00"
    }'

Expected reply

    {
        "brandId": 1,
        "productId": 35455,
        "startDate": "2020-06-15T16:00:00Z",
        "endDate": "2020-12-31T23:59:59Z",
        "priceList": 4,
        "finalPrice": 38.95
    }


An invalid request, in this case without the "brandId" attribute

    curl --location 'http://localhost:8181/rate' \
    --header 'Content-Type: application/json' \
    --data '{
        "productId": 1,
        "applyDate": "2020-06-16T21:00:00.000-00:00"
    }'

Expected reply

    {
        "code": "Bad Request",
        "message": "brandId no debe ser nulo"
    }

Technologies:
* Hexagonal
* Spring Boot
* Java 17
* OpenAPI
* Lombok
* Jacoco
* MapStruct
* Immutables
* H2 Database
