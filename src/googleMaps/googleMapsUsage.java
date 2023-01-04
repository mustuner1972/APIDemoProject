package googleMaps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import serialize.LOCATION;
import serialize.getlOCATION;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class googleMapsUsage {
    public static void main(String[] args) {
        getlOCATION map = new getlOCATION();
        map.setAccuracy(50);
        map.setAddress("New address");
        map.setLanguage("German");
        map.setPhoneNumber("12345678");
        map.setWebSite("https://rahulshettyacademy.com");
        map.setName("New house");

        List <String> newList = new ArrayList<>();
        newList.add("bakery");
        newList.add("bread");

        map.setTypes(newList);
        LOCATION loc = new LOCATION();
        loc.setLng("-23.23232");
        loc.setLat("12.45455");

        map.setLocation(loc);

        RequestSpecification newReq = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("key","qaclick123")
                .setContentType(ContentType.JSON).build();

        ResponseSpecification newResSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();

        //RequestSpecification lastReq = given().log().all().spec(newReq).body(map);

        //Response response = lastReq.when().post("/maps/api/place/add/json")
         //       .then().spec(newResSpec).log().all().extract().response();

        // alternative soln instead of 46 and 48
       Response lastReq2 = given().log().all().spec(newReq).body(map).when()
       .post("/maps/api/place/add/json").then().spec(newResSpec).log().all().extract().response();

        //String responseString = response.asString();
        //System.out.println("responseString = " + responseString);

        String responseAlternative = lastReq2.asString();
        System.out.println("responseAlternative = " + responseAlternative);

    }
}