package serialize;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class serialzeTest {
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

        System.out.println("getlOCATION = " + getlOCATION);

        Response response = given().log().all()
                .queryParam("key","qaclick123")
                .body(getlOCATION)
                .when().post("/maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).extract().response();
        System.out.println("response.asString() = " + response.asString());


        //System.out.println("response.toString() = " + response.toString());
        //System.out.println(response);

        /*Response res=given().log().all().queryParam("key", "qaclick123")
                .body(p)
                .when().post("/maps/api/place/add/json").
                then().assertThat().statusCode(200).extract().response();

        String responseString=res.asString();
        System.out.println(responseString);*/


    }
}
