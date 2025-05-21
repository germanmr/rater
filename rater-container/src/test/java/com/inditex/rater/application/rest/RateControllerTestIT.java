package com.inditex.rater.application.rest;

import com.inditex.rater.domain.RaterApplication;
import com.inditex.rater.model.RateResponseDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RaterApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles({"test"})
class RateControllerTestIT {

    @LocalServerPort
    private Integer port;

    @Autowired
    private RateController rateController;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void can_rate_product_all_test_cases(
            final String applyDate,
            final RateResponseDto rateResponseDto) {

        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;

        RestAssured.given().contentType(ContentType.JSON)
                .body("{\"brandId\": 1,\"productId\": 35455,\"applyDate\": \"" + applyDate + "\"}")
                .when()
                .post("/rate")
                .then()
                .statusCode(200)
                .body("brandId", comparesEqualTo(matcherLongUnboxing(rateResponseDto.getBrandId())))
                .body("productId", comparesEqualTo(matcherLongUnboxing(rateResponseDto.getProductId())))
                .body("priceList", comparesEqualTo(matcherLongUnboxing(rateResponseDto.getPriceList())))
                .body("startDate", equalTo(rateResponseDto.getStartDate().format(dateTimeFormatter)))
                .body("endDate", equalTo(rateResponseDto.getEndDate().format(dateTimeFormatter)))
                .body("finalPrice", comparesEqualTo(rateResponseDto.getFinalPrice()));
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("2020-06-14T10:00:00.000-00:00",
                        new RateResponseDto(1L, 35455L,
                                OffsetDateTime.of(2020, 6, 14, 0, 0, 0, 0, ZoneOffset.UTC),
                                OffsetDateTime.of(2020, 12, 31, 23, 59, 59, 0, ZoneOffset.UTC),
                                1L, 35.50F)),
                Arguments.of("2020-06-14T16:00:00.000-00:00",
                        new RateResponseDto(1L, 35455L,
                                OffsetDateTime.of(2020, 6, 14, 15, 0, 0, 0, ZoneOffset.UTC),
                                OffsetDateTime.of(2020, 6, 14, 18, 30, 0, 0, ZoneOffset.UTC),
                                2L, 25.45F)),
                Arguments.of("2020-06-14T21:00:00.000-00:00",
                        new RateResponseDto(1L, 35455L,
                                OffsetDateTime.of(2020, 6, 14, 0, 0, 0, 0, ZoneOffset.UTC),
                                OffsetDateTime.of(2020, 12, 31, 23, 59, 59, 0, ZoneOffset.UTC),
                                1L, 35.50F)),
                Arguments.of("2020-06-15T10:00:00.000-00:00",
                        new RateResponseDto(1L, 35455L,
                                OffsetDateTime.of(2020, 6, 15, 0, 0, 0, 0, ZoneOffset.UTC),
                                OffsetDateTime.of(2020, 6, 15, 11, 0, 0, 0, ZoneOffset.UTC),
                                3L, 30.50F)),
                Arguments.of("2020-06-16T21:00:00.000-00:00",
                        new RateResponseDto(1L, 35455L,
                                OffsetDateTime.of(2020, 6, 15, 16, 0, 0, 0, ZoneOffset.UTC),
                                OffsetDateTime.of(2020, 12, 31, 23, 59, 59, 0, ZoneOffset.UTC),
                                4L, 38.95F))
        );
    }

    /**
     * Util method to avoid the addition of "L" suffix when unboxing Long
     *
     * @param value a {@link java.lang.Long} value
     * @return Integer
     */
    private Integer matcherLongUnboxing(final Long value) {
        return Integer.valueOf(value + "");
    }

}