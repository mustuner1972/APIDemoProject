package serialize;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class jsonApiTest {
    public static void main(String[] args) {

        //serialzeTest de json body java ya cevrilip yapilan islemin json body ile yapilmasini denedim.

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

        String bodyLast = "{\"location\":{\"lat\":\"9.2332\",\"lng\":\"7.23213\"},\"accuracy\":50,\"name\":\"George\",\"phoneNumber\":\"+905327149999\",\"address\":\"189 St Peters Road\",\"webSite\":\"https://rahulshettyacademy.com\",\"language\":\"French\",\"types\":null}";
//"location":{"lat":"9.2332","lng":"7.23213"},"accuracy":50,"name":"George","phoneNumber":"+905327149999","address":"189 St Peters Road","webSite":"https://rahulshettyacademy.com","language":"French","types":null

    String bodyLast2 = "\"location\":{\"lat\":\"9.2332\",\"lng\":\"7.23213\"},\"accuracy\":50,\"name\":\"George\",\"phoneNumber\":\"+905327149999\",\"address\":\"189 St Peters Road\",\"webSite\":\"https://rahulshettyacademy.com\",\"language\":\"French\",\"types\":null";

    //{"location":{"lat":"9.2332","lng":"7.23213"},"accuracy":50,"name":"George",
        // "phoneNumber":"+905327149999","address":"189 St Peters Road",
        // "webSite":"https://rahulshettyacademy.com","language":"French","types":null}

        Response response = given().log().all()
                .queryParam("key","qaclick123")
                .body(bodyLast)
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
