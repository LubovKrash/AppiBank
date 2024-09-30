package ru.netology.web.data;

import com.codeborne.selenide.Selenide;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiSend {
    private static final RequestSpecification reqSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(9999)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();
    private ApiSend () {

    }

    static Generator.RegistrationApi sendRequset(Generator.RegistrationApi user) {
        given()
                .spec(reqSpec)
                .body(user)
                .when().log().all()
                .post("/api/system/users")
                .then().log().all()
                .statusCode(200);
        return user;
    }
}
