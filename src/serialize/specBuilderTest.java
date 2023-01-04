package serialize;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class specBuilderTest {
    public static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        getlOCATION getlOCATION = new getlOCATION();
        getlOCATION.setAccuracy(50);
        getlOCATION.setAddress("189 St Peters Road");
        getlOCATION.setLanguage("French");
        getlOCATION.setName("George");
        getlOCATION.setPhoneNumber("+905327149999");
        getlOCATION.setWebSite("https://rahulshettyacademy.com");

        List<String> myList = new ArrayList<>();
        myList.add("shoe park");
        myList.add("shop");

        LOCATION location = new LOCATION();
        location.setLat("9.2332");
        location.setLng("7.23213");
        getlOCATION.setLocation(location);
        //System.out.println("getlOCATION = " + getlOCATION);

        RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("key","qaclick123")
                        .setContentType(ContentType.JSON).build();

        ResponseSpecification responseSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();


        RequestSpecification requestSpecification = given().spec(req).log().all()
                .body(getlOCATION);

        Response response = requestSpecification.when().post("/maps/api/place/add/json")
                .then().log().all().spec(responseSpec).extract().response();
        System.out.println("response.asString() = " + response.asString());

    }
}
