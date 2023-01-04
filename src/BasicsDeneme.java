import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
public class BasicsDeneme {
    @Test

    public static void main(String[] args) {

        String baseURI = "https://rahulshettyacademy.com";
        String response = given().when().baseUri(baseURI).queryParam("key", "qaclick123")
                .header("Content-Type", "application/json").body("{\n" +
                        "  \"location\": {\n" +
                        "    \"lat\": -38.383494,\n" +
                        "    \"lng\": 33.427362\n" +
                        "  },\n" +
                        "  \"accuracy\": 50,\n" +
                        "  \"name\": \"Newcastle house\",\n" +
                        "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                        "  \"address\": \"NE62EA, side layout, cohen 189\",\n" +
                        "  \"types\": [\n" +
                        "    \"shoe park\",\n" +
                        "    \"shop\"\n" +
                        "  ],\n" +
                        "  \"website\": \"http://google.com\",\n" +
                        "  \"language\": \"French-IN\"\n" +
                        "}").when().post().then().assertThat().statusCode(200).toString();
    }
}
